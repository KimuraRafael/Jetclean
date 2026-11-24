package com.JetClean.controller;

import com.JetClean.dto.VeiculoRequest;
import com.JetClean.dto.VeiculoResponse;
import com.JetClean.entity.Veiculo;
import com.JetClean.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Veículos", description = "Cadastro e gestão de veículos")
@RestController
@RequestMapping("/jetclean")
@RequiredArgsConstructor
public class VeiculoController {


    private final VeiculoService veiculoService;

    @Operation(summary = "Listagem de veículos", description = "Método responsável por buscar todos os veículos")
    @GetMapping("/veiculos")
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @Operation(summary = "Busca por veículo", description = "Método responsável por buscar um veículo em específico")
    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Veiculo> getVeiculoByID(@PathVariable UUID id) {
        return  ResponseEntity.ok(veiculoService.findById(id));
    }

    @Operation(summary = "Salvar veículo", description = "Método responsável por salvar um veículo")
    @PostMapping("/veiculos/cadastro")
    public ResponseEntity<VeiculoResponse> saveVeiculo(@RequestBody @Valid VeiculoRequest novoVeiculo) {
        VeiculoResponse salvo = veiculoService.saveVeiculo(novoVeiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @Operation(summary = "Atualizar veículo", description = "Método responsável por atualizar um veículo")
    @PutMapping("/veiculos/{id}")
    public ResponseEntity<VeiculoResponse> editVeiculo(@PathVariable UUID id, @RequestBody @Valid VeiculoRequest veiculoAtualizado){return ResponseEntity.ok(veiculoService.editVeiculo(id, veiculoAtualizado));}

    @Operation(summary = "Deletar veículo", description = "Método responsável por excluir um veículo")
    @DeleteMapping(("/veiculos/{id}"))
    public ResponseEntity<Void>deleteVeiculoById(@PathVariable UUID id){
        veiculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
