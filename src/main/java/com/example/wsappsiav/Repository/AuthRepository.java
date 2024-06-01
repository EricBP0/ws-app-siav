package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Auth;
import com.example.wsappsiav.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    @Query(value = "SELECT a.clienteId  FROM Auth a WHERE a.login = :login AND a.senha = :senha")
    Optional<Cliente> getClienteIdByLoginAndSenha(String login, String senha);

}
