package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente getClienteById(Long id);
    Cliente findClienteByCpfCnpj(String cpfCnpj);
}

