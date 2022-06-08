package com.siit.sbnz.timdarmar.services;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.LanguageGlobally;

public interface LanguageService {

	List<LanguageGlobally> findAllLanguages();
	
	void saveLanguage(String input);
	
	void deleteLanguage(String input);
	
}
