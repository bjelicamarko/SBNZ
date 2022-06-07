package com.siit.sbnz.timdarmar.services;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;

public interface EmployeeService {

	List<Employee> getEmployeesFromRecommendation(RequestForEmployee requestForEmployee, Set<AreaOfExpertise> expertises,
			List<String> languages);
}
