package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Transactional(readOnly = true)
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();}
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarClientePorId(Long id) {return clienteRepository.findById(id);}

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Transactional
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Cliente buscarClientePorCpfCnpj(String cpfCnpj){
        return clienteRepository.findClienteByCpfCnpj(cpfCnpj);
    };
}

