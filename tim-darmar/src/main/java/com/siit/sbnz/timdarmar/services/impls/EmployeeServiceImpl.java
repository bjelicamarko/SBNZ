package com.siit.sbnz.timdarmar.services.impls;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.runtime.rule.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeDTO;
import com.siit.sbnz.timdarmar.models.enums.StatusOfEmployee;
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
		kieSession.getAgenda().getAgendaGroup("languages_typesOfEmployments_status").setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("workingHours_salary").setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup("previous_work_experiences").setFocus();
		kieSession.fireAllRules();
		
		kieSession.dispose();
		
		Collections.sort(employees, 
				Collections.reverseOrder((s1, s2) -> Double.valueOf(s1.getPoints()).compareTo(Double.valueOf(s2.getPoints()))));
		
		return employees;
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		return employeeRepository.findEmployeeByEmail(email);
	}

	@Override
	public void updateEmployee(EmployeeDTO emp, Employee e) {
		e.setPreferredSalary(emp.getPreferredSalary());
		e.setPreferredWorkingHours(emp.getPreferredWorkingHours());
		e.setStatusOfEmployee(StatusOfEmployee.valueOf(emp.getStatusOfEmployee()));
		e.setLanguages(emp.getLanguages());
		e.setAreaOfExpertises(emp.getAreaOfExpertises());
		employeeRepository.save(e);
	}

	@Override
	public Employee getEmployeeWithFriends(Long id) {
		return employeeRepository.findEmployeeWithFriends(id);
	}

	@Override
	public List<Employee> findNonFriendsOfEmployee(Long id, List<Long> friendsList) {
		return employeeRepository.findNonFriendsOfEmployee(id, friendsList);
	}

	@Override
	@Transactional
	public Employee searchFriendNetworkForOneWithExperience(Long id, String specialization) {
		KieBase kieBase = kieContainer.getKieBase("backward_chain");
		KieSession kieSession = kieBase.newKieSession();
		
		List<Employee> emps = employeeRepository.findAllActiveEmployees();
		for (Employee em : emps) { //ovo treba da bude lista svih drugara od onog za koga trazimo
			kieSession.insert(em);
		}
		
		HashSet<Long> initSet = new HashSet<Long>();
		initSet.add(id);

		QueryResults results = kieSession.getQueryResults("hasFriend", new Object[] {  Variable.v, id, specialization, initSet, new HashSet<Long>()});
		
		HashSet<String> setic = new HashSet<String>();
		System.out.println("results");
		Long resLong = null;
		for (QueryResultsRow queryResult : results) {
			HashSet<Long> resID = (HashSet<Long>) queryResult.get("rez");
			resLong = resID.iterator().next();
			System.out.println(resLong);
		}
		
		for (Employee em : emps) { 
			if (em.getId().equals(resLong)) {
				kieSession.dispose();
				return em;
			}
		}
		kieSession.dispose();
		return null;
	}

	@Override
	@Transactional
	public Employee addFriend(Employee emp, Long friend) {
		Optional<Employee> fr = employeeRepository.findById(friend);
		if (!fr.isPresent()) {
			return null;
		}
		
		Optional<Employee> original = employeeRepository.findById(emp.getId());
		Employee origi = original.get();
		
		origi.getFriendsGroup().add(fr.get());
		employeeRepository.save(origi);
		return fr.get();
	}
	
}
