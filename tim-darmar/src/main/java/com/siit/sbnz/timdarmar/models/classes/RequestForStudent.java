package com.siit.sbnz.timdarmar.models.classes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
