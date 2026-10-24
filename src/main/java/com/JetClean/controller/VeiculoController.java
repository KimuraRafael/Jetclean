package com.JetClean.controller;

import com.JetClean.dto.VeiculoRequest;
import com.JetClean.dto.VeiculoResponse;
import com.JetClean.entity.Veiculo;
import com.JetClean.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jetclean")
@RequiredArgsConstructor
public class VeiculoController {


    private final VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @GetMapping("/veiculos/{id}")
    public Veiculo getVeiculoByID(@PathVariable UUID id) {
        return veiculoService.findById(id);
    }

    @PostMapping("/veiculos/cadastro")
    public ResponseEntity<VeiculoResponse> saveVeiculo(@RequestBody @Valid VeiculoRequest novoVeiculo) {
        VeiculoResponse salvo = veiculoService.saveVeiculo(novoVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/veiculos/{id}")
    public VeiculoResponse editVeiculo(@PathVariable UUID id, @RequestBody @Valid VeiculoRequest veiculoAtualizado){return veiculoService.editVeiculo(id, veiculoAtualizado);}

    @DeleteMapping(("/veiculos/{id}"))
    public ResponseEntity<Void>deleteVeiculoById(@PathVariable UUID id){
        veiculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
