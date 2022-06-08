package com.siit.sbnz.timdarmar.models.classes;

import java.util.ArrayList;
import java.util.HashSet;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;
import com.siit.sbnz.timdarmar.models.enums.StatusOfEmployee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "client")
@Getter @Setter @NoArgsConstructor
public class Employee extends Client{
	private static final long serialVersionUID = 1L;

	@ElementCollection()
	@LazyCollection(LazyCollectionOption.FALSE)
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> friendsGroup;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AreaOfExpertise> areaOfExpertises;
	
	@Enumerated(EnumType.STRING)
	private StatusOfEmployee statusOfEmployee;
	
	public boolean isAFriendOf(Long id, Set<Long> visitedIds) {
		System.out.println("THIS: " + this.getId());
		HashSet<Long> setic = (HashSet<Long>) visitedIds;
		System.out.println("ID " + id);
		if (setic.contains(this.getId())) {
			//System.out.println("contains false");
			return false;
		}
		for (Employee em : friendsGroup) {
			if (em.getId().equals(id)) {
				//System.out.println("true");
				return true;
			}
		}
		//System.out.println("nije frend false");
		return false;
	}

	public Employee (RegistrationDTO reg) {
		super(reg);
		this.languages = new ArrayList<>();
		this.preferredWorkingHours = "not";
		this.preferredSalary = 0.0;
		this.points = 0.0;
		this.approval = 0;
		this.workExperiences = new HashSet<>();
		this.areaOfExpertises = new HashSet<>();
		// this.statusOfEmployee = StatusOfEmployee.UNEMPLOYED;
	}
}
