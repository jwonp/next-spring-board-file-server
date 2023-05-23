package com.ikiningyou.file.service;

import com.ikiningyou.file.config.FileStorageProperties;
import com.ikiningyou.file.model.dto.SavedFileName;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class StorageService {

  private String uploadPath;

  public StorageService(FileStorageProperties fileStorageProperties) {
    this.uploadPath = fileStorageProperties.getUploadDir();
  }

  private String getRandomStr() {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 13;
    Random random = new Random();
    String generatedString = random
      .ints(leftLimit, rightLimit + 1)
      .limit(targetStringLength)
      .collect(
        StringBuilder::new,
        StringBuilder::appendCodePoint,
        StringBuilder::append
      )
      .toString();
    System.out.println("random : " + generatedString);
    return generatedString;
  }

  public List<String> saveFiles(MultipartFile[] files, String postName)
    throws IOException {
    String randomStr = getRandomStr();
    List<String> fileNames = new ArrayList<>();
    for (MultipartFile file : files) {
      fileNames.add(
        randomStr + StringUtils.cleanPath(file.getOriginalFilename())
      );
    }
    Path uploadPath = Paths.get(this.uploadPath + "/" + postName);
    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
      System.out.println("make dir : " + uploadPath.toString());
    }
    for (int i = 0; i < files.length; i++) {
      try (InputStream inputStream = files[i].getInputStream()) {
        Path filePath = uploadPath.resolve(fileNames.get(i));
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException ioe) {
        throw new IOException(
          "Could not save image file: " + fileNames.get(i),
          ioe
        );
      }
    }
    return fileNames;
  }

  public SavedFileName saveFile(MultipartFile file, String userName)
    throws IOException {
    //file`s content type only allow "image/"" yet
    if (file.getContentType().startsWith("image/") == false) return null;
    String randomStr = getRandomStr();

    String fileContentType = file.getContentType().replace("image/", ".");
    String fileNameOnStorage = randomStr;
    String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
    log.info("this upload path is {}", this.uploadPath);
    Path uploadPath = Paths.get(this.uploadPath + "/" + userName);
    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    try (InputStream inputStream = file.getInputStream()) {
      Path filePath = uploadPath.resolve(fileNameOnStorage + fileContentType);
      Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
      SavedFileName savedFileName = SavedFileName
        .builder()
        .fileNameOnStorage(fileNameOnStorage)
        .originalFileName(originalFileName)
        .contentType(fileContentType)
        .build();
      return savedFileName;
    } catch (IOException ioe) {
      throw new IOException(
        "Could not save image file: " + fileNameOnStorage,
        ioe
      );
    }
  }

  public Resource loadFileAsResource(String userName, String fileName)
    throws Exception {
    Path uploadPath = Paths.get(this.uploadPath + "/" + userName);
    try {
      Path filePath = uploadPath.resolve(fileName).normalize();
      log.info("file path is {}", filePath.toString());
      Resource resource = new UrlResource(filePath.toUri());
      if (resource.exists()) {
        return resource;
      } else {
        throw new Exception("File not found " + fileName);
      }
    } catch (MalformedURLException ex) {
      throw new Exception("File not found " + fileName, ex);
    }
  }
}
