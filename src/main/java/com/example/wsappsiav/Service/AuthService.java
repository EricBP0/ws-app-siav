package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Auth;
import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public Auth salvarAuth(Auth auth) {
        return authRepository.save(auth);
    }

    public Optional<Cliente> login(String login, String senha){
        return authRepository.getClienteIdByLoginAndSenha(login, senha);
    }

    public void deletarAuth(Long id) {
        authRepository.deleteById(id);
    }
}
