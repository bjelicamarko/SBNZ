package com.siit.sbnz.timdarmar.models.dtos;

import com.siit.sbnz.timdarmar.models.classes.Employer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EmployerDTO {

	private String email;
	private String firstName;
	private String lastName;
	private String role;
	private double companyAverageRating;
	private int penaltyPoints;
	private boolean penalty;
	private String employerRecklessnessType;
	private String employerCarelessnessType;
	
	public EmployerDTO(Employer e) {
		this.email = e.getEmail();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.role = e.getRole();
		this.companyAverageRating = e.getCompanyAverageRating();
		this.penaltyPoints = e.getPenaltyPoints();
		this.penalty = e.isPenalty();
		this.employerRecklessnessType = e.getEmployerRecklessnessType().toString();
		this.employerCarelessnessType = e.getEmployerCarelessnessType().toString();
	}
}
