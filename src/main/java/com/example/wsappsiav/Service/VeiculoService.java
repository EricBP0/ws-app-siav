package com.example.wsappsiav.Service;


import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Entity.Veiculo;
import com.example.wsappsiav.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodosVeiculos(){return veiculoRepository.findAll();}

    public List<Veiculo> listarTodosVeiculosPorGrupo(String grupo){return veiculoRepository.getVeiculosByGrupoId(grupo);}

    public Optional<Veiculo> getVeiculoById(Long id){return veiculoRepository.findById(id);}

    public Veiculo save(Veiculo veiculo){return veiculoRepository.save(veiculo);}

}
