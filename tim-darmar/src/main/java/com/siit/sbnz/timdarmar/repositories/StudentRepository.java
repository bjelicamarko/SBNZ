package com.siit.sbnz.timdarmar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("select distinct s from Student s"
			+ " left join fetch s.interships i"
			+ " left join fetch s.passedSubjects"
			+ " left join fetch s.uniProjects"
			+ " where s.blocked = false and s.deleted = false")
	List<Student> findAllStudents();
}
