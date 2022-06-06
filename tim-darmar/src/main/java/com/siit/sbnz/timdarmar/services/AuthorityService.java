package com.siit.sbnz.timdarmar.services;

import com.siit.sbnz.timdarmar.models.classes.Authority;

public interface AuthorityService {

	Authority findByName(String roleName);
	
}
