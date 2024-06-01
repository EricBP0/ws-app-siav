package com.example.wsappsiav.Controller;


import com.example.wsappsiav.Entity.Adicional;
import com.example.wsappsiav.Entity.Grupo;
import com.example.wsappsiav.Entity.Seguro;
import com.example.wsappsiav.Entity.Veiculo;
import com.example.wsappsiav.Service.AdicionalService;
import com.example.wsappsiav.Service.GrupoService;
import com.example.wsappsiav.Service.SeguroService;
import com.example.wsappsiav.Service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bo")
public class BackoficeController {

    @Autowired
    private GrupoService grupoService;
    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private AdicionalService adicionalService;
    @Autowired
    private SeguroService seguroService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/grupo")
    public ResponseEntity<Grupo> criarGrupo(@RequestBody Grupo grupo){
        return new ResponseEntity<>(grupoService.save(grupo), HttpStatus.CREATED);
    }
    @PostMapping("/veiculo")
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo){
        return new ResponseEntity<>(veiculoService.save(veiculo), HttpStatus.CREATED);
    }
    @PostMapping("/adicional")
    public ResponseEntity<Adicional> criarAdicional(@RequestBody Adicional adicional){
        return new ResponseEntity<>(adicionalService.save(adicional), HttpStatus.CREATED);
    }
    @PostMapping("/seguro")
    public ResponseEntity<Seguro> criarSeguro(@RequestBody Seguro seguro){
        return new ResponseEntity<>(seguroService.save(seguro), HttpStatus.CREATED);
    }
}
