package com.example.clientes.controller;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.DTO.ClienteResponseDTO;
import com.example.clientes.domain.Cliente;
import com.example.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/buscar")
    public Stream<ClienteResponseDTO> buscarClientes() {
        Stream<ClienteResponseDTO> clientes = clienteRepository.findAll().stream().map(ClienteResponseDTO::new);
        return clientes;
    }

    @PostMapping("/cadastrar")
    public void cadastrarCliente (@RequestBody ClienteRequestDTO cliente){
        Cliente novocliente = new Cliente(cliente);
        clienteRepository.save(novocliente);
        return;
    }

    @DeleteMapping("/deletarConta/{codigo}")
    public void deletarConta(@PathVariable Long codigo){
        clienteRepository.deleteById(codigo);
    }

}
