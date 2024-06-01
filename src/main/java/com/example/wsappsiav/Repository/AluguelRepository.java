package com.example.wsappsiav.Repository;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.AluguelAdicionais;
import com.example.wsappsiav.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> getAluguelsByClienteId(Cliente cliente);

}

