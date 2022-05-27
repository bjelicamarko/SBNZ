package com.siit.sbnz.timdarmar.cep_test;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.Employee;

public class CepRulesTest {
	
	private static KieContainer kieContainer;
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
	}
	
	@Test
	public void testic() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		
		Employee e = new Employee();
		kieSession.insert(e);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
}
