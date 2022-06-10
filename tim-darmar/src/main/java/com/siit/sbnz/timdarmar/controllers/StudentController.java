package com.siit.sbnz.timdarmar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employee;
import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;
import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.dtos.EmployeeDTO;
import com.siit.sbnz.timdarmar.models.dtos.RequestForEmployeeDTO;
import com.siit.sbnz.timdarmar.models.dtos.RequestForStudentDTO;
import com.siit.sbnz.timdarmar.models.dtos.StudentDTO;
import com.siit.sbnz.timdarmar.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/getStudentsFromRecommendation")
	@PreAuthorize("hasRole('EMPLOYER')")
	public ResponseEntity<List<StudentDTO>> getEmployeesFromRecommendation(@RequestBody RequestForStudentDTO request ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Employer employer = (Employer)auth.getPrincipal();
		
		RequestForStudent rqs = new RequestForStudent(request, employer);
		List<Student> students = studentService.getStudentsFromRecommendation(rqs);
		
		List<StudentDTO> dtos = new ArrayList<>();
		for (Student s : students)
			dtos.add(new StudentDTO(s));
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
