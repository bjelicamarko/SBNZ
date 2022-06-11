package com.siit.sbnz.timdarmar.services;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeDTO;

public interface EmployeeService {

	List<Employee> getEmployeesFromRecommendation(RequestForEmployee requestForEmployee, Set<AreaOfExpertise> expertises,
			List<String> languages);
	
	List<Employee> findNonFriendsOfEmployee(Long id, List<Long> friendsList);
	
	Employee findEmployeeByEmail(String email);
	
	Employee getEmployeeWithFriends(Long id);
	
	void updateEmployee(EmployeeDTO emp, Employee e);
	
	Employee searchFriendNetworkForOneWithExperience(Long id, String specialization);
}
