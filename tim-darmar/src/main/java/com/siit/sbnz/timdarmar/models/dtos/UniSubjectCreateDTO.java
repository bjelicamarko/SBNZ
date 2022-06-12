package com.siit.sbnz.timdarmar.models.dtos;

import com.siit.sbnz.timdarmar.models.classes.UniSubject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UniSubjectCreateDTO {
	private Long studentID;
	private UniSubject uniSubject;
}
