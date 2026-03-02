package com.poc.soporte.controller;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.service.EntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
@Tag(name = "Entities", description = "Endpoints para consultar entidades")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    @Operation(summary = "Listar entidades", description = "Devuelve todas las entidades disponibles")
    public ResponseEntity<List<Entity>> findAll() {
        return ResponseEntity.ok(entityService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entidad por ID", description = "Devuelve una entidad según su identificador")
    public ResponseEntity<Entity> findById(@PathVariable Long id) {
        Entity entity = entityService.findById(id);
        return ResponseEntity.ok(entity);
    }
}