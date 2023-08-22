package com.example.clientes.controllers;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.entities.Cliente;
import com.example.clientes.exceptions.CodigoNuloException;
import com.example.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<HashMap<String, String>> editarCliente(@RequestBody Cliente cliente) throws CodigoNuloException {
        clienteService.editarCliente(cliente);
        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Cliente atualizado com sucesso!");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @DeleteMapping("/deletarConta/{codigo}")
    public void deletarConta(@PathVariable Long codigo) {
        clienteService.deletarConta(codigo);
    }

}
