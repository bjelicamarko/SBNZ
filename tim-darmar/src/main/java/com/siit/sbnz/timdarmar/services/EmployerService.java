package com.siit.sbnz.timdarmar.services;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.Employer;

public interface EmployerService {

	Employer findEmployerByEmail(String email);
	
	List<Employer> findAllBannedEmployers();
	
	List<Employer> findAllNotBannedEmployers();
	
	Employer unbanEmployer(String email);
	
	List<Employer> findAllEmployers();
}
