package com.ikiningyou.file.controller;

import com.ikiningyou.file.model.dto.ImageConfirmRequest;
import com.ikiningyou.file.model.dto.SavedFileName;
import com.ikiningyou.file.payload.SingleImageResponse;
import com.ikiningyou.file.service.FileService;
import com.ikiningyou.file.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
@Slf4j
public class FileController {

  @Autowired
  private StorageService storageService;

  @Autowired
  private FileService fileService;

  @PatchMapping("/images")
  public ResponseEntity<Boolean> confirmImagesByContentId(
    @RequestBody ImageConfirmRequest imageConfirmRequest
  ) {
    boolean isSuccessed = fileService.confirmImagesByContentId(
      imageConfirmRequest
    );
    return ResponseEntity.status(isSuccessed ? 200 : 400).body(isSuccessed);
  }

  @PostMapping("/upload/single")
  public ResponseEntity<SingleImageResponse> uploadSingleImage(
    @RequestParam("file") MultipartFile file,
    @RequestParam("username") String userName
  ) throws IOException {
    try {
      SavedFileName savedFileName = storageService.saveFile(file, userName);
      log.info(
        "stoarge name is {}, original is {}, content type is {} t",
        savedFileName.getFileNameOnStorage(),
        savedFileName.getOriginalFileName(),
        savedFileName.getContentType()
      );
      String path = "/" + userName + "/";

      fileService.saveFileMeta(savedFileName, path);

      SingleImageResponse res = SingleImageResponse
        .builder()
        .fileNameOnStoarge(
          savedFileName.getFileNameOnStorage() + savedFileName.getContentType()
        )
        .imageLocation(path)
        .message("done")
        .success(true)
        .build();
      return ResponseEntity.status(200).body(res);
    } catch (Exception e) {
      SingleImageResponse res = SingleImageResponse
        .builder()
        .message("failed")
        .success(false)
        .build();

      return ResponseEntity.status(201).body(res);
    }
  }

  // @PostMapping("/upload/multi")
  // public ResponseEntity<Response> uploadMultipleImage(
  //   @RequestParam("files") MultipartFile[] files,
  //   @RequestParam("postName") String postName
  // ) {
  //   Response res = new Response();
  //   List<String> results = new ArrayList<>();
  //   List<String> imageLocations = new ArrayList<>();
  //   try {
  //     results = storageService.saveFiles(files, postName);
  //     for (String result : results) {
  //       imageLocations.add("/" + postName + "/" + result);
  //     }
  //     res.setImageLocations(imageLocations);
  //     res.setMessage("done");
  //     res.setSuccess(true);
  //     return new ResponseEntity<Response>(res, HttpStatus.OK);
  //   } catch (Exception e) {
  //     res.setMessage("failed");
  //     res.setSuccess(false);
  //     return new ResponseEntity<Response>(
  //       res,
  //       HttpStatus.INTERNAL_SERVER_ERROR
  //     );
  //   }
  // }

  @GetMapping("/display/{userName}/{fileName:.+}")
  public ResponseEntity<Resource> displayImage(
    @PathVariable String fileName,
    @PathVariable String userName,
    HttpServletRequest request
  ) throws Exception {
    // Load file as Resource
    Resource resource = storageService.loadFileAsResource(userName, fileName);

    // Try to determine file's content type
    String contentType = null;
    try {
      contentType =
        request
          .getServletContext()
          .getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException ex) {
      log.info("Could not determine file type.");
    }

    // Fallback to the default content type if type could not be determined
    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity
      .ok()
      .contentType(MediaType.parseMediaType(contentType))
      .header(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + resource.getFilename() + "\""
      )
      .body(resource);
  }
}
