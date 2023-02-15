package com.empleados.empleadosApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.model.*;
import com.empleados.empleadosApi.model.Legajo;
import com.empleados.empleadosApi.repository.LegajoRepository;

@Service
public class LegajoService {
    private LegajoRepository legajoRepository;

    @Autowired
    public LegajoService(LegajoRepository legajoRepository){
            this.legajoRepository = legajoRepository;
    }

    public void crearLegajo(Empleado empleado){
        Legajo legajo = new Legajo(empleado,100,"jefe","no hay");
        this.legajoRepository.save(legajo);
    }

    public void eliminarLegajo(Long id){
        this.legajoRepository.deleteById(id);
    }
}
