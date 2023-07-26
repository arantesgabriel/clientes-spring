package com.example.clientes.repositories;

import com.example.clientes.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {

    boolean existsByUsuarioAndSenha(String usuario, String senha) throws Exception;

}
