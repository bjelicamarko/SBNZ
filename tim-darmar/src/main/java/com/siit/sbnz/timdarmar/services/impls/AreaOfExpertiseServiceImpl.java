package com.siit.sbnz.timdarmar.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseGlobally;
import com.siit.sbnz.timdarmar.repositories.AreaOfExpertiseGloballyRepository;
import com.siit.sbnz.timdarmar.services.AreaOfExpertiseService;

@Service
public class AreaOfExpertiseServiceImpl implements AreaOfExpertiseService{
	
	@Autowired
	private AreaOfExpertiseGloballyRepository areaOfExpertiseGloballyRepository;

	@Override
	public List<AreaOfExpertiseGlobally> findAllExpertisesGlobally() {
		return areaOfExpertiseGloballyRepository.findAll();
	}

	@Override
	public void saveExpertisesGlobally(String input) {
		String tokens[] = input.split("\\|");
		AreaOfExpertiseGlobally a = new AreaOfExpertiseGlobally(tokens[0]);
		for (int i = 1; i < tokens.length; i++)
			if (!a.getSpecializations().contains(tokens[i]))
				a.getSpecializations().add(tokens[i]);
		areaOfExpertiseGloballyRepository.save(a);
	}

	@Override
	public void updateExpertisesGlobally(String input) {
		String tokens[] = input.split("\\|");
		AreaOfExpertiseGlobally a = areaOfExpertiseGloballyRepository.findByNameOfArea(tokens[0]);
		for (int i = 1; i < tokens.length; i++)
			if (!a.getSpecializations().contains(tokens[i]))
				a.getSpecializations().add(tokens[i]);
		areaOfExpertiseGloballyRepository.save(a);
	}

	@Override
	public void deleteExpertisesGlobally(String input) {
		String tokens[] = input.split("\\|");
		AreaOfExpertiseGlobally a = areaOfExpertiseGloballyRepository.findByNameOfArea(tokens[0]);
		if (tokens.length == 1) {
			areaOfExpertiseGloballyRepository.deleteById(a.getId());
		} else {
			for (int i = 1; i < tokens.length; i++)
				if (a.getSpecializations().contains(tokens[i]))
					a.getSpecializations().remove(tokens[i]);
			areaOfExpertiseGloballyRepository.save(a);
		}
	}
	
}
