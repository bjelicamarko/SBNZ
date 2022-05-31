package com.siit.sbnz.timdarmar.cep_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.enums.EmployerCarelessnessType;
import com.siit.sbnz.timdarmar.models.enums.EmployerRecklessnessType;
import com.siit.sbnz.timdarmar.models.events.MarkedWorkExperienceEvent;
import com.siit.sbnz.timdarmar.models.events.UnmarkedWorkExperienceEvent;
import com.siit.sbnz.timdarmar.models.events.UnpaidWorkExperienceEvent;

public class CepRulesTest {
	
	private static KieContainer kieContainer;
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
	}
	
	@Test
	public void testCarelessEvent() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		Employer e = new Employer();
		e.setId(1L);
		WorkExperience we = new WorkExperience();
		we.setId(1L);
		we.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un1 = new UnmarkedWorkExperienceEvent(e, we);
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un2 = new UnmarkedWorkExperienceEvent(e, we2);
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un3 = new UnmarkedWorkExperienceEvent(e, we3);
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un4 = new UnmarkedWorkExperienceEvent(e, we4);
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un5 = new UnmarkedWorkExperienceEvent(e, we5);
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un6 = new UnmarkedWorkExperienceEvent(e, we6);
		
		Employer e2 = new Employer();
		e2.setId(2L);
		WorkExperience we7 = new WorkExperience();
		we7.setId(7L);
		we7.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un7 = new UnmarkedWorkExperienceEvent(e2, we7);
		WorkExperience we8 = new WorkExperience();
		we8.setId(8L);
		we8.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un8 = new UnmarkedWorkExperienceEvent(e2, we8);
		WorkExperience we9 = new WorkExperience();
		we9.setId(9L);
		we9.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un9 = new UnmarkedWorkExperienceEvent(e2, we9);
		WorkExperience we10 = new WorkExperience();
		we10.setId(10L);
		we10.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un10 = new UnmarkedWorkExperienceEvent(e2, we10);
		WorkExperience we11 = new WorkExperience();
		we11.setId(11L);
		we11.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un11 = new UnmarkedWorkExperienceEvent(e2, we11);
		WorkExperience we12 = new WorkExperience();
		we12.setId(12L);
		we12.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un12 = new UnmarkedWorkExperienceEvent(e2, we12);
		WorkExperience we13 = new WorkExperience();
		we13.setId(13L);
		we13.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un13 = new UnmarkedWorkExperienceEvent(e2, we13);
		WorkExperience we14 = new WorkExperience();
		we14.setId(14L);
		we14.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un14 = new UnmarkedWorkExperienceEvent(e2, we14);
		WorkExperience we15 = new WorkExperience();
		we15.setId(15L);
		we15.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un15 = new UnmarkedWorkExperienceEvent(e2, we15);
		WorkExperience we16 = new WorkExperience();
		we16.setId(16L);
		we16.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un16 = new UnmarkedWorkExperienceEvent(e2, we16);
		WorkExperience we17 = new WorkExperience();
		we17.setId(17L);
		we17.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un17 = new UnmarkedWorkExperienceEvent(e2, we17);
		
		Employer e3 = new Employer();
		e3.setId(3L);
		WorkExperience we18 = new WorkExperience();
		we18.setId(18L);
		we18.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un18 = new UnmarkedWorkExperienceEvent(e3, we18);
		WorkExperience we19 = new WorkExperience();
		we19.setId(19L);
		we19.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un19 = new UnmarkedWorkExperienceEvent(e3, we19);
		WorkExperience we20 = new WorkExperience();
		we20.setId(20L);
		we20.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un20 = new UnmarkedWorkExperienceEvent(e3, we20);
		WorkExperience we21 = new WorkExperience();
		we21.setId(21L);
		we21.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un21 = new UnmarkedWorkExperienceEvent(e3, we21);
		WorkExperience we22 = new WorkExperience();
		we22.setId(22L);
		we22.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un22 = new UnmarkedWorkExperienceEvent(e3, we22);
		WorkExperience we23 = new WorkExperience();
		we23.setId(23L);
		we23.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un23 = new UnmarkedWorkExperienceEvent(e3, we23);
		
		kieSession.insert(un1);
		kieSession.insert(un2);
		kieSession.insert(un3);
		kieSession.insert(un4);
		kieSession.insert(un5);
		kieSession.insert(un6);
		
		kieSession.insert(un7);
		kieSession.insert(un8);
		kieSession.insert(un9);
		kieSession.insert(un10);
		kieSession.insert(un11);
		kieSession.insert(un12);
		kieSession.insert(un13);
		kieSession.insert(un14);
		kieSession.insert(un15);
		kieSession.insert(un16);
		kieSession.insert(un17);
		
		kieSession.insert(un18);
		kieSession.insert(un19);
		kieSession.insert(un20);
		kieSession.insert(un21);
		kieSession.insert(un22);
		kieSession.insert(un23);
		
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	@Test
	public void testRecklessEvent() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		Employer e = new Employer();
		e.setId(1L);
		WorkExperience we = new WorkExperience();
		we.setId(1L);
		we.setDateTo(1651442400000L); // 2.5.2022
		UnpaidWorkExperienceEvent un1 = new UnpaidWorkExperienceEvent(e, we);
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setDateTo(1651442400000L); // 2.5.2022
		UnpaidWorkExperienceEvent un2 = new UnpaidWorkExperienceEvent(e, we2);
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setDateTo(1651442400000L); // 2.5.2022
		UnpaidWorkExperienceEvent un3 = new UnpaidWorkExperienceEvent(e, we3);
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setDateTo(1652133600000L); // 10.5.2022
		UnpaidWorkExperienceEvent un4 = new UnpaidWorkExperienceEvent(e, we4);
//		WorkExperience we5 = new WorkExperience();
//		we5.setId(5L);
//		we5.setDateTo(1652133600000L); // 10.5.2022
//		UnpaidWorkExperienceEvent un5 = new UnpaidWorkExperienceEvent(e, we4);
		
		
		Employer e2 = new Employer();
		e2.setId(2L);
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setDateTo(1651442400000L); // 2.5.2022
		UnpaidWorkExperienceEvent un5 = new UnpaidWorkExperienceEvent(e2, we5);
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setDateTo(1651442400000L); // 2.5.2022
		UnpaidWorkExperienceEvent un6 = new UnpaidWorkExperienceEvent(e2, we6);
		WorkExperience we7 = new WorkExperience();
		we7.setId(7L);
		we7.setDateTo(1652133600000L); // 10.5.2022
		UnpaidWorkExperienceEvent un7 = new UnpaidWorkExperienceEvent(e2, we7);
		WorkExperience we8 = new WorkExperience();
		we8.setId(8L);
		we8.setDateTo(1652133600000L); // 10.5.2022
		UnpaidWorkExperienceEvent un8 = new UnpaidWorkExperienceEvent(e2, we8);
		
		kieSession.insert(un1);
		kieSession.insert(un2);
		kieSession.insert(un3);
		kieSession.insert(un4);
		
		kieSession.insert(un5);
		kieSession.insert(un6);
		kieSession.insert(un7);
		kieSession.insert(un8);
		
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	@Test
	public void testPunishmentOneEvent() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		// little careless and little reckless
		Employer e = new Employer();
		e.setId(1L);
		
		WorkExperience we = new WorkExperience();
		we.setId(1L);
		we.setDateTo(1651442400000L); // 2.5.2022
		UnmarkedWorkExperienceEvent un1 = new UnmarkedWorkExperienceEvent(e, we);
		UnpaidWorkExperienceEvent un11 = new UnpaidWorkExperienceEvent(e, we);
		
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setDateTo(1651442400000L); // 2.5.2022
		UnmarkedWorkExperienceEvent un2 = new UnmarkedWorkExperienceEvent(e, we2);
		UnpaidWorkExperienceEvent un12 = new UnpaidWorkExperienceEvent(e, we2);
		
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setDateTo(1651442400000L); // 2.5.2022
		UnmarkedWorkExperienceEvent un3 = new UnmarkedWorkExperienceEvent(e, we3);
		UnpaidWorkExperienceEvent un13 = new UnpaidWorkExperienceEvent(e, we3);
		
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un4 = new UnmarkedWorkExperienceEvent(e, we4);
		UnpaidWorkExperienceEvent un14 = new UnpaidWorkExperienceEvent(e, we4);
		
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un5 = new UnmarkedWorkExperienceEvent(e, we5);
		
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un6 = new UnmarkedWorkExperienceEvent(e, we6);
		
		kieSession.insert(un1);
		kieSession.insert(un2);
		kieSession.insert(un3);
		kieSession.insert(un4);
		kieSession.insert(un5);
		kieSession.insert(un6);
		
		kieSession.insert(un11);
		kieSession.insert(un12);
		kieSession.insert(un13);
		kieSession.insert(un14);
		
		kieSession.insert(e);
		
		kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(EmployerRecklessnessType.LITTLE_RECKLESS, e.getEmployerRecklessnessType());
		assertEquals(EmployerCarelessnessType.LITTLE_CARELESS, e.getEmployerCarelessnessType());
	}
	
	@Test
	public void testPunishmentTwoEvent() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		// little careless and reckless
		Employer e = new Employer();
		e.setId(1L);
		
		WorkExperience we = new WorkExperience();
		we.setId(1L);
		we.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un1 = new UnmarkedWorkExperienceEvent(e, we);
		UnpaidWorkExperienceEvent un11 = new UnpaidWorkExperienceEvent(e, we);
		
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setDateTo(1652133600000L); //  10.5.2022
		UnmarkedWorkExperienceEvent un2 = new UnmarkedWorkExperienceEvent(e, we2);
		UnpaidWorkExperienceEvent un12 = new UnpaidWorkExperienceEvent(e, we2);
		
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setDateTo(1652133600000L); //  10.5.2022
		UnmarkedWorkExperienceEvent un3 = new UnmarkedWorkExperienceEvent(e, we3);
		UnpaidWorkExperienceEvent un13 = new UnpaidWorkExperienceEvent(e, we3);
		
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un4 = new UnmarkedWorkExperienceEvent(e, we4);
		UnpaidWorkExperienceEvent un14 = new UnpaidWorkExperienceEvent(e, we4);
		
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un5 = new UnmarkedWorkExperienceEvent(e, we5);
		
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setDateTo(1652133600000L); // 10.5.2022
		UnmarkedWorkExperienceEvent un6 = new UnmarkedWorkExperienceEvent(e, we6);
		
		kieSession.insert(un1);
		kieSession.insert(un2);
		kieSession.insert(un3);
		kieSession.insert(un4);
		kieSession.insert(un5);
		kieSession.insert(un6);
		
		kieSession.insert(un11);
		kieSession.insert(un12);
		kieSession.insert(un13);
		kieSession.insert(un14);
		
		kieSession.insert(e);
		
		kieSession.fireAllRules();
		kieSession.dispose();
		
		assertEquals(EmployerRecklessnessType.RECKLESS, e.getEmployerRecklessnessType());
		assertEquals(EmployerCarelessnessType.LITTLE_CARELESS, e.getEmployerCarelessnessType());
	}
	
	@Test
	public void testBanScenario() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		Employer e = new Employer();
		e.setId(1L);
		// little reckless and careless
		WorkExperience we1 = new WorkExperience();
		we1.setId(1L);
		we1.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un1 = new UnmarkedWorkExperienceEvent(e, we1);
		
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un2 = new UnmarkedWorkExperienceEvent(e, we2);
		
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un3 = new UnmarkedWorkExperienceEvent(e, we3);
		
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un4 = new UnmarkedWorkExperienceEvent(e, we4);
		
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un5 = new UnmarkedWorkExperienceEvent(e, we5);
		
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un6 = new UnmarkedWorkExperienceEvent(e, we6);
		
		WorkExperience we7 = new WorkExperience();
		we7.setId(7L);
		we7.setDateTo(1653861600000L);
		UnmarkedWorkExperienceEvent un7 = new UnmarkedWorkExperienceEvent(e, we7);
		UnpaidWorkExperienceEvent unw1 = new UnpaidWorkExperienceEvent(e, we7);
		
		WorkExperience we8 = new WorkExperience();
		we8.setId(8L);
		we8.setDateTo(1652133600000L);
		UnmarkedWorkExperienceEvent un8 = new UnmarkedWorkExperienceEvent(e, we8);
		UnpaidWorkExperienceEvent unw2 = new UnpaidWorkExperienceEvent(e, we8);
		
		WorkExperience we9 = new WorkExperience();
		we9.setId(9L);
		we9.setDateTo(1652133600000L);
		UnmarkedWorkExperienceEvent un9 = new UnmarkedWorkExperienceEvent(e, we9);
		UnpaidWorkExperienceEvent unw3 = new UnpaidWorkExperienceEvent(e, we9);
		
		WorkExperience we10 = new WorkExperience();
		we10.setId(10L);
		we10.setDateTo(1652133600000L);
		UnmarkedWorkExperienceEvent un10 = new UnmarkedWorkExperienceEvent(e, we10);
		UnpaidWorkExperienceEvent unw4 = new UnpaidWorkExperienceEvent(e, we10);
		
		WorkExperience we11 = new WorkExperience();
		we11.setId(11L);
		we11.setDateTo(1652133600000L);
		UnmarkedWorkExperienceEvent un11 = new UnmarkedWorkExperienceEvent(e, we11);
		UnpaidWorkExperienceEvent unw5 = new UnpaidWorkExperienceEvent(e, we11);
		
		WorkExperience we12 = new WorkExperience();
		we12.setId(12L);
		we12.setDateTo(1652133600000L);
		we12.setCompanyRating(5.0);
		we12.setEmployerRating(5.0);
		MarkedWorkExperienceEvent me1 = new MarkedWorkExperienceEvent(e, we12);
		
		WorkExperience we13 = new WorkExperience();
		we13.setId(12L);
		we13.setDateTo(1652133600000L);
		we13.setCompanyRating(5.0);
		we13.setEmployerRating(5.0);
		MarkedWorkExperienceEvent me2 = new MarkedWorkExperienceEvent(e, we13);
		
		kieSession.insert(un1);
		kieSession.insert(un2);
		kieSession.insert(un3);
		kieSession.insert(un4);
		kieSession.insert(un5);
		kieSession.insert(un6);
		kieSession.insert(un7);
		kieSession.insert(un8);
		kieSession.insert(un9);
		kieSession.insert(un10);
		kieSession.insert(un11);
		
		kieSession.insert(unw1);
		kieSession.insert(unw2);
		kieSession.insert(unw3);
		kieSession.insert(unw4);
		kieSession.insert(unw5);
		
		kieSession.insert(me1);
		kieSession.insert(me2);
		
		kieSession.insert(e);
		
		kieSession.fireAllRules();
		kieSession.dispose();
		
		assertTrue(e.isPenalty());
	}
}
