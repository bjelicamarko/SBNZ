package com.siit.sbnz.timdarmar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.Client;
import com.siit.sbnz.timdarmar.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepository.findByEmail(username).orElse(null);
        if (client == null) {
            throw new UsernameNotFoundException(String.format("No client found with that email '%s'.", username));
        }
        else{
            return client;
        }
	}

}
