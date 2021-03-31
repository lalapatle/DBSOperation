package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Associate;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Integer>
{

}