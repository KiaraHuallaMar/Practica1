package com.upc.trabajotf.projectbienestarcompany.controller;

import com.upc.trabajotf.projectbienestarcompany.dtos.Grupo_ApoyoDTO;
import com.upc.trabajotf.projectbienestarcompany.entities.Grupo_Apoyo;
import com.upc.trabajotf.projectbienestarcompany.serviceinterfaces.Grupo_ApoyoServiceInterfaces;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grupos-apoyo")
public class Grupo_ApoyoController {

    @Autowired
    private Grupo_ApoyoServiceInterfaces grupoApoyoServiceInterfaces;

    //Listar Grupo de Apoyo
    @GetMapping
    public List<Grupo_ApoyoDTO> obtenerGrupos(){

        return grupoApoyoServiceInterfaces.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,Grupo_ApoyoDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar Grupo de Apoyo
    @PostMapping
    public void registrar(@RequestBody Grupo_ApoyoDTO grupoApoyoDTO){
        ModelMapper m = new ModelMapper();
        Grupo_Apoyo grupoApoyo = m.map(grupoApoyoDTO, Grupo_Apoyo.class);
        grupoApoyoServiceInterfaces.registrar(grupoApoyo);
    }

    //Listar por Id Grupo de Apoyo
    @GetMapping("/{id}")
    public Grupo_ApoyoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        Grupo_ApoyoDTO grupoApoyoDTO=m.map(grupoApoyoServiceInterfaces.listarId(id),Grupo_ApoyoDTO.class);
        return grupoApoyoDTO;
    }

    //Actualizar Grupo de Apoyo
    @PutMapping
    public void actualizar(@RequestBody Grupo_ApoyoDTO grupoApoyoDTO){
        ModelMapper m=new ModelMapper();
        Grupo_Apoyo grupoApoyo=m.map(grupoApoyoDTO,Grupo_Apoyo.class);
        grupoApoyoServiceInterfaces.actualizar(grupoApoyo);
    }

    //Eliminar Grupo de Apoyo
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        grupoApoyoServiceInterfaces.eliminar(id);
    }
}

