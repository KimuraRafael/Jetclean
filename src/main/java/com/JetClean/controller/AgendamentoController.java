package com.JetClean.controller;

import com.JetClean.dto.AgendamentoRequest;
import com.JetClean.dto.AgendamentoResponse;
import com.JetClean.entity.AgendamentoLavagens;
import com.JetClean.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Agendamentos", description = "Cadastro e gestão das agendamentos de lavagens")
@RestController
@RequestMapping("/jetclean")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @Operation(summary = "Listagem de Agendamentos", description = "Método responsável por buscar todos os agendamentos")
    @GetMapping("/agendamentos")
    public List<AgendamentoResponse> getAllAgendamentos(){
        return agendamentoService.getAllAgendamentos();
    }

    @Operation(summary = "Busca por Agendamento", description = "Método responsável por buscar um agendamento em específico")
    @GetMapping("/agendamentos/{id}")
    public AgendamentoResponse getAgendamentoById(@PathVariable UUID id) {
        return agendamentoService.getAgendamentoById(id);
    }

    @Operation(summary = "Salvar Agendamento", description = "Método responsável por salvar um agendamento da lavagem de um veículo")
    @PostMapping("/agendamentos/cadastro")
    public ResponseEntity<AgendamentoResponse>saveAgendamento(@RequestBody @Valid AgendamentoRequest novoAgendamento){
        AgendamentoResponse salvo = agendamentoService.saveAgendamento(novoAgendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @Operation(summary = "Atualizar Agendamento", description = "Método responsável por atualizar um agendamento da lavagem de um veículo")
    @PutMapping("/agendamentos/{id}")
    public AgendamentoResponse editAgendamento(@RequestBody @Valid AgendamentoRequest atualizadoAgendamento, @PathVariable UUID id){ return agendamentoService.editAgendamento(atualizadoAgendamento, id); }

    @Operation(summary = "Deletar Agendamento", description = "Método responsável por excluir um agendamento da lavagem de um veículo")
    @DeleteMapping("/agendamentos/{id}")
    public ResponseEntity<Void> deleteAgendamentoById(@PathVariable UUID id) {
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
