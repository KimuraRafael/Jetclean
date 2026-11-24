package com.JetClean.controller;

import com.JetClean.dto.LavagemRequest;
import com.JetClean.dto.LavagemResponse;
import com.JetClean.entity.Lavagens;
import com.JetClean.service.LavagensService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Lavagens", description = "Cadastro e gestão de lavagens")
@RestController
@RequestMapping("/jetclean")
@RequiredArgsConstructor
public class LavagensController {

    private final LavagensService lavagensService;

    @Operation(summary = "Listagem de lavagens", description = "Método Responsável por buscar todas as lavagens")
    @GetMapping("/lavagens")
    public List<Lavagens> getAllLavagens(){
        return lavagensService.findAll();
    }

    @Operation(summary = "Busca por lavagem", description = "Método responsável por buscar uma lavagem em específico")
    @GetMapping("/lavagens/{id}")
    public Lavagens getLavagemById(@PathVariable UUID id){
        return lavagensService.findById(id);
    }

    @Operation(summary = "Salvar lavagem", description = "Método responsável por salvar uma lavagem")
    @PostMapping("/lavagens/cadastro")
    public ResponseEntity<LavagemResponse> saveLavagem(@RequestBody @Valid LavagemRequest novaLavagem){
        LavagemResponse salvo = lavagensService.saveLavagem(novaLavagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @Operation(summary = "Atualizar lavagem", description = "Método responsável por atualizar uma lavagem")
    @PutMapping("/lavagens/{id}")
    public LavagemResponse editLavagem(@PathVariable UUID id, @RequestBody @Valid LavagemRequest lavagemAtualizada) { return lavagensService.editLavagem(id, lavagemAtualizada); }

    @Operation(summary = "Deletar lavagem", description = "Método responsável por excluir uma lavagem")
    @DeleteMapping("/lavagens/{id}")
    public ResponseEntity<Void> deleteLavagemById(@PathVariable UUID id){
        lavagensService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
