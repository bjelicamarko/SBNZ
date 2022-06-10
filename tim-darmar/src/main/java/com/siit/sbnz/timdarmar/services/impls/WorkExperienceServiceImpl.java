package com.siit.sbnz.timdarmar.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.dtos.WorkExperienceDTO;
import com.siit.sbnz.timdarmar.models.enums.TypeOfEmployment;
import com.siit.sbnz.timdarmar.repositories.WorkExperienceRepository;
import com.siit.sbnz.timdarmar.services.EmployeeService;
import com.siit.sbnz.timdarmar.services.WorkExperienceService;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

	@Autowired
	private WorkExperienceRepository workExperienceRepository;

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void saveWorkExperience(WorkExperienceDTO weDTO, Employer e) {
		WorkExperience we = new WorkExperience();
		we.setTypeOfEmployment(TypeOfEmployment.valueOf(weDTO.getTypeOfEmployment()));
		we.setAreaOfExpertise(weDTO.getAreaOfExpertise());
		Employee em = employeeService.findEmployeeByEmail(weDTO.getEmployeeEmail());
		we.setEmployee(em);
		we.setEmployer(e);
		we.setAccepted(false);
		workExperienceRepository.save(we);
	}

	@Override
	public List<WorkExperience> getWorkExperiencesFromEmployee(String email) {
		return workExperienceRepository.getWorkExperiencesFromEmployee(email);
	}

	@Override
	public List<WorkExperience> getWorkExperiencesFromEmployer(String email) {
		return workExperienceRepository.getWorkExperiencesFromEmployer(email);
	}
}
