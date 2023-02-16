package com.empleados.empleadosApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.model.Empleado;
import com.empleados.empleadosApi.model.Sucursal;
import com.empleados.empleadosApi.repository.SucursalRepository;

@Service
public class SucursalService {

    SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository){
        this.sucursalRepository=sucursalRepository;
    }

    public void crearSucursal(Sucursal sucursal){
        this.sucursalRepository.save(sucursal);
    }

    public void guardarEmpleado(Empleado empleado,Long idSucursal){
        Sucursal miSucursal =  this.sucursalRepository.findById(idSucursal).get();  
        miSucursal.addEmpleado(empleado);
        this.sucursalRepository.save(miSucursal);
    }

    public List<Empleado> empleadosSucursal(Long idSucursal){
        return this.sucursalRepository.findById(idSucursal).get().getEmpleados();
    }
}
