package com.example.clientes.services;

import com.example.clientes.entities.Funcionario;
import com.example.clientes.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> buscarFuncionarios() {
        List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();
        return listaFuncionarios;
    }

    public String validarLogin(Funcionario funcionario) throws Exception {

        String usuario = funcionario.getUsuario();
        String senha = funcionario.getSenha();

        boolean credenciaisValidas = funcionarioRepository.existsByUsuarioAndSenha(usuario, senha);

        if (credenciaisValidas) {
            return "Login bem-sucedido!";
        } else {
            throw new Exception("Credenciais inválidas.");
        }
    }

}
