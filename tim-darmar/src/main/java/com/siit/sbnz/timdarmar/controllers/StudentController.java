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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.timdarmar.models.classes.Employer;
import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.dtos.IntershipCreateDTO;
import com.siit.sbnz.timdarmar.models.dtos.ProjectCreateDTO;
import com.siit.sbnz.timdarmar.models.dtos.RequestForStudentDTO;
import com.siit.sbnz.timdarmar.models.dtos.StudentBasicInfoDTO;
import com.siit.sbnz.timdarmar.models.dtos.StudentDTO;
import com.siit.sbnz.timdarmar.models.dtos.StudentProfileViewDTO;
import com.siit.sbnz.timdarmar.models.dtos.UniSubjectCreateDTO;
import com.siit.sbnz.timdarmar.repositories.StudentRepository;
import com.siit.sbnz.timdarmar.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
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
	
	@GetMapping(value = "/profileView")
	@PreAuthorize("hasRole('STUDENT')")
	public ResponseEntity<StudentProfileViewDTO> getStudentForProfileView() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student student = (Student)auth.getPrincipal();

		return new ResponseEntity<>(new StudentProfileViewDTO(student), HttpStatus.OK);
	}
	
	@PostMapping(value = "/createIntershipForStudent")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> createIntershipForStudent(@RequestBody IntershipCreateDTO request ) {
		boolean createBol = studentService.addIntershipToStudent(request);
		if (createBol)
			return new ResponseEntity<>("Created intership!", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Couldn't create intership!", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/setMonthlyIncome")
	@PreAuthorize("hasRole('STUDENT')")
	public ResponseEntity<String> setMonthlyIncome(@RequestBody double income ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student student = (Student)auth.getPrincipal();
		
		student.setMonthlyIncomeByFamilyMember(income);
		studentRepository.save(student);
		return new ResponseEntity<>("Monthly income set!", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/createUniSubjectForStudent")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> createUniSubjectForStudent(@RequestBody UniSubjectCreateDTO request ) {
		boolean createBol = studentService.addUniSubjectToStudent(request);
		if (createBol)
			return new ResponseEntity<>("Created college subject!", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Couldn't create college subject!", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/createProjectsForStudent")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> createProjectsForStudent(@RequestBody ProjectCreateDTO request ) {
		boolean createBol = studentService.addProjectsToStudent(request);
		if (createBol)
			return new ResponseEntity<>("Created college projects!", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Couldn't create college projects!", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/getStudentsNamesWithIDs")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<StudentBasicInfoDTO>> getStudentsNamesWithIDs() {
		List<Student> studs = studentRepository.findAllStudents();
		List<StudentBasicInfoDTO> studsDTO = new ArrayList<>();
		for (Student st : studs) {
			studsDTO.add(new StudentBasicInfoDTO(st));
		}
		return new ResponseEntity<>(studsDTO, HttpStatus.OK);
	}
}
