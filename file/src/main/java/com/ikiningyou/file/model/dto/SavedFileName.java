package com.ikiningyou.file.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SavedFileName {

  private String fileNameOnStorage;
  private String originalFileName;
  private String contentType;
}
