package com.example.wsappsiav.Controller;

import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/grupo")
public class GruposController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/{type}")
    public ResponseEntity<List<Grupo>> listarGruposPorType(@PathVariable String type){
        List<Grupo> grupos = grupoService.listarGruposPeloTipo(type);
        return ResponseEntity.ok(grupos);
    }
}
