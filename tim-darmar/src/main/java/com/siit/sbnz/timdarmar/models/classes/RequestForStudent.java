package com.siit.sbnz.timdarmar.models.classes;

import java.util.Set;

import javax.persistence.CascadeType;
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

import com.siit.sbnz.timdarmar.models.dtos.RequestForStudentDTO;
import com.siit.sbnz.timdarmar.models.enums.WorkMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request_for_student")
@Getter @Setter 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestForStudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private WorkMethods workMethods;
	
	@ManyToOne
    @JoinColumn(name="employer_id", nullable=false)
	@NonNull
    private Employer employer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AreaOfExpertiseIntership> areaOfExpertiseIntership; //TODO proveriti ovu izmenu u drools i testovima
	
	public RequestForStudent(RequestForStudentDTO req, Employer emp) {
		this.workMethods = req.getWorkMethods();
		this.areaOfExpertiseIntership = req.getAreaOfExpertises();
		this.employer = emp;
	}
}
