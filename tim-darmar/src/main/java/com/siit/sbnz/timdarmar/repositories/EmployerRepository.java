package com.siit.sbnz.timdarmar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long>{

	@Query("select distinct e from Employer e left join fetch e.requestsForEmployee"
			+ " left join fetch e.requestsForStudent where e.email = ?1")
	Employer findEmployerByEmail(String email);
	
	@Query("select distinct e from Employer e where e.penalty = true")
	List<Employer> findAllBannedEmployers();
	
	@Query("select distinct e from Employer e where e.penalty = false")
	List<Employer> findAllNotBannedEmployers();
	
	@Query("select distinct e from Employer e left join fetch e.requestsForEmployee"
			+ " left join fetch e.requestsForStudent")
	List<Employer> findAllEmployers();
}
