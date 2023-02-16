package com.empleados.empleadosApi.model;

import javax.persistence.*;

@Entity(name="Legajo")
@Table(
    name="legajo",
    uniqueConstraints = {
        @UniqueConstraint(name = "legajo_id_constraint" ,columnNames = "id")
    }
)
public class Legajo {

    @Id
    @SequenceGenerator(
        //name =>nombre generador clave
		name = "generadorIdLegajoEmpleado",
        //sequenceName => nombre de la secuencia de la base de datos del que se obtiene la clave
		sequenceName = "LEGAJO_EMPLEADO_GENERADOR_ID",
        //valor inicial
        initialValue=1,
        //cantidad a incrementar
		allocationSize = 1
    )
    @GeneratedValue(
        //invoca al tipo de generador a utilizar
		generator = "generadorIdLegajoEmpleado",

        //tipo de generacion a utilizar (AUTO,SEQUENCE,TABLE,IDENTITY)
		strategy = GenerationType.SEQUENCE)

    //definicion de la columna de la tabla
    //name => nombre de la tabla
    //updatable => si se puede modificar
    @Column(name = "id",
            updatable = false,
            nullable=false, 
            unique=true
    )
	private Long id;

    @Column(
        name = "sueldo",
        nullable = false,
        updatable = true
    )
    private int sueldo;

    @Column(
        name = "categoria",
        nullable = false,
        updatable = true,
        columnDefinition = "TEXT"
    )
    private String categoria;

    @Column(
        name = "amonestacion",
        nullable = true,
        updatable = true,
        columnDefinition = "TEXT"
    )
    private String amonestacion;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;


    @Column(
        name = "edad",
        nullable = false
    )
    private Integer nacimiento;



    //one to one define la relacion 
    //joincolumn se coloca en la columna que tendra la fk de la otra tabla
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "empleado_id",
        referencedColumnName = "id",
        foreignKey = @ForeignKey(
            name = "empleado_id_fk"
            )
        )
    private Empleado empleado;

    public Legajo(
        Empleado empleado,
        int sueldo,
        String categoria,
        String amonestacion,
        String email,
        Integer nacimiento
        ){
        this.sueldo =sueldo;
        this.categoria=categoria;
        this.amonestacion=amonestacion;
        this.nacimiento=nacimiento;
        this.email=email;
        this.empleado=empleado;
    }

    public Legajo(
        int sueldo,
        String categoria,
        String amonestacion,
        String email,
        Integer nacimiento
        ){
        this.sueldo =sueldo;
        this.categoria=categoria;
        this.amonestacion=amonestacion;
        this.nacimiento=nacimiento;
        this.email=email;
    }

    public Legajo(){}


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int getSueldo(){
        return this.sueldo;
    }

    public void setSueldo(int sueldo){
        this.sueldo=sueldo;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getAmonestacion(){
        return this.amonestacion;
    }

    public void setAmonestacion(String amonestacion){
         this.amonestacion = amonestacion;
    }

    public String getEmail() {
		return this.email;
	}
    public void setEmail(String email){
		this.email=email;
    }
    
    
    public void setNacimiento(Integer nacimiento){
		this.nacimiento=nacimiento;
	}

    
    public Integer getNacimiento(){
        return this.nacimiento;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


}
