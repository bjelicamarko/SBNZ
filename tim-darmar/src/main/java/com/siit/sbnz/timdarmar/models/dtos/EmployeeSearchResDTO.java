package com.siit.sbnz.timdarmar.models.dtos;

import java.util.ArrayList;
import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EmployeeSearchResDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<AreaOfExpertise> areasOfExperienceFromWorkExperiences;
	
	public EmployeeSearchResDTO(Employee em) {
		this.id = em.getId();
		this.firstName = em.getFirstName();
		this.lastName = em.getLastName();
		this.email = em.getEmail();
		this.areasOfExperienceFromWorkExperiences = new ArrayList<>();
		
		for (WorkExperience we : em.getWorkExperiences()) {
			this.areasOfExperienceFromWorkExperiences.add(we.getAreaOfExpertise());
		}
	}
}
