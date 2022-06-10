package com.siit.sbnz.timdarmar.models.dtos;

import java.util.List;
import java.util.Set;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseIntership;
import com.siit.sbnz.timdarmar.models.enums.WorkMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestForStudentDTO {
	private WorkMethods workMethods;
	private Set<AreaOfExpertiseIntership> areaOfExpertises;
}
