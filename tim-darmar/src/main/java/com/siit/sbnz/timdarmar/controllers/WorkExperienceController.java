package com.siit.sbnz.timdarmar.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.WorkExperience;
import com.siit.sbnz.timdarmar.models.dtos.WorkExperienceDTO;
import com.siit.sbnz.timdarmar.repositories.AreaOfExpertiseRepository;
import com.siit.sbnz.timdarmar.services.WorkExperienceService;

@RestController
@RequestMapping("api/work-experience")
public class WorkExperienceController {

	@Autowired
	private WorkExperienceService workExperienceService;
	
	@Autowired
	private AreaOfExpertiseRepository areaOfExpertiseRepository;
	
	@PostMapping("/saveWorkExperience")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<String> saveWorkExperience(@RequestBody WorkExperienceDTO we) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		workExperienceService.saveWorkExperience(we, employer);
		return new ResponseEntity<>("Sucessfully added", HttpStatus.OK);
	}
	
	@GetMapping("/getWorkExperiencesFromEmployer")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<List<WorkExperienceDTO>> getWorkExperiencesFromEmployer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		List<WorkExperience> works = workExperienceService.getWorkExperiencesFromEmployer(employer.getEmail());
		List<WorkExperienceDTO> dtos = new ArrayList<>();
		for (WorkExperience w: works)
			dtos.add(new WorkExperienceDTO(w));
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/getWorkExperiencesFromEmployee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<WorkExperienceDTO>> getWorkExperiencesFromEmployee() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		List<WorkExperience> works = workExperienceService.getWorkExperiencesFromEmployee(employee.getEmail());
		List<WorkExperienceDTO> dtos = new ArrayList<>();
		for (WorkExperience w: works)
			dtos.add(new WorkExperienceDTO(w));
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping("/acceptWorkExperience")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<WorkExperienceDTO> acceptWorkExperience(@RequestBody WorkExperienceDTO we) {
		WorkExperience w = workExperienceService.acceptWorkExperience(we);
		return new ResponseEntity<>(new WorkExperienceDTO(w), HttpStatus.OK);
	}
	
	@PostMapping("/finishWorkExperience")
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'EMPLOYER')")
	public ResponseEntity<WorkExperienceDTO> finishWorkExperience(@RequestBody WorkExperienceDTO we) {
		WorkExperience w = workExperienceService.finishWorkExperience(we);
		return new ResponseEntity<>(new WorkExperienceDTO(w), HttpStatus.OK);
	}
	
	@PostMapping("/payWorkExperience")
	@PreAuthorize("hasAnyRole('EMPLOYER')")
	public ResponseEntity<WorkExperienceDTO> payWorkExperience(@RequestBody WorkExperienceDTO we) {
		WorkExperience w = workExperienceService.payWorkExperience(we);
		return new ResponseEntity<>(new WorkExperienceDTO(w), HttpStatus.OK);
	}
	
	@PostMapping("/markEmployee")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<WorkExperienceDTO> markEmployee(@RequestBody WorkExperienceDTO we) {
		WorkExperience w = workExperienceService.markEmployee(we);
		return new ResponseEntity<>(new WorkExperienceDTO(w), HttpStatus.OK);
	}
	
	@PostMapping("/markEmployer")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<WorkExperienceDTO> markEmployer(@RequestBody WorkExperienceDTO we) {
		WorkExperience w = workExperienceService.markEmployer(we);
		return new ResponseEntity<>(new WorkExperienceDTO(w), HttpStatus.OK);
	}
	
	@GetMapping("/getSpecializationsFromWorkExperiences")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<HashSet<String>> getSpecializationsFromWorkExperiences() {
		List<AreaOfExpertise> areas = areaOfExpertiseRepository.findAll();
		HashSet<String> setic = new HashSet<>();
		for (AreaOfExpertise area : areas)
			setic.addAll(area.getSpecializations());
		return new ResponseEntity<>(setic, HttpStatus.OK);
	}
}
