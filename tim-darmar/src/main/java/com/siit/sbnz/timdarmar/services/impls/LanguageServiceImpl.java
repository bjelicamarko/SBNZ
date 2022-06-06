package com.siit.sbnz.timdarmar.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.LanguageGlobally;
import com.siit.sbnz.timdarmar.repositories.LanguageGloballyRepository;
import com.siit.sbnz.timdarmar.services.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageGloballyRepository languageGloballyRepository;
	
	@Override
	public List<LanguageGlobally> findAllLanguages() {
		return languageGloballyRepository.findAll();
	}

	@Override
	public void saveLanguage(String input) {
		LanguageGlobally l = languageGloballyRepository.findByName(input);
		if (l == null)
			languageGloballyRepository.save(new LanguageGlobally(input));
	}

	@Override
	public void deleteLanguage(String input) {
		LanguageGlobally l = languageGloballyRepository.findByName(input);
		if (l != null)
			languageGloballyRepository.deleteById(l.getId());
	}

}
