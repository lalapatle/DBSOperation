package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.AssociateProf;

@Repository
public interface OperationRepository extends JpaRepository <AssociateProf, Integer>
{

}
