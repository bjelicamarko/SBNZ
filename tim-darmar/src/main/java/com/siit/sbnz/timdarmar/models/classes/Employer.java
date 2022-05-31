package com.siit.sbnz.timdarmar.models.classes;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.siit.sbnz.timdarmar.models.enums.EmployerRecklessnessType;
import com.siit.sbnz.timdarmar.models.enums.EmployerCarelessnessType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@Getter @Setter @NoArgsConstructor
public class Employer extends Client{
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String companyName;
	
	@Column(nullable = false)
	private double companyAverageRating;
	
	@Column(nullable = false)
	private int penaltyPoints;
	
	@Column(nullable = false)
	private boolean penalty;
	
	@Enumerated(EnumType.STRING)
	private EmployerRecklessnessType employerRecklessnessType;
	
	@Enumerated(EnumType.STRING)
	private EmployerCarelessnessType employerCarelessnessType; // OVO PROMJENITI
	
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RequestForEmployee> requestsForEmployee;
	
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RequestForStudent> requestsForStudent;
	
	@OneToMany(mappedBy="employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WorkExperience> workExperiences;
}
