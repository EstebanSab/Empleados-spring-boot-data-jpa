package com.empleados.empleadosApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.empleados.empleadosApi.model.Sucursal;
import com.empleados.empleadosApi.service.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {
    SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService){
        this.sucursalService=sucursalService;
    }

    @GetMapping
    public List<Sucursal> getAllSucursales(){
      return  this.sucursalService.getAllSucursales();
    }

    @PostMapping
    public void crearSucursal(@RequestBody Sucursal sucursal){
        this.sucursalService.crearSucursal(sucursal);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void eliminarSucursal(@PathVariable("id") Long id){
        this.sucursalService.eliminarSucursal(id);
    }      

}
