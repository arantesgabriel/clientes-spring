package com.example.clientes.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TFUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codfunc")
    private Long codigo;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "senha")
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
