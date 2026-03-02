package com.poc.soporte.controller;

import com.poc.soporte.entity.Entity;
import com.poc.soporte.service.EntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Entities", description = "Operaciones sobre entidades")
@RestController
@RequestMapping("/api/entities")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @Operation(summary = "Listar todas las entidades", description = "Devuelve el listado completo de entidades almacenadas en la base de datos")
    @GetMapping
    public ResponseEntity<List<Entity>> findAll() {
        return ResponseEntity.ok(entityService.findAll());
    }
}
