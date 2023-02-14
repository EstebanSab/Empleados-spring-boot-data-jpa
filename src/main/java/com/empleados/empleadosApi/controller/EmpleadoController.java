package com.empleados.empleadosApi.controller;

import com.empleados.empleadosApi.model.Empleado;
import com.empleados.empleadosApi.service.EmpleadoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;    

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }
                  

    @GetMapping
    public List<Empleado> getAllUsuarios() {
        return this.empleadoService.getAllEmpleados();
    }

    @GetMapping("/empleado/{id}")
     public Empleado getOneUsuario(@PathVariable Long id) {
        return this.empleadoService.getEmpleadoById(id);
    }

    @GetMapping("/empleado")
     public List<Empleado> getEmpleadoByName(@RequestParam(value = "empleado", defaultValue = "juan") String nombre) {
        return this.empleadoService.getEmpleadoByName(nombre);
    }


    @PostMapping
    public void agregarNuevoEmpleado(@RequestBody Empleado empleado) {
      this.empleadoService.crearEmpleado(empleado);
    }

    
    @PutMapping(path = "/empleado/{id}")
    public void modificarUsuario(
        @PathVariable("id") Long id,
        @RequestBody Empleado empleado) {
        this.empleadoService.modificarEmpleado(id,empleado);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id){
        this.empleadoService.eliminarEmpleado(id);
    }       

}
