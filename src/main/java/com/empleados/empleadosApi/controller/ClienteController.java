package com.empleados.empleadosApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.empleados.empleadosApi.service.*;
import com.empleados.empleadosApi.model.Cliente;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {
    private ClienteService clienteService;
    private TransaccionService transaccionService;

    @Autowired
    public ClienteController(
        ClienteService clienteService,
        TransaccionService transaccionService){
        this.clienteService = clienteService;
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        return this.clienteService.getAllClientes();
    }

    @PostMapping
    public void agregarCliente(@RequestBody Cliente cliente ){
        this.clienteService.guardarCliente(cliente);
    }

    @PutMapping(path = "/cliente/{idCliente}/sucursal/{idSucursal}")
    public void realizarTransaccion(
        @PathVariable("idCliente")long idCliente,
        @PathVariable("idSucursal")long idSucursal ){
        this.transaccionService.crearTransaccion(idCliente, idSucursal);
    }
    
}
