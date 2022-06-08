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
	
	Employee findEmployeeByEmail(String email);
	
	void updateEmployee(EmployeeDTO emp, Employee e);
}
