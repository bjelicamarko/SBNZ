package com.siit.sbnz.timdarmar.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.enums.EmployerCarelessnessType;
import com.siit.sbnz.timdarmar.models.enums.EmployerRecklessnessType;
import com.siit.sbnz.timdarmar.repositories.EmployerRepository;
import com.siit.sbnz.timdarmar.services.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService{

	@Autowired
	private EmployerRepository employerRepository;
	
	@Override
	public Employer findEmployerByEmail(String email) {
		return employerRepository.findEmployerByEmail(email);
	}

	@Override
	public List<Employer> findAllBannedEmployers() {
		return employerRepository.findAllBannedEmployers();
	}

	@Override
	public List<Employer> findAllNotBannedEmployers() {
		return employerRepository.findAllNotBannedEmployers();
	}

	@Override
	public Employer unbanEmployer(String email) {
		Employer e = employerRepository.findEmployerByEmail(email);
		e.setPenalty(false);
		e.setEmployerCarelessnessType(EmployerCarelessnessType.NOT_CARELESS);
		e.setEmployerRecklessnessType(EmployerRecklessnessType.NOT_RECKLESS);
		employerRepository.save(e);
		return e;
	}

	@Override
	public List<Employer> findAllEmployers() {
		return employerRepository.findAll();
	}

}
