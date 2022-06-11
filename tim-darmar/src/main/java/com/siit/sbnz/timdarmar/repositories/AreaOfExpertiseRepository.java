package com.siit.sbnz.timdarmar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertise;
import com.siit.sbnz.timdarmar.models.classes.AreaOfExpertiseGlobally;

@Repository
public interface AreaOfExpertiseRepository extends JpaRepository<AreaOfExpertise, Long>{
	
}
