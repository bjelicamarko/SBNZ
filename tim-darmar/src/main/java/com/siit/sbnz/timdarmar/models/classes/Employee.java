package com.siit.sbnz.timdarmar.models.classes;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;

import com.siit.sbnz.timdarmar.models.enums.StatusOfEmployee;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@Getter @Setter @NoArgsConstructor
public class Employee extends Client{
	private static final long serialVersionUID = 1L;

	@ElementCollection
	@CollectionTable(name = "languages", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "language") // 3
	private List<String> languages;
	
	@Column(nullable = false)
	private String preferredWorkingHours;
	
	@Column(nullable = false)
	private double preferredSalary;
	
	@Column(nullable = false)
	@Min(0)
	private double points;
	
	@Column(nullable = false)
	@Min(0)
	private int approval;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AreaOfExpertise> areaOfExpertises;
	
	@Enumerated(EnumType.STRING)
	private StatusOfEmployee statusOfEmployee;
}
