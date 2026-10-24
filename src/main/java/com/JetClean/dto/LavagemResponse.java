package com.JetClean.dto;

import com.JetClean.entity.Lavagens;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record LavagemResponse(
        UUID id,
        String descricao,
        BigDecimal preco,
        LocalDateTime dataUltimaEdicao
) {
    public static LavagemResponse from(Lavagens lavagem) {
        return new LavagemResponse(
                lavagem.getId(),
                lavagem.getDescricao(),
                lavagem.getPreco(),
                lavagem.getDataUltimaEdicao()
        );
    }
}
