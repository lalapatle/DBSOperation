package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.AssociatePersonal;
import com.capgemini.entity.AssociateProf;

@Repository
public interface OperationRepository extends JpaRepository <AssociateProf, Integer>
{
	List<AssociateProf> findByAssociatePersonal(AssociatePersonal associatePersonal);
}
