package com.poc.soporte.controller;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public ResponseEntity<List<Entity>> findAll() {
        return ResponseEntity.ok(entityService.findAll());
    }
}
