package com.siit.sbnz.timdarmar.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.Authority;
import com.siit.sbnz.timdarmar.models.classes.Client;
import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;
import com.siit.sbnz.timdarmar.repositories.ClientRepository;
import com.siit.sbnz.timdarmar.services.AuthorityService;
import com.siit.sbnz.timdarmar.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
    private ApplicationContext context;
	
	@Autowired
	private AuthorityService authorityService;
	
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

	@Override
	public void register(RegistrationDTO registrationDTO) {
		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		
		Client c = null;
		if (registrationDTO.getRole().equals("ROLE_EMPLOYER")) {
			c = new Employer(registrationDTO);
		} else if (registrationDTO.getRole().equals("ROLE_EMPLOYEE")) {
			c = new Employee(registrationDTO);
		} else  { // ROLE_STUDENT
			c = new Student(registrationDTO);
		}
		Authority a = authorityService.findByName(c.getRole());
		c.getRoles().add(a);
	
		clientRepository.save(c);
	}

}
