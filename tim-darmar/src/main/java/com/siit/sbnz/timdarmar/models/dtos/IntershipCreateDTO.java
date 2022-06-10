package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.Project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IntershipCreateDTO {
	private Long studentID;
	private Intership intership;
}
