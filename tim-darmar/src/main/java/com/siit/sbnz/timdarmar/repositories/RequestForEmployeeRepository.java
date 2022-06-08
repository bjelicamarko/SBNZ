package com.siit.sbnz.timdarmar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.RequestForEmployee;


@Repository
public interface RequestForEmployeeRepository  extends JpaRepository<RequestForEmployee, Long> {

}