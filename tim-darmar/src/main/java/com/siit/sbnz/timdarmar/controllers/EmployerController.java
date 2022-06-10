package com.siit.sbnz.timdarmar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.dtos.EmployerDTO;
import com.siit.sbnz.timdarmar.services.EmployerService;

@RestController
@RequestMapping("api/employer")
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	
	@GetMapping(value = "/profileOfEmployer")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<EmployerDTO> profileOfEmployer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		Employer e  = employerService.findEmployerByEmail(employer.getEmail());
		return new ResponseEntity<>(new EmployerDTO(e), HttpStatus.OK);
	}
	
	@GetMapping(value = "/findEmployerByEmail/{email}")
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
	public ResponseEntity<EmployerDTO> findEmployerByEmail(@PathVariable String email) {
		Employer e  = employerService.findEmployerByEmail(email);
		return new ResponseEntity<>(new EmployerDTO(e), HttpStatus.OK);	
	}
	
	@GetMapping(value = "/findAllBannedEmployers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<EmployerDTO>> findAllBannedEmployers() {
		List<Employer> employers = employerService.findAllBannedEmployers();
		List<EmployerDTO> dtos = new ArrayList<>();
		for (Employer e : employers)
			dtos.add(new EmployerDTO(e));
		return new ResponseEntity<>(dtos, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/findAllNotBannedEmployers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<EmployerDTO>> findAllNotBannedEmployers() {
		List<Employer> employers = employerService.findAllNotBannedEmployers();
		List<EmployerDTO> dtos = new ArrayList<>();
		for (Employer e : employers)
			dtos.add(new EmployerDTO(e));
		return new ResponseEntity<>(dtos, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/unbanEmployer/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<EmployerDTO> unbanEmployer(@PathVariable String email) {
		Employer employer = employerService.unbanEmployer(email);
		return new ResponseEntity<>(new EmployerDTO(employer), HttpStatus.OK);	
	}
	
	@GetMapping(value = "/findAllEmployers")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<EmployerDTO>>  findAllEmployers() {
		List<Employer> employers = employerService.findAllEmployers();
		List<EmployerDTO> dtos = new ArrayList<>();
		for (Employer e : employers)
			dtos.add(new EmployerDTO(e));
		return new ResponseEntity<>(dtos, HttpStatus.OK);	
	}
}
