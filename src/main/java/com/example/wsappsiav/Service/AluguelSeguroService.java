package com.example.wsappsiav.Service;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Entity.AluguelAdicionais;
import com.example.wsappsiav.Entity.AluguelSeguros;
import com.example.wsappsiav.Repository.AluguelSegurosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelSeguroService {

    @Autowired
    private AluguelSegurosRepository aluguelSegurosRepository;

    public List<AluguelSeguros> listarAluguelSegurosByAluguel(Aluguel aluguel){return aluguelSegurosRepository.getAluguelSegurosRepositoriesByAluguelId(aluguel);}

    public AluguelSeguros save(AluguelSeguros aluguelSeguros){return aluguelSegurosRepository.save(aluguelSeguros);}


}
