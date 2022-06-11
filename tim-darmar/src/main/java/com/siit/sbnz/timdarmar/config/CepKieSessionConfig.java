package com.siit.sbnz.timdarmar.config;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CepKieSessionConfig {

	@Autowired
	private KieContainer kieContainer;
	
	@Bean(name = "cep") 
	public KieSession cepSession() {
		KieBase kieBase = kieContainer.getKieBase("cep");
		KieSession kieSession = kieBase.newKieSession();
		kieSession.getAgenda().getAgendaGroup("cep").setFocus();
		return kieSession;
	}
}
