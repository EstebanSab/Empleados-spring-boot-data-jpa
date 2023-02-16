package com.empleados.empleadosApi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="Cliente")
@Table(
    name="cliente",
    uniqueConstraints ={
        @UniqueConstraint(name = "cliente_id_constraint", columnNames = "id")
    }
)
public class Cliente {
    @Id
	@SequenceGenerator(
		name = "generadorIdCliente",
		sequenceName = "CLIENTE_GENERADOR_ID",
        initialValue=1,
		allocationSize = 1
	)

	@GeneratedValue(
		generator = "generadorIdCliente",
		strategy = GenerationType.SEQUENCE)
    @Column(name = "id",
            updatable = false,
            nullable=false, 
            unique=true
    )
	private Long id;

    @Column(
        name = "nombre",
        updatable=true,
        nullable = false,
        unique = false
    )
    private String nombre;


    @ManyToMany
    @JoinTable(
        name = "transacciones",
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales = new ArrayList<Sucursal>();


    public void addSucursal(Sucursal sucursal) {
        if (!this.sucursales.contains(sucursal)) {
            this.sucursales.add(sucursal);
        }
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}