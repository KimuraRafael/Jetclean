package com.JetClean.dto;

import com.JetClean.entity.AgendamentoLavagens;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoResponse(
        UUID id,
        LocalDateTime dataHoraLavagem,
        String observacao,
        VeiculoResponse veiculo,
        LavagemResponse lavagem
) {
    public static AgendamentoResponse from(AgendamentoLavagens agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getDataHoraLavagem(),
                agendamento.getObservacao(),
                VeiculoResponse.from(agendamento.getVeiculo()),
                LavagemResponse.from(agendamento.getLavagem())
        );
    }
}
