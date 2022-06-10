package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(nullable = true)
	@NonNull
	private Long dateFrom;
	
	@Column(nullable = true)
	@NonNull
	private Long dateTo;
	
	@Column(nullable = true)
	@Min(0) @Max(10)
	@NonNull // znaci ovo daje radnik poslodavcu
	private Double employerRating;
	
	@Column(nullable = true)
	@Min(0) @Max(10)
	@NonNull // ovo poslodavac radniku
	private Double employeeRating;
	
	@Column(nullable = true)
	@NonNull
	private Boolean paid;
	
	@ManyToOne()
    @JoinColumn(name="employer_id", nullable=false)
	@NonNull
    private Employer employer;
	
	@ManyToOne()
    @JoinColumn(name="employee_id", nullable=false)
	@NonNull
    private Employee employee;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="area_of_expertise_id", nullable=false)
	@NonNull
    private AreaOfExpertise areaOfExpertise;
	
	@Column(nullable = false)
	@NonNull
	private Boolean accepted;
}
