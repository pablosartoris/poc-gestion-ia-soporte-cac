package com.poc.soporte.controller;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.usecase.EntityUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
@Tag(name = "Entities", description = "Endpoints para consultar entidades")
public class EntityController {

    private final EntityUseCase entityUseCase;

    public EntityController(EntityUseCase entityUseCase) {
        this.entityUseCase = entityUseCase;
    }

    @GetMapping
    @Operation(summary = "Listar entidades", description = "Devuelve todas las entidades disponibles")
    public ResponseEntity<List<Entity>> findAll() {
        return ResponseEntity.ok(entityUseCase.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entidad por ID", description = "Devuelve una entidad según su identificador")
    public ResponseEntity<Entity> findById(@PathVariable Long id) {
        Entity entity = entityUseCase.findById(id);
        if (entity == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Entidad no encontrada con id: " + id
            );
        }
        return ResponseEntity.ok(entity);
    }
}