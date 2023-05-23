package com.ikiningyou.file.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

  private String uploadDir;

  public String getUploadDir() {
    log.info("uploadDir is {}", uploadDir);
    return uploadDir;
  }

  public void setUploadDir(String uploadDir) {
    this.uploadDir = uploadDir;
  }
}
