package com.empleados.empleadosApi.controller;

import com.empleados.empleadosApi.model.Empleado;
import com.empleados.empleadosApi.service.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;  
    private LegajoService legajoService;  

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService,LegajoService legajoService){
        this.empleadoService=empleadoService;
        this.legajoService=legajoService;
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
      this.legajoService.crearLegajo(empleado);
    }

    
    @PutMapping(path = "/empleado/{id}")
    public void modificarUsuario(
        @PathVariable("id") Long id,
        @RequestBody Empleado empleado) {
        this.empleadoService.modificarEmpleado(id,empleado);
    }

    //Prueba de modificacion de datos con "save"
    @PutMapping(path = "/empleado/save")
    public void modificarUsuarioConSave(@RequestBody Empleado empleado) {
        this.empleadoService.modificarEmpleadoConSave(empleado);
    }



    @DeleteMapping(path = "/delete/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id){
        this.legajoService.eliminarLegajo(id);
        this.empleadoService.eliminarEmpleado(id);
    }       

}
