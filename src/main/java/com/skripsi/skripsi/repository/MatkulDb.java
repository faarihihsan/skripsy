package com.skripsi.skripsi.repository;

import com.skripsi.skripsi.model.MatkulModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatkulDb extends JpaRepository<MatkulModel, Long> {
    MatkulModel findById(Integer id);
}
