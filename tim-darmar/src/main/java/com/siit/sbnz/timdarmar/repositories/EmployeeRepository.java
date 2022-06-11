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
	
	@Query("select distinct e from Employee e"
			+ " where e.blocked = false and e.deleted = false")
	List<Employee> findAllActiveEmployees();
	
	@Query("select distinct e from Employee e left join fetch e.areaOfExpertises"
			+ " left join fetch e.workExperiences where e.blocked = false and e.deleted = false and e.email = ?1")
	Employee findEmployeeByEmail(String email);
	
	@Query("select distinct e from Employee e left join fetch e.friendsGroup"
			+ " where e.id=?1 and e.blocked = false and e.deleted = false")
	Employee findEmployeeWithFriends(Long id);
	
	@Query("select distinct e from Employee e"
			+ " where e.id != ?1 and e.blocked = false and e.deleted = false and e.id not in ?2")
	List<Employee> findNonFriendsOfEmployee(Long id, List<Long> friendsList);
}
