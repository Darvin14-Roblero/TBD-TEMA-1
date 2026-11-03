package com.darvinsistems.app.myfirstapi1.repository;

import com.darvinsistems.app.myfirstapi1.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}