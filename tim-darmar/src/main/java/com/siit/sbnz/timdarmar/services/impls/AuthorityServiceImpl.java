package com.siit.sbnz.timdarmar.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.Authority;
import com.siit.sbnz.timdarmar.repositories.AuthorityRepository;
import com.siit.sbnz.timdarmar.services.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority findByName(String roleName) { return authorityRepository.findByName(roleName); }
	
}
