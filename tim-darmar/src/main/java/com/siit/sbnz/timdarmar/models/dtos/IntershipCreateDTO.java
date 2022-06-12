package com.siit.sbnz.timdarmar.models.dtos;

import com.siit.sbnz.timdarmar.models.classes.Intership;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IntershipCreateDTO {
	private Long studentID;
	private Intership intership;
}
