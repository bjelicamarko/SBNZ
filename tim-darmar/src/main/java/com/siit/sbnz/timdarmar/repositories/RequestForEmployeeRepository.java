package com.siit.sbnz.timdarmar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;


@Repository
public interface RequestForEmployeeRepository  extends JpaRepository<RequestForEmployee, Long> {

	@Query(value = "select r from RequestForEmployee r left join fetch r.areaOfExpertises"
			+ " where r.employer.email = ?1 order by r.id desc")
	List<RequestForEmployee> getRequests(String email);
}
