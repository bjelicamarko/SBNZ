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
import javax.validation.constraints.Min;

import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;
import com.siit.sbnz.timdarmar.models.enums.FinancialStatus;
import com.siit.sbnz.timdarmar.models.enums.StatusOfStudent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@Getter @Setter @NoArgsConstructor
public class Student extends Client{
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private FinancialStatus financialStatus;
	
	@Enumerated(EnumType.STRING)
	private StatusOfStudent statusOfStudent;
	
	@Column(nullable = false)
	@Min(0)
	private double monthlyIncomeByFamilyMember;
	
	@Column(nullable = false)
	@Min(0)
	private double points;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Intership> interships;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UniSubject> passedSubjects;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Project> uniProjects;
	
	public Student(RegistrationDTO reg) {
		super(reg);
		this.monthlyIncomeByFamilyMember = 0.0;
		this.points = 0.0;
		this.interships = new HashSet<>();
		this.passedSubjects = new HashSet<>();
		this.uniProjects = new HashSet<>();
	}
}
