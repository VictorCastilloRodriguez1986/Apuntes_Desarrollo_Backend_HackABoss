package com.hackaboss.agenda_backend.repository;


import com.hackaboss.agenda_backend.model.Contacto;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ContactoRepository {

    private final Map<Long, Contacto> contactos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Contacto> findAll() {
        return new ArrayList<>(contactos.values());
    }

    public Optional<Contacto> findById(Long id) {
        return Optional.ofNullable(contactos.get(id));
    }

    public Contacto save(Contacto contacto) {
        if (contacto.getId() == null) {
            contacto.setId(idGenerator.incrementAndGet());
        }
        contactos.put(contacto.getId(), contacto);
        return contacto;
    }

    public boolean existsById(Long id) {
        return contactos.containsKey(id);
    }

    public void deleteById(Long id) {
        contactos.remove(id);
    }
}