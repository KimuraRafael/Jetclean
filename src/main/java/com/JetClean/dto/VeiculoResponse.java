package com.JetClean.dto;

import com.JetClean.entity.Veiculo;
import com.JetClean.enums.TipoVeiculo;

import java.util.UUID;

public record VeiculoResponse(
        UUID id,
        TipoVeiculo tipoVeiculo,
        String cor,
        String placa,
        String modelo
) {
    public static VeiculoResponse from(Veiculo veiculo) {
        return new VeiculoResponse(
                veiculo.getId(),
                veiculo.getTipoVeiculo(),
                veiculo.getCor(),
                veiculo.getPlaca(),
                veiculo.getModelo()
        );
    }
}
