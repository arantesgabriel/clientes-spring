package com.example.clientes.controllers;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.DTO.ClienteResponseDTO;
import com.example.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<ClienteResponseDTO> buscarClientes() {
        return clienteService.buscarClientes();
    }

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody ClienteRequestDTO clienteDTO) {
        clienteService.cadastrarCliente(clienteDTO);
    }

    @DeleteMapping("/deletarConta/{codigo}")
    public void deletarConta(@PathVariable Long codigo) {
        clienteService.deletarConta(codigo);
    }

}
