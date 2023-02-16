package com.empleados.empleadosApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.empleados.empleadosApi.model.*;
import com.empleados.empleadosApi.service.*;

@SpringBootApplication
public class EmpleadosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApiApplication.class, args);
	}
@Bean
    CommandLineRunner commandLineRunner(
            SucursalService sucursalService){
	return args -> {
	sucursalService.crearSucursal(new Sucursal("calle falsa 123","principal"));
	sucursalService.crearSucursal(new Sucursal("calle verdadera 123","falsa"));
	sucursalService.crearSucursal(new Sucursal("calle conocida 123","desconocida"));
	sucursalService.crearSucursal(new Sucursal("calle perdida 123","perdida"));
	sucursalService.crearSucursal(new Sucursal("calle unica 123","unica"));
		};
	
	}
}
