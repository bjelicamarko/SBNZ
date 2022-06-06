package com.siit.sbnz.timdarmar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Client;
import com.siit.sbnz.timdarmar.models.dtos.ClientTokenStateDTO;
import com.siit.sbnz.timdarmar.models.dtos.RegistrationDTO;
import com.siit.sbnz.timdarmar.security.TokenUtils;
import com.siit.sbnz.timdarmar.security.auth.JwtAuthenticationRequest;
import com.siit.sbnz.timdarmar.services.ClientService;

@RestController
@RequestMapping("api/users")
public class ClientController {

	@Autowired
    private TokenUtils tokenUtils;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientService clientService;
    
    @PostMapping("/login")
    public ResponseEntity<ClientTokenStateDTO> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)  {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        // Put client in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create a token for client
        Client client = (Client) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(client.getUsername(), client.getRole());
        int expiresIn = tokenUtils.getExpiredIn();
       
        // Return token as answer
        return ResponseEntity.ok(new ClientTokenStateDTO(jwt, (long)expiresIn));
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationDTO registrationDTO) {
    	clientService.register(registrationDTO);
    	return new ResponseEntity<>("Registration successfully finished.", HttpStatus.OK);
    }
}
