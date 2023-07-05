package com.example.clientes.DTO;

import com.example.clientes.domain.Cliente;

public record ClienteRequestDTO(String nome, String email, String senha) {

    public ClienteRequestDTO(Cliente cliente){
        this(cliente.getNome(), cliente.getEmail(), cliente.getSenha());
    }

}
