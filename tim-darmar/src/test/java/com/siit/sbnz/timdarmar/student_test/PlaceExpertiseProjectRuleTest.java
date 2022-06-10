package com.siit.sbnz.timdarmar.student_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseIntership;
import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.classes.UniSubject;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.WorkMethods;

public class PlaceExpertiseProjectRuleTest {
	private static KieContainer kieContainer;
	
	private static final String agenda = "place_expertise_project";
	
	private static List<Student> students = new ArrayList<>();
	
	private static RequestForStudent requestForStudent = new RequestForStudent();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        Student s1 = new Student();
        s1.setFinancialStatus(FinancialStatus.POOR);
        
        // PRVI PREDMET
        
        UniSubject uniSubject1 = new UniSubject();
        uniSubject1.setName("OOP");
        
        AreaOfExpertiseIntership a1 = new AreaOfExpertiseIntership();
        a1.setNameOfArea("oop");
        a1.setSpecializations(Stream.of("klase", "nasledjivanje", "gui").collect(Collectors.toList()));
        
        AreaOfExpertiseIntership a2 = new AreaOfExpertiseIntership();
        a2.setNameOfArea("algoritmi");
        a2.setSpecializations(Stream.of("podaci", "algoritmi").collect(Collectors.toList()));
        
        Set<AreaOfExpertiseIntership> areas1 = new HashSet<>();
        areas1.add(a1);
        areas1.add(a2);
        
        uniSubject1.setSubjectAreaOfExpertises(areas1);
        
        // DRUGI PREDMET
        
        UniSubject uniSubject2 = new UniSubject();
        uniSubject2.setName("SBNZ");
        
        AreaOfExpertiseIntership a3 = new AreaOfExpertiseIntership();
        a3.setNameOfArea("oop");
        a3.setSpecializations(Stream.of("drools", "klase", "podaci", "accumulate").collect(Collectors.toList()));
        
        Set<AreaOfExpertiseIntership> areas2 = new HashSet<>();
        areas2.add(a3);
        
        uniSubject2.setSubjectAreaOfExpertises(areas2);
        
        // PREDMETI DODAVANJE
        
        Set<UniSubject> subjects = new HashSet<>();
        subjects.add(uniSubject1);
        subjects.add(uniSubject2);
        
        s1.setPassedSubjects(subjects);
        
        // PROJEKTI
        
        Project p1 = new Project();
        p1.setMark(8.0);

        Project p2 = new Project();
        p2.setMark(9.0);
        
        Project p3 = new Project();
        p3.setMark(9.0);
        
        Set<Project> projects = new HashSet<Project>();
        projects.add(p1);
        projects.add(p2);
        projects.add(p3);
        
        s1.setUniProjects(projects);
        
        students.add(s1);
        
        // REQUEST
        requestForStudent.setWorkMethods(WorkMethods.FROM_HOME);
        
        AreaOfExpertiseIntership aR = new AreaOfExpertiseIntership();
        aR.setNameOfArea("oop");
        aR.setSpecializations(Stream.of("klase", "podaci").collect(Collectors.toList()));
        
        HashSet<AreaOfExpertiseIntership> setic = new HashSet();
        setic.add(aR);
        
        requestForStudent.setAreaOfExpertiseIntership(setic);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
		KieBase kieBase = kieContainer.getKieBase("student");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Student s1 = students.get(0); 
		RequestForStudent request = requestForStudent;

		kieSession.insert(s1);
		kieSession.insert(request);

		kieSession.fireAllRules();
		
		System.out.println("Points: " + s1.getPoints());
		assertEquals(s1.getPoints(), 17.0, 3);
        
        kieSession.dispose();
	}

}
