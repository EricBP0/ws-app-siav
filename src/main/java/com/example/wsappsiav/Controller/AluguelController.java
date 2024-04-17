package com.example.wsappsiav.Controller;

import com.example.wsappsiav.Entity.Aluguel;
import com.example.wsappsiav.Service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        List<Aluguel> alugueis = aluguelService.listarTodosAlugueis();
        return new ResponseEntity<>(alugueis, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscarAluguelPorId(@PathVariable Long id) {
        return aluguelService.buscarAluguelPorId(id)
                .map(aluguel -> new ResponseEntity<>(aluguel, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Aluguel> criarAluguel(@RequestBody Aluguel aluguel) {
        Aluguel novoAluguel = aluguelService.salvarAluguel(aluguel);
        return new ResponseEntity<>(novoAluguel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluguel(@PathVariable Long id) {
        aluguelService.deletarAluguel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
