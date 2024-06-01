package com.example.wsappsiav.Controller;

import com.example.wsappsiav.Entity.Auth;
import com.example.wsappsiav.Service.AuthService;
import com.example.wsappsiav.Service.ClienteService;

import com.example.wsappsiav.Type.Login;
import com.example.wsappsiav.Type.Registro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.wsappsiav.Entity.Cliente;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private ClienteService clienteService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    public ResponseEntity<Void> registrar(@RequestBody Registro registro){
        Cliente cliente = new Cliente();
        cliente.setClienteNome(registro.nome);
        cliente.setCpfCnpj(registro.documento);
        cliente.setEndereco(registro.endereco);
        cliente.setEmail(registro.email);
        cliente.setTelefone(registro.telefone);
        clienteService.salvarCliente(cliente);

        Auth auth = new Auth();
        auth.setLogin(registro.login);
        auth.setSenha(registro.senha);
        auth.setClienteId(cliente);

        authService.salvarAuth(auth);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<Cliente>> getLogin(@RequestBody Login login) {
        return new ResponseEntity<>(authService.login(login.login, login.senha) ,HttpStatus.OK);
    }
}
