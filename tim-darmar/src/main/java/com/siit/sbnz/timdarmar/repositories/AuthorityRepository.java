package com.siit.sbnz.timdarmar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	Authority findByName(String name);
	
}
