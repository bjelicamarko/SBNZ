package com.siit.sbnz.timdarmar.student_test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.StatusOfStudent;

public class BonusPointsRuleTest {
	private static KieContainer kieContainer;
	
	private static final String agenda = "student_bonus_points";
	
	private static List<Student> students = new ArrayList<>();

	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        Student s1 = new Student();
        s1.setPoints(23);
        s1.setStatusOfStudent(StatusOfStudent.DILIGENT_AND_GOOD);
        
        Student s2 = new Student();
        s2.setPoints(16);
        s2.setStatusOfStudent(StatusOfStudent.DILIGENT_AND_EXCELENT);
        
        Student s3 = new Student();
        s3.setPoints(33);
        s3.setStatusOfStudent(StatusOfStudent.DILIGENT_AND_MEDIOCRE);
        
        Student s4 = new Student();
        s4.setPoints(22);
        s4.setStatusOfStudent(StatusOfStudent.BAD);
        
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
//		LocalDateTime now = LocalDateTime.now();
//	    LocalDateTime tenSecondsLater = now.plusMonths(3);
//	    
//	    long diff = TimeUnit.DAYS.convert(86420000, TimeUnit.MILLISECONDS);
//	    System.out.println(diff);

//	    long diff = ChronoUnit.MONTHS.between(now, tenSecondsLater);
//	    System.out.println(diff);
		
		KieBase kieBase = kieContainer.getKieBase("student");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Student s1 = students.get(0); 
		Student s2 = students.get(1); 
		Student s3 = students.get(2);
		Student s4 = students.get(3);
		
		kieSession.insert(s1);
		kieSession.insert(s2);
		kieSession.insert(s3);
		kieSession.insert(s4);
		kieSession.fireAllRules();
		
		assertEquals(41, s1.getPoints(), 2);
		assertEquals(36, s2.getPoints(), 2);
		assertEquals(49, s3.getPoints(), 2);
		assertEquals(17, s4.getPoints(), 2);
        
        kieSession.dispose();
	}
}
