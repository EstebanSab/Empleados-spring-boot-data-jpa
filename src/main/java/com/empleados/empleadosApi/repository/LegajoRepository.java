package com.empleados.empleadosApi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.empleados.empleadosApi.model.Legajo;

public interface LegajoRepository extends JpaRepository<Legajo, Long>{

/* 
    @Transactional
    @Modifying
    @Query("DELETE FROM Legajo l WHERE l.empleado_id = ?1")
    int deleteLegajoByEmpleadoId(Long id);
    */
}
