package com.upc.trabajotf.projectbienestarcompany.controller;

import com.upc.trabajotf.projectbienestarcompany.entities.Boton_Sos;
import com.upc.trabajotf.projectbienestarcompany.service.Boton_SosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sos")
public class Boton_SosController {

    @Autowired
    private Boton_SosService botonSosService;

    // Crear una nueva alerta SOS
    @PostMapping("/alert")
    public ResponseEntity<Boton_Sos> createSosAlert(@RequestBody Boton_Sos botonSos) {
        Boton_Sos newAlert = botonSosService.createSosAlert(botonSos);
        return ResponseEntity.ok(newAlert);
    }

    // Obtener todas las alertas SOS
    @GetMapping("/alerts")
    public ResponseEntity<List<Boton_Sos>> getAllSosAlerts() {
        List<Boton_Sos> alerts = botonSosService.getAllSosAlerts();
        return ResponseEntity.ok(alerts);
    }

    // Obtener una alerta SOS por su ID
    @GetMapping("/alert/{id}")
    public ResponseEntity<Boton_Sos> getSosAlertById(@PathVariable int id) {
        Optional<Boton_Sos> alert = botonSosService.getSosAlertById(id);
        return alert.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una alerta SOS por su ID
    @PutMapping("/alert/{id}")
    public ResponseEntity<Boton_Sos> updateSosAlert(@PathVariable int id, @RequestBody Boton_Sos botonSos) {
        Optional<Boton_Sos> updatedAlert = botonSosService.updateSosAlert(id, botonSos);
        return updatedAlert.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar una alerta SOS por su ID
    @DeleteMapping("/alert/{id}")
    public ResponseEntity<Void> deleteSosAlert(@PathVariable int id) {
        if (botonSosService.deleteSosAlert(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
