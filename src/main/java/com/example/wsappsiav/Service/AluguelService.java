package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Aluguel> listarAluguelPorCliente(Cliente cliente){return aluguelRepository.getAluguelsByClienteId(cliente);}

    public Optional<Aluguel> getAluguelById(Long id){return aluguelRepository.findById(id);}

    public Aluguel save(Aluguel aluguel){return aluguelRepository.save(aluguel);}
}
