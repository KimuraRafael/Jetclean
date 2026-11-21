package com.JetClean.config;

import com.JetClean.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenComponent {

    @Value("${jetclean.security.secret}")
    private String secret;



    public String generateToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(usuario.getEmail())
                .withClaim("IdUsuario", usuario.getId().toString())
                .withClaim("Nome", usuario.getNome())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API JetClean")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData
                    .builder()
                    .id(UUID.fromString(jwt.getClaim("IdUsuario").asString()))
                    .nome(jwt.getClaim("Nome").asString())
                    .email(jwt.getSubject())
                    .build());

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }

    }
}
