package com.upc.trabajotf.projectbienestarcompany.controller;

import com.upc.trabajotf.projectbienestarcompany.entities.Grupo_Apoyo;
import com.upc.trabajotf.projectbienestarcompany.service.Grupo_ApoyoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos-apoyo")
public class Grupo_ApoyoController {

    @Autowired
    private Grupo_ApoyoService grupoApoyoService;

    // Crear un nuevo grupo de apoyo
    @PostMapping("/grupo")
    public ResponseEntity<Grupo_Apoyo> createGrupoApoyo(@RequestBody Grupo_Apoyo grupoApoyo) {
        Grupo_Apoyo newGroup = grupoApoyoService.createGrupoApoyo(grupoApoyo);
        return ResponseEntity.ok(newGroup);
    }

    // Obtener todos los grupos de apoyo
    @GetMapping("/grupos")
    public ResponseEntity<List<Grupo_Apoyo>> getAllGruposApoyo() {
        List<Grupo_Apoyo> grupos = grupoApoyoService.getAllGruposApoyo();
        return ResponseEntity.ok(grupos);
    }

    // Obtener un grupo de apoyo por su ID
    @GetMapping("/grupo/{id}")
    public ResponseEntity<Grupo_Apoyo> getGrupoApoyoById(@PathVariable int id) {
        Optional<Grupo_Apoyo> grupo = grupoApoyoService.getGrupoApoyoById(id);
        return grupo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un grupo de apoyo por su ID
    @PutMapping("/grupo/{id}")
    public ResponseEntity<Grupo_Apoyo> updateGrupoApoyo(@PathVariable int id, @RequestBody Grupo_Apoyo grupoApoyo) {
        Optional<Grupo_Apoyo> updatedGrupo = grupoApoyoService.updateGrupoApoyo(id, grupoApoyo);
        return updatedGrupo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un grupo de apoyo por su ID
    @DeleteMapping("/grupo/{id}")
    public ResponseEntity<Void> deleteGrupoApoyo(@PathVariable int id) {
        if (grupoApoyoService.deleteGrupoApoyo(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
