package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.enums.StatusOfEmployee;
import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

public class EmployeeForwardChaniningTest {
	
	private static KieContainer kieContainer;
	
	private static Set<AreaOfExpertise> expertises = new HashSet<>();
	private static List<String> languages = new ArrayList<>();
	private static RequestForEmployee requestForEmployee = new RequestForEmployee();
	private static List<Employee> employees = new ArrayList<>();
	private static List<Employer> employers = new ArrayList<>();
	private static List<WorkExperience> experiences = new ArrayList<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        AreaOfExpertise globAoe1 = new AreaOfExpertise("Web programiranje", new ArrayList<>(), new Employee(), new RequestForEmployee());
        globAoe1.getSpecializations().add("Java");
        globAoe1.getSpecializations().add("Spring");
        globAoe1.getSpecializations().add(".NET");
        globAoe1.getSpecializations().add("Vue");
        globAoe1.getSpecializations().add("React");
        globAoe1.getSpecializations().add("Angular");
        
        AreaOfExpertise globAoe2 = new AreaOfExpertise("AI", new ArrayList<>(), new Employee(), new RequestForEmployee());
        globAoe2.getSpecializations().add("Machine Learning");
        globAoe2.getSpecializations().add("Soft Kompjuting");
        globAoe2.getSpecializations().add("Racunarska Inteligencija");
        globAoe2.getSpecializations().add("Racunarska Vizija");
        
        AreaOfExpertise globAoe3 = new AreaOfExpertise("Data Science", new ArrayList<>(), new Employee(), new RequestForEmployee());
        globAoe3.getSpecializations().add("SQL");
        globAoe3.getSpecializations().add("MY SQL");
        globAoe2.getSpecializations().add("Mongo");
        
        expertises.add(globAoe1);
        expertises.add(globAoe2);
        expertises.add(globAoe3);
        requestForEmployee.setAreaOfExpertises(expertises);;
        
        languages.add("French");
        languages.add("English");
        languages.add("Serbian");
        languages.add("Italian");
        requestForEmployee.setRequiredLanguages(languages);
        
        requestForEmployee.setTypeOfEmployment(TypeOfEmployment.FULL_TIME);
        requestForEmployee.setRequiredSalary(10000.0);
        requestForEmployee.setRequiredWorkingHours("09:00-19:00");
        
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
	public void testForwardChainining_One() {
		KieSession kieSession = kieContainer.newKieSession("ksession-rule");
		
		Employee e = new Employee();
		e.setId(8L);
        e.setAreaOfExpertises(new HashSet<>());
        AreaOfExpertise aoe = new AreaOfExpertise("Web programiranje", new ArrayList<>(), e, new RequestForEmployee());
        aoe.getSpecializations().add("Java");
        aoe.getSpecializations().add("Spring");
        e.getAreaOfExpertises().add(aoe);
        e.setLanguages(new ArrayList<>());
        e.getLanguages().add("French");
        e.getLanguages().add("Italian");
        e.setStatusOfEmployee(StatusOfEmployee.UNEMPLOYED);
        
        e.setWorkExperiences(new HashSet<>());
        WorkExperience we1 = new WorkExperience();
        we1.setId(7L);
        we1.setTypeOfEmployment(TypeOfEmployment.FULL_TIME);
        we1.setEmployer(employers.get(0));
        employers.get(0).getWorkExperiences().add(we1);
        we1.setEmployee(e);
        we1.setDateFrom(1653256800L);
        we1.setEmployerRating(8.0);
        e.getWorkExperiences().add(we1);
        
        WorkExperience we2 = new WorkExperience();
        we2.setId(8L);
        we2.setTypeOfEmployment(TypeOfEmployment.FULL_TIME);
        we2.setEmployer(employers.get(1));
        employers.get(1).getWorkExperiences().add(we2);
        we2.setEmployee(e);
        we2.setDateFrom(1653256800L);
        we2.setEmployerRating(9.0);
        e.getWorkExperiences().add(we2);
        
        WorkExperience we3 = new WorkExperience();
        we2.setId(9L);
        we3.setTypeOfEmployment(TypeOfEmployment.PART_TIME);
        e.getWorkExperiences().add(we3);
        
        e.setPreferredSalary(11000.0);
        e.setPreferredWorkingHours("10:00-18:00");
        
        
        kieSession.insert(e);
		kieSession.insert(expertises);
		kieSession.insert(languages);
		kieSession.insert(requestForEmployee);
		
		kieSession.getAgenda().getAgendaGroup("expertises_specializations").setFocus();
		kieSession.fireAllRules();
		assertEquals(0.3, e.getPoints(), 0.01);
		kieSession.getAgenda().getAgendaGroup("languages_typesOfEmployments_status").setFocus();
		kieSession.fireAllRules();
		assertEquals(0.9, e.getPoints(), 0.01);
		assertEquals(1, e.getApproval());
		kieSession.getAgenda().getAgendaGroup("workingHours_salary").setFocus();
		kieSession.fireAllRules();
		assertEquals(1.4, e.getPoints(), 0.01);
		assertEquals(3, e.getApproval());
		kieSession.getAgenda().getAgendaGroup("previous_work_experiences").setFocus();
		kieSession.fireAllRules();
		assertEquals(9.9, e.getPoints(), 0.01);
		
		kieSession.dispose();
	}
}
