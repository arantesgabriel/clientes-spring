package com.example.clientes.repository;

import com.example.clientes.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
}
