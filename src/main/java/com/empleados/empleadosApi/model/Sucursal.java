package com.empleados.empleadosApi.model;


import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;



@Entity(name="Sucursal")
@Table(
    name="sucursal",
    uniqueConstraints ={
        @UniqueConstraint(name = "sucursal_id_constraint", columnNames = "id")
    }
)
public class Sucursal {
    @Id
	@SequenceGenerator(
		name = "generadorIdSucursal",
		sequenceName = "SUCURSAL_GENERADOR_ID",
        initialValue=1,
		allocationSize = 1
	)

	@GeneratedValue(
		generator = "generadorIdSucursal",
		strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false,
            nullable=false, 
            unique=true
    )
	private Long id;

    @Column(
        name = "direccion",
        updatable=true,
        nullable = false,
        unique = false
    )
    private String direccion;

    @Column(
        name = "nombre",
        updatable=true,
        nullable = false,
        unique = false
    )
    private String nombre;



    //una sucursal esta relacionada con muchos empleados
    //un empleado esta relacionado con una y solo una sucursal
    //obtener todos los empleados
    //id de sucursal en empleado
    @OneToMany(
        mappedBy = "sucursal",
        orphanRemoval = true,
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        fetch = FetchType.LAZY
        )
    private List<Empleado> empleados = new ArrayList<Empleado>();


    public void addEmpleado(Empleado empleado) {
        if (!this.empleados.contains(empleado)) {
            this.empleados.add(empleado);
            //empleado.setSucursal(this);
        }
    }

    public void removeEmpleado(Empleado empleado) {
        if (this.empleados.contains(empleado)) {
            this.empleados.remove(empleado);
            empleado.setSucursal(null);
        }
    }


    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public Sucursal(){}

    public Sucursal(String direccion,String nombre){
        this.direccion =direccion;
        this.nombre=nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}

