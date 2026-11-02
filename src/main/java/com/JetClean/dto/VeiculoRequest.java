package com.JetClean.dto;

import com.JetClean.enums.TipoVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VeiculoRequest(
        @NotNull(message = "Tipo do veículo obrigatório") TipoVeiculo tipoVeiculo,
        @NotBlank(message = "Cor obrigatória") @Size(max = 50) String cor,
        @NotBlank(message = "Placa obrigatória") @Size(max = 10) String placa,
        @NotBlank (message = "Modelo obrigatório") @Size(max = 100) String modelo
) {
}
