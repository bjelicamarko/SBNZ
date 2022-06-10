package com.siit.sbnz.timdarmar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.siit.sbnz.timdarmar.models.classes.WorkExperience;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long>{

	@Query(value = "select w from WorkExperience w where w.employee.email = ?1")
	List<WorkExperience> getWorkExperiencesFromEmployee(String email);
	
	@Query(value = "select w from WorkExperience w where w.employer.email = ?1")
	List<WorkExperience> getWorkExperiencesFromEmployer(String email);
}
