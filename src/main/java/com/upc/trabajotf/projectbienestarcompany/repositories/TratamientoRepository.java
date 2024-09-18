package com.upc.trabajotf.projectbienestarcompany.repositories;

import com.upc.trabajotf.projectbienestarcompany.entities.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento,Integer> {
    @Query ("select t.nombre from Tratamiento t join Usuario u On t.usuario.id = u.id where u.id =:id and u.rol.id = 1")
    List<Tratamiento> nombre (@Param("id")int id);
