package com.JetClean.config;

import lombok.Builder;

import java.util.UUID;

@Builder
public record JWTUserData(UUID id, String nome, String email) {

}
