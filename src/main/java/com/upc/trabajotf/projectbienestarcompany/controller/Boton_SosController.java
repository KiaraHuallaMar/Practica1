package com.upc.trabajotf.projectbienestarcompany.controller;

import com.upc.trabajotf.projectbienestarcompany.dtos.Boton_SosDTO;
import com.upc.trabajotf.projectbienestarcompany.entities.Boton_Sos;
import com.upc.trabajotf.projectbienestarcompany.serviceinterfaces.Boton_SosServiceInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/botonsos")
public class Boton_SosController {

    @Autowired
    private Boton_SosServiceInterfaces botonSosServiceInterfaces;

    // Listar los botones sos
    @GetMapping
    public List<Boton_SosDTO> obtenerBotones() {

        return botonSosServiceInterfaces.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Boton_SosDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar los botones sos
    @PostMapping
    public void registrar(@RequestBody Boton_SosDTO botonSosDTO){
        ModelMapper m = new ModelMapper();
        Boton_Sos botonSos = m.map(botonSosDTO, Boton_Sos.class);
        botonSosServiceInterfaces.registrar(botonSos);
    }

    //Listar por Id los botones sos
    @GetMapping("/{id}")
    public Boton_SosDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        Boton_SosDTO botonSosDTO=m.map(botonSosServiceInterfaces.listarId(id),Boton_SosDTO.class);
        return botonSosDTO;
    }

    //Actualizar los botones sos
    @PutMapping
    public void actualizar(@RequestBody Boton_SosDTO botonSosDTO){
        ModelMapper m=new ModelMapper();
        Boton_Sos botonSos=m.map(botonSosDTO,Boton_Sos.class);
        botonSosServiceInterfaces.actualizar(botonSos);
    }

    //Eliminar los botones sos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        botonSosServiceInterfaces.eliminar(id);
    }

}