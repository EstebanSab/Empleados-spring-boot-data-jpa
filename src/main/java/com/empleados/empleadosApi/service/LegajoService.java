package com.empleados.empleadosApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.empleados.empleadosApi.model.Legajo;
import com.empleados.empleadosApi.repository.LegajoRepository;

@Service
public class LegajoService {
    private LegajoRepository legajoRepository;
    private EmpleadoService empleadoService; 

    @Autowired
    public LegajoService(
        LegajoRepository legajoRepository,
        EmpleadoService empleadoService){
            this.legajoRepository = legajoRepository;
            this.empleadoService = empleadoService;
    }

    public void crearLegajo(Long idEmpleado,Legajo legajo){
        Legajo legajoEmpleado = new Legajo(
            empleadoService.getEmpleadoById(idEmpleado),
            legajo.getSueldo(),
            legajo.getCategoria(),
            legajo.getAmonestacion());
        this.legajoRepository.save(legajoEmpleado);
    }

    public void eliminarLegajo(Long id){
        this.legajoRepository.deleteLegajoByEmpleadoid(id);
    }

    public List<Legajo> getAllLegajos() {
        return this.legajoRepository.findAll();
    }
}
