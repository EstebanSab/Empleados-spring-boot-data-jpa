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

  
    
    @OneToOne(
            mappedBy = "empleado",
            orphanRemoval = true
    )
    private Legajo legajoEmpleado;

    //Sucursal tiene muchos empleados
    //Empleado solo trabaja en una y solo una sucursal
    //Empleado va a tener la columna adicional que se va conectar 
    //con la pk de sucursal
    @ManyToOne
    @JoinColumn(
            name = "sucursal_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "sucursal_empleado_fk"
            )
    )
    private Sucursal sucursal;


	public Empleado(
        String nombre,
        String apellido,
        String trabajo,
        Sucursal sucursal
        ) {
		this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
        this.sucursal = sucursal;
	}

	public Empleado() {}

    public Empleado(
        String nombre,
        String apellido,
        String trabajo
        ) {
		this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
	}


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


    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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

}
