package com.siit.sbnz.timdarmar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseGlobally;
import com.siit.sbnz.timdarmar.services.AreaOfExpertiseService;

@RestController
@RequestMapping("api/areas")
public class AreaOfExpertiseController {
	
	@Autowired
	private AreaOfExpertiseService areaOfExpertiseService;
	
	@GetMapping(value = "/findAllExpertisesGlobally")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<AreaOfExpertiseGlobally>> findAllExpertisesGlobally() {
		return new ResponseEntity<>(areaOfExpertiseService.findAllExpertisesGlobally(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/createExpertisesGlobally")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<AreaOfExpertiseGlobally>> createExpertisesGlobally(@RequestBody String input) {
		areaOfExpertiseService.saveExpertisesGlobally(input);
		return new ResponseEntity<>(areaOfExpertiseService.findAllExpertisesGlobally(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateExpertisesGlobally")
	@PreAuthorize("hasRole('ADMIN')") 
	public ResponseEntity<List<AreaOfExpertiseGlobally>> updateExpertisesGlobally(@RequestBody String input) {
		areaOfExpertiseService.updateExpertisesGlobally(input);
		return new ResponseEntity<>(areaOfExpertiseService.findAllExpertisesGlobally(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteExpertisesGlobally")
	@PreAuthorize("hasRole('ADMIN')") 
	public ResponseEntity<List<AreaOfExpertiseGlobally>> deleteExpertisesGlobally(@RequestBody String input) {
		areaOfExpertiseService.deleteExpertisesGlobally(input);
		return new ResponseEntity<>(areaOfExpertiseService.findAllExpertisesGlobally(), HttpStatus.OK);
	}
}
