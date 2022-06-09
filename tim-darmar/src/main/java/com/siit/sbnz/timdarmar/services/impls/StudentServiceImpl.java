package com.siit.sbnz.timdarmar.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.repositories.EmployeeRepository;
import com.siit.sbnz.timdarmar.repositories.StudentRepository;
import com.siit.sbnz.timdarmar.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final String agenda1 = "student_financial_status";
	private static final String agenda2 = "place_expertise_project";
	private static final String agenda3 = "student_bonus_points";
	private static final String agenda4 = "previous_intership_experience";
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private KieContainer kieContainer;
	
	@Override
	@Transactional
	public List<Student> getStudentsFromRecommendation(RequestForStudent requestForStudent) {
		List<Student> students = studentRepository.findAllStudents();
		
		KieBase kieBase = kieContainer.getKieBase("student");
		KieSession kieSession = kieBase.newKieSession();
		
		for (Student s : students)
			kieSession.insert(s);
		
		kieSession.insert(requestForStudent);
		
		kieSession.getAgenda().getAgendaGroup(agenda1).setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda2).setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda3).setFocus();
		kieSession.fireAllRules();
		kieSession.getAgenda().getAgendaGroup(agenda4).setFocus();
		kieSession.fireAllRules();
		
		kieSession.dispose();
		
		Collections.sort(students, (s1, s2) -> Double.valueOf(s1.getPoints()).compareTo(Double.valueOf(s2.getPoints())));
		
		return students;
	}

}
