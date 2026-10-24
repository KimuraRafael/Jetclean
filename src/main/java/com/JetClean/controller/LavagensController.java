package com.JetClean.controller;

import com.JetClean.dto.LavagemRequest;
import com.JetClean.dto.LavagemResponse;
import com.JetClean.entity.Lavagens;
import com.JetClean.service.LavagensService;
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
public class LavagensController {

    private final LavagensService lavagensService;

    @GetMapping("/lavagens")
    public List<Lavagens> getAllLavagens(){
        return lavagensService.findAll();
    }

    @GetMapping("/lavagens/{id}")
    public Lavagens getLavagemById(@PathVariable UUID id){
        return lavagensService.findById(id);
    }

    @PostMapping("/lavagens/cadastro")
    public ResponseEntity<LavagemResponse> saveLavagem(@RequestBody @Valid LavagemRequest novaLavagem){
        LavagemResponse salvo = lavagensService.saveLavagem(novaLavagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/lavagens/{id}")
    public LavagemResponse editLavagem(@PathVariable UUID id, @RequestBody @Valid LavagemRequest lavagemAtualizada) { return lavagensService.editLavagem(id, lavagemAtualizada); }

    @DeleteMapping("/lavagens/{id}")
    public ResponseEntity<Void> deleteLavagemById(@PathVariable UUID id){
        lavagensService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
