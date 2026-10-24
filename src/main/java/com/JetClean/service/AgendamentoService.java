package com.JetClean.service;

import com.JetClean.dto.AgendamentoRequest;
import com.JetClean.dto.AgendamentoResponse;
import com.JetClean.entity.AgendamentoLavagens;
import com.JetClean.entity.Lavagens;
import com.JetClean.entity.Veiculo;
import com.JetClean.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final LavagensService lavagensService;
    private final VeiculoService veiculoService;

    @Transactional(readOnly = true)
    public List<AgendamentoResponse> getAllAgendamentos(){
        return agendamentoRepository.findAllByOrderByDataHoraLavagemAsc()
                .stream()
                .map(AgendamentoResponse::from)
                .toList();
    }

    public AgendamentoLavagens findById(UUID id) {
        return agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    @Transactional(readOnly = true)
    public AgendamentoResponse getAgendamentoById(UUID id) {
        return AgendamentoResponse.from(findById(id));
    }

    @Transactional
    public AgendamentoResponse saveAgendamento(AgendamentoRequest novoAgendamento){

        Veiculo veiculo = veiculoService.findById(novoAgendamento.veiculoId());
        Lavagens lavagem = lavagensService.findById(novoAgendamento.lavagemId());
        AgendamentoLavagens agendamento = new AgendamentoLavagens();

        agendamento.setVeiculo(veiculo);
        agendamento.setLavagem(lavagem);
        agendamento.setDataHoraLavagem(novoAgendamento.dataHoraLavagem());
        agendamento.setObservacao(novoAgendamento.observacao());

        return AgendamentoResponse.from(agendamentoRepository.save(agendamento));
    }

    @Transactional
    public AgendamentoResponse editAgendamento(AgendamentoRequest agendamentoEditado, UUID idAgendamento){

        AgendamentoLavagens agendamento = findById(idAgendamento);
        Veiculo veiculo = veiculoService.findById(agendamentoEditado.veiculoId());
        Lavagens lavagem = lavagensService.findById(agendamentoEditado.lavagemId());

        agendamento.setVeiculo(veiculo);
        agendamento.setLavagem(lavagem);
        agendamento.setDataHoraLavagem(agendamentoEditado.dataHoraLavagem());
        agendamento.setObservacao(agendamentoEditado.observacao());

        return AgendamentoResponse.from(agendamentoRepository.save(agendamento));
    }

    @Transactional
    public void deleteById(UUID id) {
        AgendamentoLavagens agendamento = findById(id);
        agendamentoRepository.delete(agendamento);
    }
}
