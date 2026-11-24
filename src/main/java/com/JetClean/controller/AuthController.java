package com.JetClean.controller;

import com.JetClean.config.TokenComponent;
import com.JetClean.dto.LoginRequest;
import com.JetClean.dto.LoginResponse;
import com.JetClean.dto.UsuarioRequest;
import com.JetClean.dto.UsuarioResponse;
import com.JetClean.entity.Usuario;
import com.JetClean.exception.UsernameOrPasswordInvalidException;
import com.JetClean.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autenticação", description = "Cadastro e Login para autenticação no sistema")
@RestController
@RequestMapping("/jetclean/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenComponent tokenComponent;
    private final AuthenticationManager authenticationManager;

    @Operation(summary = "Cadastro de login", description = "Método responsável por cadastrar um novo usuário no sistema")
    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> saveUsuario(@RequestBody @Valid UsuarioRequest request) {
        UsuarioResponse saveUsuario = usuarioService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUsuario);
    }

    @Operation(summary = "Login e Autenticação", description = "Método responsável por conferir os dados e realizar o login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> saveUsuario(@RequestBody @Valid LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String token = tokenComponent.generateToken(usuario);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException ex) {
            throw new UsernameOrPasswordInvalidException("E-mail ou senha inválidos");

        }
    }
}
