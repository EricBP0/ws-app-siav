package com.example.wsappsiav.Service;


import com.example.wsappsiav.Entity.Adicional;
import com.example.wsappsiav.Repository.AdicionaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdicionalService {

    @Autowired
    private AdicionaisRepository adicionaisRepository;

    public List<Adicional> listarTodosAdicionais(){return adicionaisRepository.findAll();}

    public Optional<Adicional> getAdicionalById(Long id){return adicionaisRepository.findById(id);}

    public Adicional save(Adicional adicional){return adicionaisRepository.save(adicional);}
}
