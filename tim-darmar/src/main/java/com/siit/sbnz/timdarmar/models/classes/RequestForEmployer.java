package com.siit.sbnz.timdarmar.models.classes;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request_for_employer")
@Getter @Setter @NoArgsConstructor
public class RequestForEmployer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	@CollectionTable(name = "required_languages", joinColumns = @JoinColumn(name = "id")) // 2
    @Column(name = "language") // 3
	private List<String> requiredLanguages;
	
	@Enumerated(EnumType.STRING)
	private TypeOfEmployment typeOfEmployment;
	
	@Column(nullable = false)
	private String requiredWorkingHours;
	
	@Column(nullable = false)
	private double requiredSalary;
}
