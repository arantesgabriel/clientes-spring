package com.example.clientes.DTO;

import com.example.clientes.entities.Cliente;

public record ClienteResponseDTO(Long codcli, String nome, String email, String senha) {

    public ClienteResponseDTO(Cliente cliente) {
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getSenha());
    }

}
