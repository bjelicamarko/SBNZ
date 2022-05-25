package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.enums.StatusOfEmployee;
import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

public class LanguagesTypesOfEmploymentStatusRulesTest {

	private static KieContainer kieContainer;
	
	private static final String agenda = "languages_typesOfEmployments_status";
	
	private static List<Employee> employees = new ArrayList<>();
	private static List<String> languages = new ArrayList<>();
	private static RequestForEmployee requestForEmployee = new RequestForEmployee();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        languages.add("French");
        languages.add("English");
        languages.add("Serbian");
        languages.add("Italian");
        
        requestForEmployee.setTypeOfEmployment(TypeOfEmployment.FREELANCE);
        
        Employee e1 = new Employee();
        e1.setLanguages(new ArrayList<>());
        e1.getLanguages().add("French");
        e1.getLanguages().add("Italian");
        e1.setStatusOfEmployee(StatusOfEmployee.UNEMPLOYED);
        e1.setPoints(0.2); // da bi se pokrenula pravila
        e1.setWorkExperiences(new HashSet<>());
        
        WorkExperience we1 = new WorkExperience();
        we1.setTypeOfEmployment(TypeOfEmployment.FREELANCE);
        e1.getWorkExperiences().add(we1);
        
        WorkExperience we2 = new WorkExperience();
        we2.setTypeOfEmployment(TypeOfEmployment.FREELANCE);
        e1.getWorkExperiences().add(we2);
        
        WorkExperience we3 = new WorkExperience();
        we3.setTypeOfEmployment(TypeOfEmployment.PART_TIME);
        e1.getWorkExperiences().add(we3);
        
        employees.add(e1);
        
        Employee e2 = new Employee();
        e2.setLanguages(new ArrayList<>());
        e2.getLanguages().add("Serbian");
        e2.setStatusOfEmployee(StatusOfEmployee.EMPLOYED);
        e2.setPoints(0.2);
        e2.setWorkExperiences(new HashSet<>());
        
        WorkExperience we4 = new WorkExperience();
        we4.setTypeOfEmployment(TypeOfEmployment.FREELANCE);
        e2.getWorkExperiences().add(we4);
        
        WorkExperience we5 = new WorkExperience();
        we5.setTypeOfEmployment(TypeOfEmployment.FULL_TIME);
        e1.getWorkExperiences().add(we5);
        
        employees.add(e2);
        
        Employee e3 = new Employee();
        e3.setLanguages(new ArrayList<>());
        e3.getLanguages().add("English");
        e3.getLanguages().add("Serbian");
        e3.getLanguages().add("French");
        e3.setStatusOfEmployee(StatusOfEmployee.UNEMPLOYED);
        e3.setPoints(0.2);
        e3.setWorkExperiences(new HashSet<>());
        employees.add(e3);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Employee e1 = employees.get(0);
		
		// FactHandle handle = kieSession.insert(e1);
		// kieSession.delete(handle);
		kieSession.insert(e1);
		kieSession.insert(languages);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
	
		assertEquals(0.8, e1.getPoints(), 0.1);
		assertEquals(1, e1.getApproval());
		
		Employee e2 = employees.get(1);
        // RESET kieSession
		kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		kieSession.insert(e2);
		kieSession.insert(languages);
		kieSession.insert(requestForEmployee);
		kieSession.fireAllRules();
		
        assertEquals(0.4, e2.getPoints(), 0.1);
        assertEquals(1, e1.getApproval());
        
        kieSession.dispose();
	}
}
