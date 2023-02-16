package com.empleados.empleadosApi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.model.Cliente;
import com.empleados.empleadosApi.model.Sucursal;

@Service
public class TransaccionService {

    private ClienteService clienteService;
    private SucursalService sucursalService;

    @Autowired
    public TransaccionService(
        ClienteService clienteService,
        SucursalService sucursalService
        ){
        this.clienteService=clienteService;
        this.sucursalService =sucursalService;
    }



    public void crearTransaccion(Long idCliente,Long idSucursal){
        Cliente miCliente =this.clienteService.getClienteById(idCliente);
        Sucursal miSucursal = this.sucursalService.getSucursalById(idSucursal);

        miCliente.addSucursal(miSucursal);
        miSucursal.addCliente(miCliente);

        this.clienteService.guardarCambiosCliente(miCliente);
        this.sucursalService.guardarCambiosSucursal(miSucursal);
    }
}
