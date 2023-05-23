package com.ikiningyou.file.model;

import com.ikiningyou.file.model.serializable.FileId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@IdClass(FileId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "File")
public class File {

  @Id
  @Column(name = "name_on_storage")
  private String fileNameOnStorage;

  @Column(name = "original_name", nullable = false)
  private String originalName;

  @Column(name = "path", nullable = false)
  private String path;

  @Column(name = "content_id")
  private Long contentId;
}
