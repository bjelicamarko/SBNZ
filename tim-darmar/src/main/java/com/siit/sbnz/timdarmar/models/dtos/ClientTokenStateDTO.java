package com.siit.sbnz.timdarmar.models.dtos;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientTokenStateDTO {
	private String accessToken;
	private Long expiresIn;
	
	public ClientTokenStateDTO(String accessToken, long expiresIn) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
