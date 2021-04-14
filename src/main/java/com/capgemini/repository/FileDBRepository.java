package com.capgemini.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Integer> {

}