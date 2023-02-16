package com.empleados.empleadosApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.model.Sucursal;
import com.empleados.empleadosApi.repository.SucursalRepository;

@Service
public class SucursalService {

    private SucursalRepository sucursalRepository;
    
    @Autowired
    public SucursalService(SucursalRepository sucursalRepository){
        this.sucursalRepository=sucursalRepository;
    }

    public void crearSucursal(Sucursal sucursal){
        this.sucursalRepository.save(sucursal);
    }

    public List<Sucursal> getAllSucursales(){
        return this.sucursalRepository.findAll();
    }

    public Sucursal getSucursalById(Long id){
        return  this.sucursalRepository.findById(id).get();
    }

    public void guardarCambiosSucursal(Sucursal sucursal) {
        this.sucursalRepository.save(sucursal);
    }

    public void eliminarSucursal(Long id){
        this.sucursalRepository.deleteById(id);
    }

    //public void guardarEmpleado(Empleado empleado,Long idSucursal){
    //    
    //    Sucursal miSucursal =  this.sucursalRepository.findById(idSucursal).get();  
    //    miSucursal.addEmpleado(empleado);
    //    this.sucursalRepository.save(miSucursal);
    //} 

}
