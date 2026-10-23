package com.JetClean.controller;

import com.JetClean.entity.Veiculo;
import com.JetClean.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Veiculo getVeiculoByID(@PathVariable UUID idVeiculo) {
        return veiculoService.findById(idVeiculo);
    }

    @PostMapping()
    public Veiculo saveVeiculos(Veiculo veiculo) {
        return veiculoService.saveVeiculo(veiculo);
    }

}
