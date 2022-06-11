package com.siit.sbnz.timdarmar.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.classes.UniSubject;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.StatusOfStudent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class StudentProfileViewDTO {

	private String email;
	private String firstName;
	private String lastName;
	private FinancialStatus financialStatus;
	private StatusOfStudent statusOfStudent;
	private double monthlyIncomeByFamilyMember;
	private double points;
	private List<IntershipDTO> interships;
	private List<UniSubject> passedSubjects;
	private List<Project> uniProjects;
	
	public StudentProfileViewDTO(Student student) {
		email = student.getEmail();
		firstName = student.getFirstName();
		lastName = student.getLastName();
		financialStatus = student.getFinancialStatus();
		statusOfStudent = student.getStatusOfStudent();
		monthlyIncomeByFamilyMember = student.getMonthlyIncomeByFamilyMember();
		points = student.getPoints();
		
		interships = new ArrayList<>();
		for (Intership inter : student.getInterships()) {
			interships.add(new IntershipDTO(inter));
		}
		passedSubjects = new ArrayList<>();
		for (UniSubject subj : student.getPassedSubjects()) {
			passedSubjects.add(subj);
		}
		uniProjects = student.getUniProjects().stream().collect(Collectors.toList());
	}
}
