package com.poc.soporte.service;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.repository.EntityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    public Entity findById(Long id) {
        return entityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Entidad no encontrada con id: " + id
                ));
    }
}