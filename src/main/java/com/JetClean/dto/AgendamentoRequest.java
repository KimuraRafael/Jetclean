package com.JetClean.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoRequest(
        @NotNull UUID veiculoId,
        @NotNull UUID lavagemId,
        @NotNull @FutureOrPresent LocalDateTime dataHoraLavagem,
        @Size(max = 500) String observacao
) {
}
