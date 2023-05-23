package com.ikiningyou.file.repository;

import com.ikiningyou.file.model.File;
import com.ikiningyou.file.model.serializable.FileId;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File, FileId> {
  Optional<File> findByFileNameOnStorage(String fileNameOnStorage);
}
