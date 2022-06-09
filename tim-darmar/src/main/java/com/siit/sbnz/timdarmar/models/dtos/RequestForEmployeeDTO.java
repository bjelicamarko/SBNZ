package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestForEmployeeDTO {

	private List<String> requiredLanguages;
	private String typeOfEmployment;
	private String requiredWorkingHours;
	private double requiredSalary;
	private Set<AreaOfExpertise> areaOfExpertises;
	
	public RequestForEmployeeDTO(RequestForEmployee r) {
		this.requiredLanguages = r.getRequiredLanguages();
		this.typeOfEmployment = r.getTypeOfEmployment().toString();
		this.requiredWorkingHours = r.getRequiredWorkingHours();
		this.requiredSalary = r.getRequiredSalary();
		this.areaOfExpertises = r.getAreaOfExpertises();
	}
	
	@Override
	public String toString() {
		return "RequestForEmployeeDTO [requiredLanguages=" + requiredLanguages + ", typeOfEmployment="
				+ typeOfEmployment + ", requiredWorkingHours=" + requiredWorkingHours + ", requiredSalary="
				+ requiredSalary + ", areaOfExpertises=" + areaOfExpertises + "]";
	}
	
	
}
