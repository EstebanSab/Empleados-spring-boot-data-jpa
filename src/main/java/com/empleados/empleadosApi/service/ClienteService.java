package com.empleados.empleadosApi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.empleadosApi.repository.ClienteRepository;
import com.empleados.empleadosApi.model.Cliente;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes(){
        return this.clienteRepository.findAll();
    }

    public void guardarCliente(Cliente cliente){
        this.clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long idCliente) {
        return this.clienteRepository.findById(idCliente).get();
    }

    public void guardarCambiosCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

}
