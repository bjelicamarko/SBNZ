package com.siit.sbnz.timdarmar.services.impls;

import java.util.List;
import java.util.Set;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.repositories.EmployeeRepository;
import com.siit.sbnz.timdarmar.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private KieContainer kieContainer;
	
	@Override
	public List<Employee> getEmployeesFromRecommendation(RequestForEmployee requestForEmployee,
			Set<AreaOfExpertise> expertises, List<String> languages) {
		
		List<Employee> employees = employeeRepository.findAllEmployees();
		
		KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
		
		for (Employee e : employees)
			kieSession.insert(e);
		
		kieSession.insert(requestForEmployee);
		kieSession.insert(expertises);
		kieSession.insert(languages);
		
		kieSession.getAgenda().getAgendaGroup("expertises_specializations").setFocus();
		kieSession.fireAllRules();
		
		return employees;
	}
	
}
