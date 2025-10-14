package com.hackaboss.topsecret.repository;

import com.hackaboss.topsecret.model.Archivo;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ArchivoRepository {
    private final Map<Long, Archivo> archivos = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Archivo> obtenerDesclasificados() {
        return archivos.values().stream()
                .filter(Archivo::isDesclasificado)
                .toList();
    }

    public List<Archivo> obtenerClasificados() {
        return archivos.values().stream()
                .filter(a -> !a.isDesclasificado())
                .toList();
    }

    public Archivo guardar(Archivo archivo) {
        Long id = idGenerator.incrementAndGet();
        archivo.setId(id);
        archivos.put(id, archivo);
        return archivo;
    }

    public void eliminar(Long id) {
        archivos.remove(id);
    }
}