package com.JetClean.controller;

import com.JetClean.dto.AgendamentoRequest;
import com.JetClean.dto.AgendamentoResponse;
import com.JetClean.entity.AgendamentoLavagens;
import com.JetClean.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jetclean")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping("/agendamentos")
    public List<AgendamentoResponse> getAllAgendamentos(){
        return agendamentoService.getAllAgendamentos();
    }

    @GetMapping("/agendamentos/{id}")
    public AgendamentoResponse getAgendamentoById(@PathVariable UUID id) {
        return agendamentoService.getAgendamentoById(id);
    }

    @PostMapping("/agendamentos/cadastro")
    public ResponseEntity<AgendamentoResponse>saveAgendamento(@RequestBody @Valid AgendamentoRequest novoAgendamento){
        AgendamentoResponse salvo = agendamentoService.saveAgendamento(novoAgendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/agendamentos/{id}")
    public AgendamentoResponse editAgendamento(@RequestBody @Valid AgendamentoRequest atualizadoAgendamento, @PathVariable UUID id){ return agendamentoService.editAgendamento(atualizadoAgendamento, id); }

    @DeleteMapping("/agendamentos/{id}")
    public ResponseEntity<Void> deleteAgendamentoById(@PathVariable UUID id) {
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
