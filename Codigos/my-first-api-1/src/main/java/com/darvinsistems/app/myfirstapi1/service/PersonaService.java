package com.darvinsistems.app.myfirstapi1.service;

import com.darvinsistems.app.myfirstapi1.entity.Persona;
import com.darvinsistems.app.myfirstapi1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> actualizar(Long id, Persona nuevosDatos) {
        return personaRepository.findById(id).map(persona -> {
            persona.setNombre(nuevosDatos.getNombre());
            persona.setApellido(nuevosDatos.getApellido());
            persona.setEdad(nuevosDatos.getEdad());
            return personaRepository.save(persona);
        });
    }

    public boolean eliminar(Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}