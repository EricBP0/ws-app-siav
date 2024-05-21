package com.example.wsappsiav.Controller;

import com.example.wsappsiav.DTO.ClienteDTO;
import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Service.ClienteService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/get-user-by-cpfcnpj/{cpfcnpj}")
    public ResponseEntity<ClienteDTO> buscarClientePorCpfCnpj(@PathVariable String cpfcnpj) {
        try{
            ClienteDTO clienteDTO = new ClienteDTO();
            Cliente cliente =  clienteService.buscarClientePorCpfCnpj(cpfcnpj);
            if(cliente != null){
                clienteDTO.nome = cliente.getClienteNome();
                clienteDTO.cpfCnpj = cliente.getCpfCnpj();
                clienteDTO.email = cliente.getEmail();
                clienteDTO.endereco = cliente.getEndereco();
                clienteDTO.telefone = cliente.getTelefone();
                return ResponseEntity.ok(clienteDTO);
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
            Cliente novoCliente = clienteService.salvarCliente(cliente);
        try {
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(novoCliente, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
