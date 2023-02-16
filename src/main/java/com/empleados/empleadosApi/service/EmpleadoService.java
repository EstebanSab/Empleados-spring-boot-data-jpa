package com.empleados.empleadosApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.model.Empleado;
import com.empleados.empleadosApi.model.Sucursal;
import com.empleados.empleadosApi.repository.EmpleadoRepository;


@Service
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;
    private SucursalService sucursalService;

    
    @Autowired
    public EmpleadoService(
        EmpleadoRepository empleadoRepository,
        SucursalService sucursalService
        ){
        this.empleadoRepository=empleadoRepository;
        this.sucursalService =sucursalService;
    }

    public List<Empleado> getAllEmpleados() {
        return this.empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(Long id) {
        //optional devuelve null o el objeto encontrado
        Optional<Empleado> miEmpleado = this.empleadoRepository.findById(id);
        return miEmpleado.orElse(new Empleado());
    }

    public List<Empleado> getEmpleadoByName(String nombre){
        //Utilizamos el metodo creado en el EmpleadoRepository
        return this.empleadoRepository.selectEmpleadosWhereNombre(nombre);
    }

    public void crearEmpleado(Empleado empleadoParametro,Long idSucursal) {
        Sucursal miSucursalById;
        Empleado empleadoNuevoCreado;
        
        //Obtengo la sucursal por la id en el parametro
        //miSucursalById =  this.sucursalRepository.findById(idSucursal).get();
        miSucursalById = this.sucursalService.getSucursalById(idSucursal);
        
        //Seteo la sucursal obtenida en el nuevo Empleado
        empleadoParametro.setSucursal(miSucursalById);
        
        //Guardo el empleado en la base de datos y lo guardo en una variable
        empleadoNuevoCreado = this.empleadoRepository.save(empleadoParametro);
        
        //Agrego el empleado a la sucursal obtenida por id
        miSucursalById.addEmpleado(empleadoNuevoCreado);

        //guardo cambios de la sucursal
        //this.sucursalRepository.save(miSucursalById);
        this.sucursalService.guardarCambiosSucursal(miSucursalById);
    }

    public void eliminarEmpleado(Long id) {
        this.empleadoRepository.deleteEmpleadoById(id);
    }

    public void modificarEmpleado(Long id, Empleado mEmpleado) {
        String nombre = mEmpleado.getNombre();
        //String apellido = mEmpleado.getApellido();
        this.empleadoRepository.modificaNombreEmpleadoById(nombre,id);
    }

    //prueba modificar empleado con "save"
    public void modificarEmpleadoConSave(Empleado empleado) {
        this.empleadoRepository.save(empleado);
    }


}