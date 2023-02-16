package com.empleados.empleadosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleados.empleadosApi.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
    
}
