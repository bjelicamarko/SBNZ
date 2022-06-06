package com.siit.sbnz.timdarmar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.LanguageGlobally;

@Repository
public interface LanguageGloballyRepository extends JpaRepository<LanguageGlobally, Long>{

	LanguageGlobally findByName(String name);
	
}
