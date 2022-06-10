package com.siit.sbnz.timdarmar.models.classes;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Intership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NonNull
	private Long dateFrom;
	
	@Column(nullable = true)
	@NonNull
	private Long dateTo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<MarkMentor> mentorMarks;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Project> intershipProjects;
}
