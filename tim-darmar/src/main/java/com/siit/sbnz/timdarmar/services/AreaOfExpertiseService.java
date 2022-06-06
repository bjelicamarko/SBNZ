package com.siit.sbnz.timdarmar.services;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseGlobally;

public interface AreaOfExpertiseService {

	List<AreaOfExpertiseGlobally> findAllExpertisesGlobally();
	
	void saveExpertisesGlobally(String input);
	
	void updateExpertisesGlobally(String input);
	
	void deleteExpertisesGlobally(String input);
}
