package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.StatusOfStudent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class StudentBasicInfoDTO {
	private Long id;
	private String name;
	private String email;
	
	public StudentBasicInfoDTO(Student stud) {
		this.id = stud.getId();
		this.name = stud.getFirstName() + " " + stud.getLastName();
		this.email = stud.getEmail();
	}
}