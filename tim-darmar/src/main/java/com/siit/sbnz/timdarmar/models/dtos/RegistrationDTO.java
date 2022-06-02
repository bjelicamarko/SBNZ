package com.siit.sbnz.timdarmar.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	
	
}