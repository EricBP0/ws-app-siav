package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findClienteByCpfCnpj(String cpfCnpj);
}

