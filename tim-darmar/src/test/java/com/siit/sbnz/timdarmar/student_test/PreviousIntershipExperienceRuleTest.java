package com.siit.sbnz.timdarmar.student_test;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseIntership;
import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.MarkMentor;
import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.classes.UniSubject;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.ProjectType;
import com.siit.sbnz.timdarmar.models.enums.WorkMethods;

public class PreviousIntershipExperienceRuleTest {

	private static KieContainer kieContainer;
	
	private static final String agenda = "previous_intership_experience";
	
	private static List<Student> students = new ArrayList<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        Student s1 = new Student();
        
        // PRVI INTERSHIP
        
        Intership i1 = new Intership();
        Instant dateToMili = Instant.now();
        Instant dateFromMili = dateToMili.minus(30, ChronoUnit.DAYS);
        i1.setDateFrom(dateFromMili.toEpochMilli());
        i1.setDateTo(dateToMili.toEpochMilli());
        
        MarkMentor m1 = new MarkMentor();
        m1.setMark(9.0);
        m1.setMentor("Djura");

        MarkMentor m2 = new MarkMentor();
        m2.setMark(9.0);
        m2.setMentor("Pera");
        
        Set<MarkMentor> marks = new HashSet<>();
        marks.add(m1);
        marks.add(m2);
        
        i1.setMentorMarks(marks);
        
        Project p1 = new Project();
        p1.setDifficulty(7);
        p1.setProjectType(ProjectType.INDIVIDUAL);

        Project p2 = new Project();
        p2.setDifficulty(7);
        p2.setProjectType(ProjectType.TEAM);
        
        Set<Project> projects = new HashSet<Project>();
        projects.add(p1);
        projects.add(p2);
        
        i1.setIntershipProjects(projects);
        
        
        // DRUGI INTERSHIP
        
        Intership i2 = new Intership();
        Instant dateToMili2 = Instant.now();
        Instant dateFromMili2 = dateToMili2.minus(23, ChronoUnit.DAYS);
        i2.setDateFrom(dateFromMili2.toEpochMilli());
        i2.setDateTo(dateToMili2.toEpochMilli());
        
        MarkMentor m3 = new MarkMentor();
        m3.setMark(9.0);
        m3.setMentor("Djura");

        MarkMentor m4 = new MarkMentor();
        m4.setMark(9.0);
        m4.setMentor("Pera");
        
        Set<MarkMentor> marks2 = new HashSet<>();
        marks2.add(m3);
        marks2.add(m4);
        
        i2.setMentorMarks(marks2);
        
        Project p3 = new Project();
        p3.setDifficulty(7);
        p3.setProjectType(ProjectType.INDIVIDUAL);

        Project p4 = new Project();
        p4.setDifficulty(7);
        p4.setProjectType(ProjectType.TEAM);
        
        Set<Project> projects2 = new HashSet<Project>();
        projects2.add(p3);
        projects2.add(p4);
        
        i2.setIntershipProjects(projects2);
        
        
        
        Set<Intership> interships = new HashSet<>();
        interships.add(i1);
        interships.add(i2);
        s1.setInterships(interships);
        
        
        
        students.add(s1);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
		KieBase kieBase = kieContainer.getKieBase("student");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Student s1 = students.get(0); 

		kieSession.insert(s1);

		kieSession.fireAllRules();
		
		System.out.println("Points: " + s1.getPoints());
		
		assertEquals(s1.getPoints(), 20.0, 3);
		
        
        kieSession.dispose();
	}
}
