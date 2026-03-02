package com.poc.soporte.usecase;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.service.EntityService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntityUseCase {

    private final EntityService entityService;

    public EntityUseCase(EntityService entityService) {
        this.entityService = entityService;
    }

    public List<Entity> findAll() {
        return entityService.findAll();
    }

    public Entity findById(Long id) {
        return entityService.findById(id).orElse(null);
    }
}