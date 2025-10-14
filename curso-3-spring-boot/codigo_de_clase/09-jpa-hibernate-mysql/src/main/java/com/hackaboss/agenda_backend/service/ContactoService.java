package com.hackaboss.agenda_backend.service;

import com.hackaboss.agenda_backend.model.Contacto;
import com.hackaboss.agenda_backend.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {
@   Autowired
    private ContactoRepository repository;

    public List<Contacto> getAll() {
        return repository.findAll();
    }

    public Optional<Contacto> getById(Long id) {
        return repository.findById(id);
    }

    public Contacto create(Contacto contacto) {
        return repository.save(contacto);
    }

    public Optional<Contacto> update(Long id, Contacto contacto) {
        if (!repository.existsById(id)) return Optional.empty();
        contacto.setId(id);
        return Optional.of(repository.save(contacto));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}