package com.JetClean.controller;

import com.JetClean.entity.Veiculo;
import com.JetClean.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jetclean/veiculos")
@RequiredArgsConstructor
public class VeiculoController {


    private VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

}
