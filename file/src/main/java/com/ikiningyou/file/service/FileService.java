package com.ikiningyou.file.service;

import com.ikiningyou.file.model.File;
import com.ikiningyou.file.model.dto.ImageConfirmRequest;
import com.ikiningyou.file.model.dto.SavedFileName;
import com.ikiningyou.file.repository.FileRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class FileService {

  @Autowired
  private FileRepo fileRepo;

  public void saveFileMeta(SavedFileName savedFileName, String path) {
    File file = File
      .builder()
      .fileNameOnStorage(
        savedFileName.getFileNameOnStorage() + savedFileName.getContentType()
      )
      .originalName(savedFileName.getOriginalFileName())
      .path(path)
      .build();
    fileRepo.save(file);
  }

  @Transactional
  public boolean setContentId(
    String author,
    String fileNameOnStorage,
    Long contentId
  ) {
    try {
      Optional<File> rowFile = fileRepo.findByFileNameOnStorage(
        fileNameOnStorage
      );

      if (rowFile.isPresent()) {
        File file = rowFile.get();
        if (file.getPath() != "/" + author + "/") {
          return false;
        }
        file.setContentId(contentId);
        fileRepo.save(file);
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public boolean confirmImagesByContentId(
    ImageConfirmRequest imageConfirmRequest
  ) {
    imageConfirmRequest.getAuthor();

    List<String> images = Arrays.asList(imageConfirmRequest.getImages());
    List<Boolean> isImageConfirmed = new ArrayList<Boolean>();

    images
      .stream()
      .forEach(image -> {
        boolean isConfirmed = setContentId(
          imageConfirmRequest.getAuthor(),
          image,
          imageConfirmRequest.getContentId()
        );
        isImageConfirmed.add(isConfirmed);
      });

    return isImageConfirmed.contains(false) ? false : true;
  }
}
