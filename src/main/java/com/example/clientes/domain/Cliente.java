package com.example.clientes.domain;

import com.example.clientes.DTO.ClienteRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tcliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcli")
    private Long codigo;

    @Column(name = "nomcli")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Cliente(ClienteRequestDTO novoCliente) {
        this.nome = novoCliente.nome();
        this.email = novoCliente.email();
        this.senha = novoCliente.senha();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
