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
import com.siit.sbnz.timdarmar.models.events.EmployerWorkExperienceEvent;

public class CepRulesTest {
	
	private static KieContainer kieContainer;
	
	private static final String agenda = "cep";
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
	}
	
	@Test
	public void testPunishmentEvent() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		// little reckless and little careless
		
		Employer e = new Employer();
		e.setId(1L);
		kieSession.insert(e);
		
		WorkExperience we1 = new WorkExperience();
		we1.setId(1L);
		we1.setPaid(true);
		we1.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew1 = new  EmployerWorkExperienceEvent(e, we1);
		
		kieSession.insert(ew1);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setPaid(true);
		we2.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew2 = new  EmployerWorkExperienceEvent(e, we2);
		
		kieSession.insert(ew2);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setPaid(true);
		we3.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew3 = new  EmployerWorkExperienceEvent(e, we3);
		
		kieSession.insert(ew3);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setPaid(true);
		we4.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew4 = new  EmployerWorkExperienceEvent(e, we4);
		
		kieSession.insert(ew4);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setPaid(false);
		we5.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew5 = new  EmployerWorkExperienceEvent(e, we5);
		
		kieSession.insert(ew5);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setPaid(false);
		we6.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew6 = new  EmployerWorkExperienceEvent(e, we6);
		
		kieSession.insert(ew6);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we7 = new WorkExperience();
		we7.setId(7L);
		we7.setPaid(false);
		we7.setDateTo(System.currentTimeMillis()); // 4.6.2022
		EmployerWorkExperienceEvent ew7 = new  EmployerWorkExperienceEvent(e, we7);
		
		kieSession.insert(ew7);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		
		kieSession.dispose();
		
		assertEquals(EmployerRecklessnessType.RECKLESS, e.getEmployerRecklessnessType());
		assertEquals(EmployerCarelessnessType.CARELESS, e.getEmployerCarelessnessType());
	}
	

	@Test
	public void testBanScenario() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		// little reckless and little careless
		
		Employer e = new Employer();
		e.setId(1L);
		kieSession.insert(e);
		
		WorkExperience we1 = new WorkExperience();
		we1.setId(1L);
		we1.setPaid(true);
		we1.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew1 = new  EmployerWorkExperienceEvent(e, we1);
		
		kieSession.insert(ew1);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we2 = new WorkExperience();
		we2.setId(2L);
		we2.setPaid(true);
		we2.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew2 = new  EmployerWorkExperienceEvent(e, we2);
		
		kieSession.insert(ew2);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we3 = new WorkExperience();
		we3.setId(3L);
		we3.setPaid(true);
		we3.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew3 = new  EmployerWorkExperienceEvent(e, we3);
		
		kieSession.insert(ew3);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we4 = new WorkExperience();
		we4.setId(4L);
		we4.setPaid(true);
		we4.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew4 = new  EmployerWorkExperienceEvent(e, we4);
		
		kieSession.insert(ew4);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we5 = new WorkExperience();
		we5.setId(5L);
		we5.setPaid(false);
		we5.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew5 = new  EmployerWorkExperienceEvent(e, we5);
		
		kieSession.insert(ew5);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we6 = new WorkExperience();
		we6.setId(6L);
		we6.setPaid(false);
		we6.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew6 = new  EmployerWorkExperienceEvent(e, we6);
		
		kieSession.insert(ew6);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we7 = new WorkExperience();
		we7.setId(7L);
		we7.setPaid(false);
		we7.setDateTo(System.currentTimeMillis()); // 4.6.2022
		EmployerWorkExperienceEvent ew7 = new  EmployerWorkExperienceEvent(e, we7);
		
		kieSession.insert(ew7);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we8 = new WorkExperience();
		we8.setId(8L);
		we8.setPaid(true);
		we8.setEmployerRating(3.0);
		we8.setEmployeeRating(3.0);
		we8.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew8 = new  EmployerWorkExperienceEvent(e, we8);
		
		kieSession.insert(ew8);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we9 = new WorkExperience();
		we9.setId(9L);
		we9.setPaid(true);
		we9.setEmployerRating(4.0);
		we9.setEmployeeRating(4.0);
		we9.setDateTo(1654293600000L); // 4.6.2022
		EmployerWorkExperienceEvent ew9 = new  EmployerWorkExperienceEvent(e, we9);
		
		kieSession.insert(ew9);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		WorkExperience we10 = new WorkExperience();
		we10.setId(10L);
		we10.setPaid(true);
		we10.setEmployerRating(5.0);
		we10.setEmployeeRating(5.0);
		we10.setDateTo(System.currentTimeMillis()); // 4.6.2022
		EmployerWorkExperienceEvent ew10 = new  EmployerWorkExperienceEvent(e, we10);
		
		kieSession.insert(ew10);
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
		
		kieSession.dispose();
		
		assertEquals(EmployerRecklessnessType.RECKLESS, e.getEmployerRecklessnessType());
		assertEquals(EmployerCarelessnessType.CARELESS, e.getEmployerCarelessnessType());
		assertTrue(e.isPenalty());
	}
}
