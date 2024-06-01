package com.example.wsappsiav.Type;

import com.example.wsappsiav.Entity.Adicional;
import com.example.wsappsiav.Entity.Cliente;
import com.example.wsappsiav.Entity.Seguro;
import com.example.wsappsiav.Entity.Veiculo;

import java.util.Date;
import java.util.List;

public class AluguelDTO {

    public Long id;

    public String nome;

    public Date dataInicio;
    public Date dataFim;

    public Veiculo veiculo;

    public double valor;

    public Cliente cliente;

    public List<Adicional> adicionais;
    public List<Seguro> seguros;


}
