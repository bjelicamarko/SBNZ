package com.siit.sbnz.timdarmar.student_test;

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

import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;

public class FinancialStatusStudentRuleTest {
	private static KieContainer kieContainer;
	
	private static final String agenda = "student_financial_status";
	
	private static List<Student> students = new ArrayList<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        Student s1 = new Student();
        s1.setMonthlyIncomeByFamilyMember(2000);
        
        Student s2 = new Student();
        s2.setMonthlyIncomeByFamilyMember(8000);
        
        Student s3 = new Student();
        s3.setMonthlyIncomeByFamilyMember(22000);
        
        students.add(s1);
        students.add(s2);
        students.add(s3);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
		KieBase kieBase = kieContainer.getKieBase("student");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Student s1 = students.get(0); // income 2000 - trebalo bi da bude POOR
		Student s2 = students.get(1);  // income 8000 - trebalo bi da bude MIDDLE_CLASS
		Student s3 = students.get(2); // income 22000 - trebalo bi da bude RICH
		
		kieSession.insert(s1);
		kieSession.insert(s2);
		kieSession.insert(s3);
		kieSession.fireAllRules();
		
		assertEquals(FinancialStatus.POOR, s1.getFinancialStatus());
		assertEquals(FinancialStatus.MIDDLE_CLASS, s2.getFinancialStatus());
		assertEquals(FinancialStatus.RICH, s3.getFinancialStatus());
        
        kieSession.dispose();
	}
}
