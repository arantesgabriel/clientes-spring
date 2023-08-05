package com.example.clientes.services;

import com.example.clientes.DTO.ClienteRequestDTO;
import com.example.clientes.DTO.ClienteResponseDTO;
import com.example.clientes.entities.Cliente;
import com.example.clientes.exceptions.CodigoNuloException;
import com.example.clientes.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void editarCliente(Cliente cliente) throws CodigoNuloException {

        Long codigo = cliente.getCodigo();

        if (codigo == null) {
            throw new CodigoNuloException("O ID não pode ser nulo.");
        } else {
            Cliente novoCliente = clienteRepository.findById(cliente.getCodigo())
                    .orElseThrow(() -> new RuntimeException("Conta não encontrada com o código informado."));
            novoCliente.setCodigo(cliente.getCodigo());
            novoCliente.setNome(cliente.getNome());
            novoCliente.setEmail(cliente.getEmail());
            novoCliente.setSenha(cliente.getSenha());
            clienteRepository.save(novoCliente);
        }
    }

    public void deletarConta(Long codigo) {
        clienteRepository.deleteById(codigo);
    }

}
