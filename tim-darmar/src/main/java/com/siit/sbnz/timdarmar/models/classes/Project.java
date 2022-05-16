package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.siit.sbnz.timdarmar.models.enums.ProjectType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	@Min(0) @Max(10)
	private double mark;
	
	@Enumerated(EnumType.STRING)
	private ProjectType projectType;
	
	@Column(nullable = false)
	@Min(1) @Max(10)
	private int difficulty;
	
}
