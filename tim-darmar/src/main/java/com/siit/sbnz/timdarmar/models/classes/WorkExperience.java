package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work_experience")
@Getter @Setter 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private TypeOfEmployment typeOfEmployment;
	
	@Column(nullable = false)
	@NonNull
	private Long dateFrom;
	
	@Column(nullable = true)
	@NonNull
	private Long dateTo;
	
	@Column(nullable = true)
	@Min(0) @Max(10)
	@NonNull
	private Double companyRating;
	
	@Column(nullable = true)
	@Min(0) @Max(10)
	@NonNull
	private Double employerRating;
}
