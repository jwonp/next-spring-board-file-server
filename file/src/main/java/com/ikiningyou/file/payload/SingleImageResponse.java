package com.ikiningyou.file.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingleImageResponse {

  private String fileNameOnStoarge;
  private String message;
  private String imageLocation;

  private boolean success;
}
