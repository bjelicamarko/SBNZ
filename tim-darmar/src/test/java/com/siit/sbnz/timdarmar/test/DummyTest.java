package com.siit.sbnz.timdarmar.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.DummyClass;

public class DummyTest {

	private static KieContainer kieContainer;
	  
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
    }
	
	 @Test
	 public void dummyTest() {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.getAgenda().getAgendaGroup("beli").setFocus();
	    DummyClass s = new DummyClass();
	    kieSession.insert(s);
	    kieSession.fireAllRules();
	    assertTrue(true);
	 }
	        
}
