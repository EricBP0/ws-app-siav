package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Seguro;
import com.example.wsappsiav.Repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroService {
    @Autowired
    private SeguroRepository seguroRepository;

    public List<Seguro> listarTodosSeguros(){return seguroRepository.findAll();}

    public Optional<Seguro> getById(Long id){return  seguroRepository.findById(id);}

    public Seguro save(Seguro seguro){return seguroRepository.save(seguro);}
}
