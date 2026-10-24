package com.JetClean.dto;

import com.JetClean.enums.TipoVeiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VeiculoRequest(
        @NotNull TipoVeiculo tipoVeiculo,
        @NotBlank @Size(max = 50) String cor,
        @NotBlank @Size(max = 10) String placa,
        @NotBlank @Size(max = 100) String modelo
) {
}
