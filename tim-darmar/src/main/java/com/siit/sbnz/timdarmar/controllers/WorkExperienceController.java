package com.siit.sbnz.timdarmar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.dtos.WorkExperienceDTO;
import com.siit.sbnz.timdarmar.services.WorkExperienceService;

@RestController
@RequestMapping("api/work-experience")
public class WorkExperienceController {

	@Autowired
	private WorkExperienceService workExperienceService;
	
	@PostMapping("/saveWorkExperience")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<String> saveWorkExperience(@RequestBody WorkExperienceDTO we) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		workExperienceService.saveWorkExperience(we, employer);
		return new ResponseEntity<>("Sucessfully added", HttpStatus.OK);
	}
}
