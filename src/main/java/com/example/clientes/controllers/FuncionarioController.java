package com.example.clientes.controllers;

import com.example.clientes.entities.Funcionario;
import com.example.clientes.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("buscarTodosFuncionarios")
    public List<Funcionario> buscarFuncionarios(){
        return funcionarioService.buscarFuncionarios();
    }

    @PostMapping("efetuarLogin")
    public ResponseEntity<String> efetuarLogin(@RequestBody Funcionario funcionario) throws Exception{
        return  ResponseEntity.ok(funcionarioService.validarLogin(funcionario));
    }

}
