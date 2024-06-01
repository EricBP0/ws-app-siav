package com.example.wsappsiav.Controller;

import com.example.wsappsiav.Entity.*;
import com.example.wsappsiav.Service.*;
import com.example.wsappsiav.Type.AdicionaisSeguros;
import com.example.wsappsiav.Type.AluguelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @Autowired
    private AluguelAdicionaisService aluguelAdicionaisService;

    @Autowired
    private AluguelSeguroService aluguelSeguroService;

    @Autowired
    private SeguroService seguroService;

    @Autowired
    private AdicionalService adicionalService;
    
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/adicionais-seguros")
    public ResponseEntity<AdicionaisSeguros> listarAdicionaisSeguros(){
        try{
            AdicionaisSeguros adicionaisSeguros = new AdicionaisSeguros();

            List<Adicional> adicionais = adicionalService.listarTodosAdicionais();
            List<Seguro> seguros = seguroService.listarTodosSeguros();

            adicionaisSeguros.adicionais = adicionais;
            adicionaisSeguros.seguros = seguros;

            return ResponseEntity.ok(adicionaisSeguros);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{cliente_id}")
    public ResponseEntity<List<AluguelDTO>> buscarTodosAlugueisPorCliente(@PathVariable Long cliente_id){
        List<AluguelDTO> aluguelDTOS = new ArrayList<>();
        Cliente cliente = clienteService.getClientById(cliente_id);
        List<Aluguel> aluguelList = aluguelService.listarAluguelPorCliente(cliente);
        for(Aluguel aluguel : aluguelList){
            AluguelDTO aluguelDTO = new AluguelDTO();
            List<AluguelSeguros> aluguelSeguros;
            List<AluguelAdicionais> aluguelAdicionais;
            aluguelSeguros = aluguelSeguroService.listarAluguelSegurosByAluguel(aluguel);
            aluguelAdicionais = aluguelAdicionaisService.listarTodosAluguelAdicionaisByAluguel(aluguel);
            List<Seguro> seguros = new ArrayList<>();
            List<Adicional> adicionals = new ArrayList<>();
            for(AluguelSeguros aluguelSeguros1 : aluguelSeguros){
                seguros.add(aluguelSeguros1.getSeguroId());
            }
            for(AluguelAdicionais aluguelAdicionais1 : aluguelAdicionais){
                adicionals.add(aluguelAdicionais1.getAdicionalId());
            }
            if (aluguel.getNome() == null){
                aluguel.setNome(aluguel.getVeiculoId().getMarca());
            }
            aluguelDTO.seguros = seguros;
            aluguelDTO.adicionais = adicionals;
            aluguelDTO.cliente = cliente;
            aluguelDTO.nome = aluguel.getNome();
            aluguelDTO.dataFim = aluguel.getDataFim();
            aluguelDTO.dataInicio = aluguel.getDataInicio();
            aluguelDTO.valor = aluguel.getValor();
            aluguelDTO.veiculo = aluguel.getVeiculoId();
            aluguelDTO.id = aluguel.getId();

            aluguelDTOS.add(aluguelDTO);
        }
        return ResponseEntity.ok(aluguelDTOS);
    }


    @PostMapping("/new")
    public ResponseEntity<Void> registrarNovoAluguel(@RequestBody AluguelDTO aluguelDTO){
        Aluguel aluguel = new Aluguel();
        List<Adicional> adicionais = new ArrayList<>();
        List<Seguro> seguros = new ArrayList<>();
        if(aluguelDTO == null){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!aluguelDTO.adicionais.isEmpty()){
            adicionais = aluguelDTO.adicionais;
        }
        if(!aluguelDTO.seguros.isEmpty()){
            seguros = aluguelDTO.seguros;
        }
        aluguel.setNome(aluguelDTO.nome);
        aluguel.setValor(aluguelDTO.valor);
        aluguel.setVeiculoId(aluguelDTO.veiculo);
        aluguel.setClienteId(aluguelDTO.cliente);
        aluguel.setDataInicio(aluguelDTO.dataInicio);
        aluguel.setDataFim(aluguelDTO.dataFim);
        aluguelService.save(aluguel);

        for(Seguro seguro : seguros){
            AluguelSeguros aluguelSeguros = new AluguelSeguros();
            aluguelSeguros.setAluguelId(aluguel);
            aluguelSeguros.setSeguroId(seguro);
            aluguelSeguroService.save(aluguelSeguros);
        }
        for(Adicional adicional : adicionais){
            AluguelAdicionais aluguelAdicionais = new AluguelAdicionais();
            aluguelAdicionais.setAluguelId(aluguel);
            aluguelAdicionais.setAdicionalId(adicional);
            aluguelAdicionaisService.save(aluguelAdicionais);
        }


        return new ResponseEntity<>(HttpStatus.CREATED);
    };
}
