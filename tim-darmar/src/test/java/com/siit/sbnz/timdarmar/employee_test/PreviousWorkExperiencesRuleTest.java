package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;

public class PreviousWorkExperiencesRuleTest {

	private static KieContainer kieContainer;
	
	private static final String agenda = "previous_work_experiences";
	
	private static List<Employee> employees = new ArrayList<>();
	private static List<Employer> employers = new ArrayList<>();
	private static List<WorkExperience> experiences = new ArrayList<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
       
        Employer e1 = new Employer();
        e1.setId(1L);
        e1.setWorkExperiences(new HashSet<>());
        employers.add(e1);
        
        Employer e2 = new Employer();
        e2.setId(2L);
        e2.setWorkExperiences(new HashSet<>());
        employers.add(e2);
        
        Employer e3 = new Employer();
        e3.setId(3L);
        e3.setWorkExperiences(new HashSet<>());
        employers.add(e3);
        
        
        Employee ee1 = new Employee();
        ee1.setId(4L);
        ee1.setWorkExperiences(new HashSet<>());
        employees.add(ee1);
        
        Employee ee2 = new Employee();
        ee2.setId(5L);
        ee2.setWorkExperiences(new HashSet<>());
        employees.add(ee2);
        
        Employee ee3 = new Employee();
        ee3.setId(6L);
        ee3.setWorkExperiences(new HashSet<>());
        employees.add(ee3);
        
        Employee ee4 = new Employee();
        ee4.setId(7L);
        ee4.setWorkExperiences(new HashSet<>());
        employees.add(ee4);
        
        
        WorkExperience we1 = new WorkExperience();
        we1.setId(1L);
        we1.setEmployer(e1);
        e1.getWorkExperiences().add(we1);
        we1.setEmployee(ee1);
        ee1.getWorkExperiences().add(we1);
        we1.setDateFrom(1653256800L);
        we1.setEmployerRating(8.0);
        experiences.add(we1);
           
        WorkExperience we2 = new WorkExperience();
        we2.setId(2L);
        we2.setEmployer(e1);
        e1.getWorkExperiences().add(we2);
        we2.setEmployee(ee2);
        ee2.getWorkExperiences().add(we2);
        we2.setDateFrom(1653256800L);
        we2.setEmployerRating(9.0);
        experiences.add(we2);
        
        WorkExperience we3 = new WorkExperience();
        we3.setId(3L);
        we3.setEmployer(e1);
        e1.getWorkExperiences().add(we3);
        we3.setEmployee(ee3);
        ee3.getWorkExperiences().add(we3);
        we3.setDateFrom(1653256800L);
        we3.setEmployerRating(7.0);
        experiences.add(we3);
        
        WorkExperience we4 = new WorkExperience();
        we4.setId(4L);
        we4.setEmployer(e2);
        e2.getWorkExperiences().add(we4);
        we4.setEmployee(ee4);
        ee4.getWorkExperiences().add(we4);
        we4.setDateFrom(1653256800L);
        we4.setEmployerRating(6.0);
        experiences.add(we4);
        
        WorkExperience we5 = new WorkExperience();
        we5.setId(5L);
        we5.setEmployer(e2);
        e2.getWorkExperiences().add(we5);
        we5.setEmployee(ee1);
        ee1.getWorkExperiences().add(we5);
        we5.setDateFrom(1653256800L);
        we5.setEmployerRating(7.0);
        experiences.add(we5);
        
        WorkExperience we6 = new WorkExperience();
        we6.setId(6L);
        we6.setEmployer(e2);
        e2.getWorkExperiences().add(we6);
        we6.setEmployee(ee2);
        ee2.getWorkExperiences().add(we6);
        we6.setDateFrom(1653256800L);
        we6.setEmployerRating(8.5);
        experiences.add(we6);
        
        
	}
	
	@Test
	public void testPreviousWorkExperiences() {
		Employee test = new Employee();
		test.setId(8L);
		test.setWorkExperiences(new HashSet<>());
		test.setPoints(0.7);
		test.setApproval(2);
		
		WorkExperience we1 = new WorkExperience();
		we1.setId(7L);
		we1.setEmployer(employers.get(0));
		employers.get(0).getWorkExperiences().add(we1);
		we1.setEmployee(test);
		test.getWorkExperiences().add(we1);
		we1.setDateFrom(1653256800L);
        we1.setEmployerRating(8.0);
        
		WorkExperience we2 = new WorkExperience();
		we2.setId(8L);
		we2.setEmployer(employers.get(1));
		employers.get(1).getWorkExperiences().add(we2);
		we2.setEmployee(test);
		test.getWorkExperiences().add(we2);
		we2.setDateFrom(1653256800L);
        we2.setEmployerRating(9.0);
        
        KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
        kieSession.insert(test);
		kieSession.fireAllRules();
		
		assertEquals(9.2, test.getPoints(), 0.01);
		
		kieSession.dispose();
	}
	
}
