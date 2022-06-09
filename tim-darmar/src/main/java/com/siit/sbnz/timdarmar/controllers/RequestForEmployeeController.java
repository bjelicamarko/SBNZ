package com.siit.sbnz.timdarmar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.dtos.RequestForEmployeeDTO;
import com.siit.sbnz.timdarmar.services.RequestForEmployeeService;

@RestController
@RequestMapping("api/request-for-employee")
public class RequestForEmployeeController {

	@Autowired
	private RequestForEmployeeService requestForEmployeeService;
	
	@GetMapping(value = "/getRequest")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<RequestForEmployeeDTO> getRequest() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		RequestForEmployee r = requestForEmployeeService.getRequest(employer.getEmail());
		return new ResponseEntity<>(new RequestForEmployeeDTO(r), HttpStatus.OK);
	}
}
