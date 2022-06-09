package com.siit.sbnz.timdarmar.services;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.dtos.WorkExperienceDTO;


public interface WorkExperienceService {

	void saveWorkExperience(WorkExperienceDTO we, Employer e);
}
