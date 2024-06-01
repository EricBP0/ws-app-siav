package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.AluguelAdicionais;
import com.example.wsappsiav.Entity.AluguelSeguros;
import com.example.wsappsiav.Repository.AluguelAdicionaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelAdicionaisService {
    @Autowired
    private AluguelAdicionaisRepository aluguelAdicionaisRepository;

    public List<AluguelAdicionais> listarTodosAluguelAdicionaisByAluguel(Aluguel aluguel){return aluguelAdicionaisRepository.getAluguelSegurosRepositoriesByAluguelId(aluguel);}

    public AluguelAdicionais save(AluguelAdicionais aluguelAdicionais){return aluguelAdicionaisRepository.save(aluguelAdicionais);}
}
