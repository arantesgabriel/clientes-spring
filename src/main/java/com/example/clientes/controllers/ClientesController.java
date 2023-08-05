package com.example.clientes.controllers;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.entities.Cliente;
import com.example.clientes.exceptions.CodigoNuloException;
import com.example.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> buscarClientes() {
        return clienteService.buscarTodosClientes();
    }

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody ClienteRequestDTO clienteDTO) {
        clienteService.cadastrarCliente(clienteDTO);
    }

    @PostMapping("/editar")
    public ResponseEntity<String> editarCliente(@RequestBody Cliente cliente) throws CodigoNuloException {
        clienteService.editarCliente(cliente);
        return ResponseEntity.ok("Cliente atualizado com sucesso!");
    }

    @DeleteMapping("/deletarConta/{codigo}")
    public void deletarConta(@PathVariable Long codigo) {
        clienteService.deletarConta(codigo);
    }

}
