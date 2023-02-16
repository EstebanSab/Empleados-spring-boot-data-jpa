package com.empleados.empleadosApi.repository;

import com.empleados.empleadosApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
