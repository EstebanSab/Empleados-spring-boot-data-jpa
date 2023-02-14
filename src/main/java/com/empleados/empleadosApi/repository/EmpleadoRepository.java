package com.empleados.empleadosApi.repository;

import com.empleados.empleadosApi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


//jpql 
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
   
}
