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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request_for_employee")
@Getter @Setter 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestForEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	@CollectionTable(name = "required_languages", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "language") // 3
	private List<String> requiredLanguages;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private TypeOfEmployment typeOfEmployment;
	
	@Column(nullable = false)
	@NonNull
	private String requiredWorkingHours;
	
	@Column(nullable = false)
	@NonNull
	private Double requiredSalary;
	
	@ManyToOne
    @JoinColumn(name="employer_id", nullable=false)
	@NonNull
    private Employer employer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AreaOfExpertise> areaOfExpertises;
}
