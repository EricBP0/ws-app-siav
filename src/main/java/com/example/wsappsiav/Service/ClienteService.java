package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClientById(Long id){return clienteRepository.getClienteById(id);}

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarClientePorCpfCnpj(String cpfCnpj){return clienteRepository.findClienteByCpfCnpj(cpfCnpj);};
}

