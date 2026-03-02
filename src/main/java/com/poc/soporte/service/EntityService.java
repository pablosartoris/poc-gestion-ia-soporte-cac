package com.poc.soporte.service;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.repository.EntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entity> findAll() {
        return entityRepository.findAll();
    }

    public Optional<Entity> findById(Long id) {
        return entityRepository.findById(id);
    }
}