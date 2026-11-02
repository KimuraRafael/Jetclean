package com.JetClean.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String senha
) {
}
