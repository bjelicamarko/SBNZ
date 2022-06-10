package com.siit.sbnz.timdarmar.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.repositories.RequestForEmployeeRepository;
import com.siit.sbnz.timdarmar.services.RequestForEmployeeService;

@Service
public class RequestForEmployeeServiceImpl implements RequestForEmployeeService {

	@Autowired
	private RequestForEmployeeRepository requestForEmployeeRepository;
	
	@Override
	public RequestForEmployee saveRequestForEmployee(RequestForEmployee requestForEmployee) {
		return requestForEmployeeRepository.save(requestForEmployee);
	}

	@Override
	public RequestForEmployee getRequest(String email) {
		return requestForEmployeeRepository
				.getRequests(email).get(0);
	}

}
