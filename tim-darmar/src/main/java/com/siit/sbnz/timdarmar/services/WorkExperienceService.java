package com.siit.sbnz.timdarmar.services;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.dtos.WorkExperienceDTO;


public interface WorkExperienceService {

	void saveWorkExperience(WorkExperienceDTO we, Employer e);
	
	List<WorkExperience> getWorkExperiencesFromEmployee(String email);
	
	List<WorkExperience> getWorkExperiencesFromEmployer(String email);
}
