package com.example.wsappsiav.Controller;

import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Entity.Veiculo;
import com.example.wsappsiav.Service.VeiculoService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculoService veiculoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(VeiculosController.class);

    @GetMapping("/{type}")
    public ResponseEntity<List<Veiculo>> listarVeiculosPorGrupo(@PathVariable String type){
        List<Veiculo> veiculos = veiculoService.listarTodosVeiculosPorGrupo(type);
        return ResponseEntity.ok(veiculos);
    }
    @GetMapping()
    public ResponseEntity<List<Veiculo>> listarTodosVeiculos(){
        List<Veiculo> veiculos = veiculoService.listarTodosVeiculos();
        return ResponseEntity.ok(veiculos);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Optional<Veiculo>> listarVeiculosById(@PathVariable Long id){
        Optional<Veiculo> veiculo = veiculoService.getVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }
}
