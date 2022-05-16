package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;

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
	private double points;
}
