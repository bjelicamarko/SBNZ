package com.siit.sbnz.timdarmar.models.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;
import com.siit.sbnz.timdarmar.models.enums.EmployerCarelessnessType;
import com.siit.sbnz.timdarmar.models.enums.EmployerRecklessnessType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@Getter @Setter @NoArgsConstructor
public class Employer extends Client{
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private double companyAverageRating;
	
	@Column(nullable = false)
	private int penaltyPoints;
	
	@Column(nullable = false)
	private boolean penalty;
	
	@Enumerated(EnumType.STRING)
	private EmployerRecklessnessType employerRecklessnessType;
	
	@Enumerated(EnumType.STRING)
	private EmployerCarelessnessType employerCarelessnessType;
	
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RequestForEmployee> requestsForEmployee;
	
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RequestForStudent> requestsForStudent;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL)
    private Set<WorkExperience> workExperiences;
	
	public Employer (RegistrationDTO reg) {
		super(reg);
		this.companyAverageRating = 0.0;
		this.penaltyPoints = 0;
		this.penalty = false;
		this.employerRecklessnessType = EmployerRecklessnessType.NOT_RECKLESS;
		this.employerCarelessnessType = EmployerCarelessnessType.NOT_CARELESS;
		this.requestsForEmployee = new HashSet<>();
		this.requestsForStudent = new HashSet<>();
		this.workExperiences = new HashSet<>();
	}
}
