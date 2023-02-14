package com.empleados.empleadosApi.model;
import javax.persistence.*;


//Entity nombre del la clase
//Con @Table se mapea la clase por la tabla si el nombre no es igual
@Entity(name="Empleado")
@Table( 
    name="empleado",
    uniqueConstraints = {
            @UniqueConstraint(name = "empleado_id_constraint", columnNames = "id")
    }
)
public class Empleado {
	@Id
	@SequenceGenerator(
        //name =>nombre generador clave
		name = "generadorIdEmpleado",
        //sequenceName => nombre de la secuencia de la base de datos del que se obtiene la clave
		sequenceName = "EMPLEADO_GENERADOR_ID",
        //valor inicial
        initialValue=1,
        //cantidad a incrementar
		allocationSize = 1
	)

	@GeneratedValue(
        //invoca al tipo de generador a utilizar
		generator = "generadorIdEmpleado",

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



	@Column(name="nombre",
            nullable = false,
            columnDefinition = "TEXT")
	private  String nombre;

	@Column(name="apellido",
            nullable = false,
            columnDefinition = "TEXT")
	private String apellido;

	@Column(name="trabajo",
            nullable = false,
            columnDefinition = "TEXT")
	private  String trabajo;

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
    private Integer edad;


	public Empleado(
        String nombre,
        String apellido,
        String trabajo,
        String email,
        Integer edad) {
		this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
        this.edad=edad;
        this.email=email;
	}

	public Empleado() {}



	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

    public String getApellido() {
		return this.apellido;
	}

	public String getTrabajo() {
		return this.trabajo;
	}

    public Integer getEdad(){
        return this.edad;
    }

    public String getEmail() {
		return this.email;
	}


    public void setId(Long id){
		this.id = id;
	}
    
    public void setNombre(String nuevoNombre) {
        this.nombre=nuevoNombre;
	}

    public void setApellido(String nuevoApellido) {
        this.apellido=nuevoApellido;
	}

	public void setTrabajo(String nuevoTrabajo){
		this.trabajo=nuevoTrabajo;
	}

    public void setEdad(Integer edad){
		this.edad=edad;
	}

    public void setEmail(String email){
		this.email=email;
	}

	

}
