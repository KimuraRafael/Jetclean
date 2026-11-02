package com.JetClean.dto;

import com.JetClean.entity.Usuario;
import com.JetClean.entity.Veiculo;

import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String nome,
        String email
) {
    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()

        );
    }
}
