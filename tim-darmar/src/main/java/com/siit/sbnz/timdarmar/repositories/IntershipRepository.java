package com.siit.sbnz.timdarmar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siit.sbnz.timdarmar.models.classes.Intership;

@Repository
public interface IntershipRepository extends JpaRepository<Intership, Long> {

}
