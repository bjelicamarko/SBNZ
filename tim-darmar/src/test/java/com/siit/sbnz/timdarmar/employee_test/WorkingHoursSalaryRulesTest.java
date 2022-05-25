package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

public class WorkingHoursSalaryRulesTest {

	private static KieContainer kieContainer;
	
	private static final String agenda = "workingHours_salary";
	
	private static List<Employee> employees = new ArrayList<>();
	private static RequestForEmployee requestForEmployee = new RequestForEmployee();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        requestForEmployee.setTypeOfEmployment(TypeOfEmployment.FULL_TIME);
        requestForEmployee.setRequiredSalary(10000.0);
        
        Employee e = new Employee();
        e.setPoints(0.5);
        e.setApproval(1);
        e.setPreferredSalary(11000.0);
        
        employees.add(e);
        
	}
	
	@Test
	public void testSalaryRules() {
		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Employee e1 = employees.get(0);
		
		kieSession.insert(e1);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
		
		assertEquals(0.8, e1.getPoints(), 0.1);
		assertEquals(2, e1.getApproval());
		
		kieSession.dispose();
	}
	
	@Test
	public void testWorkingHoursRule_One() {
		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
        Employee e = new Employee();
        e.setPoints(0.5);
        e.setApproval(1);
        e.setPreferredWorkingHours("10:00-18:00");
        requestForEmployee.setRequiredWorkingHours("09:00-19:00");
        
        kieSession.insert(e);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
		
		assertEquals(0.7, e.getPoints(), 0.1);
		assertEquals(2, e.getApproval());
		
		kieSession.dispose();
	}
	
	@Test
	public void testWorkingHoursRule_Two() {
		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
        Employee e = new Employee();
        e.setPoints(0.5);
        e.setApproval(1);
        e.setPreferredWorkingHours("15:00-23:00");
        requestForEmployee.setRequiredWorkingHours("09:00-19:00");
        
        kieSession.insert(e);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
		
		assertEquals(0.6, e.getPoints(), 0.01);
		assertEquals(1, e.getApproval());
		
		kieSession.dispose();
	}
}
