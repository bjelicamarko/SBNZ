package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.Project;
import com.siit.sbnz.timdarmar.models.classes.UniSubject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UniSubjectCreateDTO {
	private Long studentID;
	private UniSubject uniSubject;
}
