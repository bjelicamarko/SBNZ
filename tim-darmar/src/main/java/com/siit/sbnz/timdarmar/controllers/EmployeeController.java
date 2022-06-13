package com.siit.sbnz.timdarmar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeBasicInfoDTO;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeDTO;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeSearchResDTO;
import com.siit.sbnz.timdarmar.models.dtos.RequestForEmployeeDTO;
import com.siit.sbnz.timdarmar.services.EmployeeService;
import com.siit.sbnz.timdarmar.services.RequestForEmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RequestForEmployeeService requestForEmployeeService;
	
	@PostMapping(value = "/getEmployeesFromRecommendation")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<List<EmployeeDTO>> getEmployeesFromRecommendation(@RequestBody RequestForEmployeeDTO request ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		if (employer.isPenalty())
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		RequestForEmployee rfe = requestForEmployeeService.saveRequestForEmployee(new RequestForEmployee(request, employer));
		List<Employee> employees = employeeService.getEmployeesFromRecommendation(rfe, 
				request.getAreaOfExpertises(), request.getRequiredLanguages());
		List<EmployeeDTO> dtos = new ArrayList<>();
		for (Employee e : employees)
			dtos.add(new EmployeeDTO(e));
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findEmployeeByEmail/{email}")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<EmployeeDTO> findEmployeeByEmail(@PathVariable String email) {
		Employee e  = employeeService.findEmployeeByEmail(email);
		return new ResponseEntity<>(new EmployeeDTO(e), HttpStatus.OK);	
	}
	
	@GetMapping(value = "/profileOfEmployee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<EmployeeDTO> profileOfEmployee() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		Employee e  = employeeService.findEmployeeByEmail(employee.getEmail());
		return new ResponseEntity<>(new EmployeeDTO(e), HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateEmployee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO emp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		Employee e  = employeeService.findEmployeeByEmail(employee.getEmail());
		employeeService.updateEmployee(emp, e);
		return new ResponseEntity<>(new EmployeeDTO(e), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFriendsOfEmployee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<EmployeeBasicInfoDTO>> getFriendsOfEmployee() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		
		Employee e  = employeeService.getEmployeeWithFriends(employee.getId());
		
		List<EmployeeBasicInfoDTO> res = new ArrayList<>();
		
		for (Employee emp : e.getFriendsGroup()) {
			res.add(new EmployeeBasicInfoDTO(emp));
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getNonFriendsOfEmployee")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<List<EmployeeBasicInfoDTO>> getNonFriendsOfEmployee() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		
		Employee e  = employeeService.getEmployeeWithFriends(employee.getId());
		
		List<Long> friendIDS = new ArrayList<>();
		
		for (Employee emp : e.getFriendsGroup()) {
			friendIDS.add(emp.getId());
		}
		
		if (friendIDS.size() == 0)
			friendIDS.add(e.getId());
		
		System.out.println("friends: " + friendIDS.size());
		List<Employee> employees  = employeeService.findNonFriendsOfEmployee(employee.getId(), friendIDS);
		System.out.println("non friends: " + employees.size());
		
		List<EmployeeBasicInfoDTO> res = new ArrayList<>();
		
		for (Employee emp : employees) {
			res.add(new EmployeeBasicInfoDTO(emp));
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployeeSearchResults/{spec}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<EmployeeSearchResDTO> getEmployeeFromSearchResults(@PathVariable(value="spec") String spec) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		
		Employee e  = employeeService.searchFriendNetworkForOneWithExperience(employee.getId(), spec);
		
		if (employee.getId().equals(e.getId())) {
			return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
		}
		
		if (e == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
		System.out.println("res: " + e.getId());
		return new ResponseEntity<>(new EmployeeSearchResDTO(e), HttpStatus.ALREADY_REPORTED);
		
	}
	
	@PostMapping(value = "/addFriend")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ResponseEntity<EmployeeBasicInfoDTO> addFriend(@RequestBody Long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employee employee = (Employee)auth.getPrincipal();
		
		Employee res = employeeService.addFriend(employee, id);
		if (res == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(new EmployeeBasicInfoDTO(res), HttpStatus.OK);
		
	}
}
