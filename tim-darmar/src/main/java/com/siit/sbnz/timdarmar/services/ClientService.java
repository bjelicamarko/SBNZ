package com.siit.sbnz.timdarmar.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;

public interface ClientService extends UserDetailsService {
	
	void register(RegistrationDTO registrationDTO);
	
}
