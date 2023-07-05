package com.example.clientes.controller;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.DTO.ClienteResponseDTO;
import com.example.clientes.domain.Cliente;
import com.example.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Stream<ClienteResponseDTO> buscarClientes() {
        Stream<ClienteResponseDTO> clientes = clienteRepository.findAll().stream().map(ClienteResponseDTO::new);
        return clientes;
    }

    @PostMapping
    public void cadastrarCliente(@RequestBody ClienteRequestDTO novoCliente){
        Cliente cliente = new Cliente(novoCliente);
        clienteRepository.save(novoCliente);
    }

}
