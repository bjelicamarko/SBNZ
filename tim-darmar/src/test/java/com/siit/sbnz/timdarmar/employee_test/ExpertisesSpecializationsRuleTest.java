package com.siit.sbnz.timdarmar.employee_test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;

public class ExpertisesSpecializationsRuleTest {

	private static KieContainer kieContainer;
	
	private static final String agenda = "expertises_specializations";
	
	private static List<Employee> employees = new ArrayList<>();
	private static Set<AreaOfExpertise> expertises = new HashSet<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        AreaOfExpertise globAoe1 = new AreaOfExpertise("Web programiranje", new ArrayList<>());
        globAoe1.getSpecializations().add("Java");
        globAoe1.getSpecializations().add("Spring");
        globAoe1.getSpecializations().add(".NET");
        globAoe1.getSpecializations().add("Vue");
        globAoe1.getSpecializations().add("React");
        globAoe1.getSpecializations().add("Angular");
        
        AreaOfExpertise globAoe2 = new AreaOfExpertise("AI", new ArrayList<>());
        globAoe2.getSpecializations().add("Machine Learning");
        globAoe2.getSpecializations().add("Soft Kompjuting");
        globAoe2.getSpecializations().add("Racunarska Inteligencija");
        globAoe2.getSpecializations().add("Racunarska Vizija");
        
        AreaOfExpertise globAoe3 = new AreaOfExpertise("Data Science", new ArrayList<>());
        globAoe3.getSpecializations().add("SQL");
        globAoe3.getSpecializations().add("MY SQL");
        globAoe2.getSpecializations().add("Mongo");
        
        expertises.add(globAoe1);
        expertises.add(globAoe2);
        expertises.add(globAoe3);
        
        Employee e1 = new Employee();
        e1.setAreaOfExpertises(new HashSet<>());
        
        AreaOfExpertise aoe1 = new AreaOfExpertise("Web programiranje", new ArrayList<>());
        aoe1.getSpecializations().add("Java");
        aoe1.getSpecializations().add("Spring");
        e1.getAreaOfExpertises().add(aoe1);
        
        AreaOfExpertise aoe2 = new AreaOfExpertise("AI", new ArrayList<>());
        aoe2.getSpecializations().add("Soft Kompjuting");
        e1.getAreaOfExpertises().add(aoe2);
        
        AreaOfExpertise aoe3 = new AreaOfExpertise("Data Science", new ArrayList<>());
        aoe3.getSpecializations().add("MY SQL");
        e1.getAreaOfExpertises().add(aoe3);
        
        employees.add(e1);
      
        
        Employee e2 = new Employee();
        e2.setAreaOfExpertises(new HashSet<>());
        
        AreaOfExpertise aoe4 = new AreaOfExpertise("Web programiranje", new ArrayList<>());
        aoe4.getSpecializations().add("Java");
        e2.getAreaOfExpertises().add(aoe4);
        
        AreaOfExpertise aoe5 = new AreaOfExpertise("AI", new ArrayList<>());
        aoe5.getSpecializations().add("Soft Kompjuting");
        e2.getAreaOfExpertises().add(aoe5);
        
        AreaOfExpertise aoe6 = new AreaOfExpertise("Data Science", new ArrayList<>());
        aoe6.getSpecializations().add("MY SQL");
        e2.getAreaOfExpertises().add(aoe6);
        
        employees.add(e2);
        
        Employee e3 = new Employee();
        e3.setAreaOfExpertises(new HashSet<>());
        
        AreaOfExpertise aoe7 = new AreaOfExpertise("Data Science", new ArrayList<>());
        aoe7.getSpecializations().add("SQL");
        aoe7.getSpecializations().add("MY SQL");
        aoe7.getSpecializations().add("Mongo");
        e3.getAreaOfExpertises().add(aoe7);
        
        employees.add(e3);
    }
	
	@Test
	public void testExpertisesRule() {
		KieBase kieBase = kieContainer.getKieBase("classic");
		KieSession kieSession = kieBase.newKieSession();
        kieSession.getAgenda().getAgendaGroup(agenda).setFocus();
        
		Employee e1 = employees.get(0);
		Employee e2 = employees.get(1);
		
		System.out.println(kieSession.getFactCount());
		kieSession.insert(e1);
		kieSession.insert(e2);
		kieSession.insert(expertises);
		kieSession.fireAllRules();
		
        assertEquals(0.7, e1.getPoints(), 0.01);
        assertEquals(0.6, e2.getPoints(), 0.01);
        
        kieSession.dispose();

	}
}
