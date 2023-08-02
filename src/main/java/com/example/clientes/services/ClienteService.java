package com.example.clientes.services;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.DTO.ClienteResponseDTO;
import com.example.clientes.entities.Cliente;
import com.example.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarTodosClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes; 
    }

    public void cadastrarCliente(ClienteRequestDTO clienteDTO) {
        Cliente novocliente = new Cliente(clienteDTO);
        clienteRepository.save(novocliente);
    }

    public void deletarConta(Long codigo) {
        clienteRepository.deleteById(codigo);
    }

}
