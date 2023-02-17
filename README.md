## Table of Contents
1. [Informacion general](#Informacion-general)
2. [Tecnologias](#Tecnologia)
3. [Estructura](#Estructura)

### Informacion general
***
Este proyecto fue creado para aprender los conceptos mas importantes de Spring Boot Data JPA.

## Tecnologias
***
Lista de herramientas y tecnologias utilizadas en el proyecto:
* PostgreSQL
* JAVA
* Spring Boot 
* JPA
* Hibernate
## Estructura
***
Este proyecto fue construido con el modelo de capas:
* Controller
  * EmpleadoController.java
  * ClienteController.java
  * LegajoController.java
  * SucursalController.java
* Service
  * EmpleadoService.java
  * ClienteService.java
  * SucursalService.java
  * LegajoService.java
  * TransaccionService.java
* Repository
  * EmpleadoRepository.java
  * ClienteRepository.java
  * SucursalRepository.java
  * LegajoRepository.java
* Model
  * Empleado.java
  * Cliente.java
  * Sucursal.java
  * Legajo.java

Relaciones entre Entidades:
* one Sucursal to many Empleado
* one Empleado to one Legajo
* many Cliente to many Sucursal
