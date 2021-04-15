package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
