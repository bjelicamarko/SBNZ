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

import com.siit.sbnz.timdarmar.models.classes.LanguageGlobally;
import com.siit.sbnz.timdarmar.services.LanguageService;

@RestController
@RequestMapping("api/languages")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping(value = "/findAllLanguages")
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYER', 'EMPLOYEE')")
	public ResponseEntity<List<LanguageGlobally>> findAllLanguages() {
		return new ResponseEntity<>(languageService.findAllLanguages(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveLanguage")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<LanguageGlobally>> saveLanguage(@RequestBody String input ) {
		languageService.saveLanguage(input);
		return new ResponseEntity<>(languageService.findAllLanguages(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/deleteLanguage")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<LanguageGlobally>> deleteLanguage(@RequestBody String input ) {
		languageService.deleteLanguage(input);
		return new ResponseEntity<>(languageService.findAllLanguages(), HttpStatus.OK);
	}
}
