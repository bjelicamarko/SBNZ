package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EmployeeDTO {

	private String email;
	private String firstName;
	private String lastName;
	private String role;
	private List<String> languages;
	private String preferredWorkingHours;
	private double preferredSalary;
	private double points;
	private int approval;
	private Set<AreaOfExpertise> areaOfExpertises;
	private String statusOfEmployee;
	
	public EmployeeDTO(Employee e) {
		this.email = e.getEmail();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.role = e.getRole();
		this.languages = e.getLanguages();
		this.preferredWorkingHours = e.getPreferredWorkingHours();
		this.preferredSalary = e.getPreferredSalary();
		this.points = e.getPoints();
		this.approval = e.getApproval();
		this.areaOfExpertises = e.getAreaOfExpertises();
		if (e.getStatusOfEmployee() != null)
			this.statusOfEmployee = e.getStatusOfEmployee().toString();
	}
}
