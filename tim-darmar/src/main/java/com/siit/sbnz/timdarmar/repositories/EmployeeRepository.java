package com.siit.sbnz.timdarmar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select distinct e from Employee e left join fetch e.areaOfExpertises"
			+ " left join fetch e.workExperiences where e.blocked = false and e.deleted = false")
	List<Employee> findAllEmployees();
}
