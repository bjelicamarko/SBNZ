package com.siit.sbnz.timdarmar.models.dtos;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor
public class WorkExperienceDTO {

	private long id;
	private String typeOfEmployment;
	private String dateFrom;
	private long dateFromVal;
	private String dateTo;
	private long dateToVal;
	private double employerRating;
	private double employeeRating;
	private boolean paid;
	private String employerEmail;
	private String employeeEmail;
	private AreaOfExpertise areaOfExpertise;
	private boolean accepted;
	
	@JsonIgnore
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public WorkExperienceDTO(WorkExperience we) {
		this.id = we.getId();
		this.typeOfEmployment = we.getTypeOfEmployment().toString();
		if (we.getDateFrom() != null) {
			LocalDateTime dateTime =
			        LocalDateTime.ofInstant(Instant.ofEpochMilli(we.getDateFrom()), 
			                                TimeZone.getDefault().toZoneId()); 
			this.dateFrom = dateTime.format(formatter);
			this.dateFromVal = we.getDateFrom();
		}
		if (we.getDateTo() != null) {
			LocalDateTime dateTime =
			        LocalDateTime.ofInstant(Instant.ofEpochMilli(we.getDateTo()), 
			                                TimeZone.getDefault().toZoneId()); 
			this.dateTo = dateTime.format(formatter);
			this.dateToVal = we.getDateTo();
		}
		if (we.getEmployerRating() != null) {
			this.employerRating = we.getEmployerRating();
		}
		if (we.getEmployeeRating() != null) {
			this.employeeRating = we.getEmployeeRating();
		}
		if (we.getPaid() != null) {
			this.paid = we.getPaid();
		}
		this.employerEmail = we.getEmployer().getEmail();
		this.employeeEmail = we.getEmployee().getEmail();
		this.areaOfExpertise = we.getAreaOfExpertise();
		this.accepted = we.getAccepted();
	}
	
}
