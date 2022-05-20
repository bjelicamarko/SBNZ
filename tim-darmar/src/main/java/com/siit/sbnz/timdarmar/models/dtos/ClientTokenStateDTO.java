package com.siit.sbnz.timdarmar.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientTokenStateDTO {
	
	private String accessToken;
	private Long expiresIn;
	

}
