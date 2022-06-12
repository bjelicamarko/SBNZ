package com.siit.sbnz.timdarmar.services;

import java.util.List;

import com.siit.sbnz.timdarmar.models.classes.RequestForStudent;
import com.siit.sbnz.timdarmar.models.classes.Student;
import com.siit.sbnz.timdarmar.models.dtos.IntershipCreateDTO;
import com.siit.sbnz.timdarmar.models.dtos.ProjectCreateDTO;
import com.siit.sbnz.timdarmar.models.dtos.UniSubjectCreateDTO;

public interface StudentService {
	
	List<Student> getStudentsFromRecommendation(RequestForStudent requestForStudent);
	boolean addIntershipToStudent(IntershipCreateDTO createInterDTO);
	boolean addUniSubjectToStudent(UniSubjectCreateDTO createSubDTO);
	boolean addProjectsToStudent(ProjectCreateDTO request);
}
