package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

import com.siit.sbnz.timdarmar.models.enums.EmployerBehavior;
import com.siit.sbnz.timdarmar.models.enums.StatusPazljivosti;

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
	private EmployerBehavior employerBehavior;
	
	@Enumerated(EnumType.STRING)
	private StatusPazljivosti statusPazljivosti; // OVO PROMJENITI
	
}