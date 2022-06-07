package com.siit.sbnz.timdarmar.backward_chain_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.runtime.rule.Variable;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseIntership;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.MarkMentor;
import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.enums.ProjectType;

public class BackwardChainTest {
	
	private static KieContainer kieContainer;
	
	private static List<Employee> employees = new ArrayList<>();
	
	@Before
    public void beforeClass() {
		KieServices kieServices = KieServices.Factory.get();
        kieContainer = kieServices.newKieContainer(kieServices.newReleaseId("sbnz.integracija", "drools-project", "0.0.1-SNAPSHOT"));
        
        Employee ee1 = new Employee();
        ee1.setId(1L);
        ee1.setWorkExperiences(new HashSet<>());
        ee1.setFriendsGroup(new HashSet<Employee>());
        employees.add(ee1);
        
        Employee ee1_1 = new Employee();
        ee1_1.setId(10L);
        ee1_1.setWorkExperiences(new HashSet<>());
        ee1_1.setFriendsGroup(new HashSet<Employee>());
        employees.add(ee1_1);
        
        Employee ee2 = new Employee();
        ee2.setId(2L);
        ee2.setWorkExperiences(new HashSet<>());
        ee2.setFriendsGroup(new HashSet<Employee>());
        employees.add(ee2);
        
        Employee ee3 = new Employee();
        ee3.setId(3L);
        ee3.setWorkExperiences(new HashSet<>());
        ee3.setFriendsGroup(new HashSet<Employee>());
        employees.add(ee3);
        
        Employee ee5 = new Employee();
        ee5.setId(5L);
        ee5.setWorkExperiences(new HashSet<>());
        ee5.setFriendsGroup(new HashSet<Employee>());
        employees.add(ee5);

        WorkExperience w1 = new WorkExperience();
        AreaOfExpertise aR = new AreaOfExpertise();
        aR.setNameOfArea("oop");
        aR.setSpecializations(Stream.of("klase", "podaci").collect(Collectors.toList()));
        w1.setAreaOfExpertise(aR);
        ee1.getWorkExperiences().add(w1);
        
        WorkExperience w1_1 = new WorkExperience();
        AreaOfExpertise aR1_1 = new AreaOfExpertise();
        aR1_1.setNameOfArea("oop");
        aR1_1.setSpecializations(Stream.of("web", "ai").collect(Collectors.toList()));
        w1_1.setAreaOfExpertise(aR1_1);
        ee1_1.getWorkExperiences().add(w1_1);
        
        WorkExperience w2 = new WorkExperience();
        AreaOfExpertise aR2 = new AreaOfExpertise();
        aR2.setNameOfArea("oop");
        aR2.setSpecializations(Stream.of("web", "ai").collect(Collectors.toList()));
        w2.setAreaOfExpertise(aR2);
        ee2.getWorkExperiences().add(w2);
        
        WorkExperience w3 = new WorkExperience();
        AreaOfExpertise aR3 = new AreaOfExpertise();
        aR3.setNameOfArea("oop");
        aR3.setSpecializations(Stream.of("computer vision").collect(Collectors.toList()));
        w3.setAreaOfExpertise(aR3);
        ee3.getWorkExperiences().add(w3);
        ee5.getWorkExperiences().add(w3);
        
        ee1.getFriendsGroup().add(ee2);
        ee1.getFriendsGroup().add(ee1_1);
        
        ee2.getFriendsGroup().add(ee1);
        ee2.getFriendsGroup().add(ee1_1);
        ee2.getFriendsGroup().add(ee3);
        
        ee3.getFriendsGroup().add(ee2);
        ee3.getFriendsGroup().add(ee1_1);
	}
	
	@Test
	public void testParametersOfRequestForEmployeeRules() {
		KieBase kieBase = kieContainer.getKieBase("backward_chain");
		KieSession kieSession = kieBase.newKieSession();
		
		for (Employee em : employees) { //ovo treba da bude lista svih drugara od onog za koga trazimo
			kieSession.insert(em);
		}
		
		HashSet<Long> initSet = new HashSet<Long>();
		initSet.add(1L);

		QueryResults results = kieSession.getQueryResults("hasFriend", new Object[] {  Variable.v, 1L, "computer vision", initSet, new HashSet<Long>()});
		
		HashSet<String> setic = new HashSet<String>();
		System.out.println("results");
		Long resLong = null;
		for (QueryResultsRow queryResult : results) {
			HashSet<Long> resID = (HashSet<Long>) queryResult.get("rez");
			resLong = resID.iterator().next();
			System.out.println(resLong);
//			Long resID = (Long) queryResult.get("employeeID");
//			System.out.println(resID);
		}
		
		assertTrue(resLong.equals(3L));	
        
        kieSession.dispose();
	}
}
