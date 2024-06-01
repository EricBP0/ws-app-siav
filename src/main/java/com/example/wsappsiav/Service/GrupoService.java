package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> listarTodosGrupos(){return grupoRepository.findAll();}

    public List<Grupo> listarGruposPeloTipo(String type){return grupoRepository.getGruposByType(type);}

    public Optional<Grupo> getGrupoById(Long id){return grupoRepository.findById(id);}

    public Grupo save(Grupo grupo){return grupoRepository.save(grupo);}
}
