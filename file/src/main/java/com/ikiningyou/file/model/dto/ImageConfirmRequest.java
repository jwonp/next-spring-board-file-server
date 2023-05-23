package com.ikiningyou.file.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ImageConfirmRequest {

  private String[] images;
  private String author;
  private Long contentId;
}
