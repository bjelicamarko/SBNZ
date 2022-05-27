package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
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
        
        Employee e2 = new Employee();
        e2.setPoints(0.5);
        e2.setApproval(1);
        e2.setPreferredSalary(8000.0);
        employees.add(e2);
        
        Employee e3 = new Employee();
        e3.setPoints(0.5);
        e3.setApproval(1);
        e3.setPreferredSalary(5000.0);
        employees.add(e3);
	}
	
	@Test
	public void testSalaryRules() {
		KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Employee e1 = employees.get(0); // salary rule one
		Employee e2 = employees.get(1); // salary rule two
		Employee e3 = employees.get(2); // salary rule three
		
		kieSession.insert(e1);
		kieSession.insert(e2);
		kieSession.insert(e3);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
		
		assertEquals(0.8, e1.getPoints(), 0.01);
		assertEquals(2, e1.getApproval());
		
		assertEquals(0.7, e2.getPoints(), 0.01);
		assertEquals(2, e2.getApproval());
		
		assertEquals(0.6, e3.getPoints(), 0.01);
		assertEquals(2, e3.getApproval());
		
		kieSession.dispose();
	}
	
	@Test
	public void testWorkingHoursRule_One() {
		KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
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
		KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
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
