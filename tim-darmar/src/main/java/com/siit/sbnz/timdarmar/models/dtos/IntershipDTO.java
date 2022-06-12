package com.siit.sbnz.timdarmar.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.siit.sbnz.timdarmar.models.classes.Intership;
import com.siit.sbnz.timdarmar.models.classes.MarkMentor;
import com.siit.sbnz.timdarmar.models.classes.Project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IntershipDTO {
	private Long dateFrom;
	private Long dateTo;
	private List<Double> mentorMarks;
	private List<Project> intershipProjects;
	
	public IntershipDTO(Intership intership) {
		dateFrom = intership.getDateFrom();
		dateTo = intership.getDateTo();
		mentorMarks = new ArrayList<>();
		for (MarkMentor mm : intership.getMentorMarks()) {
			mentorMarks.add(mm.getMark());
		}
		intershipProjects = intership.getIntershipProjects().stream().collect(Collectors.toList());
	}
}
