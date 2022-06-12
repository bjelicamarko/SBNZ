package com.siit.sbnz.timdarmar.models.dtos;

import com.siit.sbnz.timdarmar.models.classes.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EmployeeBasicInfoDTO {
	private Long id;
	private String firstName;
	private String lastName;
	
	public EmployeeBasicInfoDTO(Employee em) {
		this.id = em.getId();
		this.firstName = em.getFirstName();
		this.lastName = em.getLastName();
	}

}
