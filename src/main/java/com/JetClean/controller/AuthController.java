package com.JetClean.controller;

import com.JetClean.dto.UsuarioRequest;
import com.JetClean.dto.UsuarioResponse;
import com.JetClean.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jetclean/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> saveUsuario(@RequestBody @Valid UsuarioRequest request){
       UsuarioResponse saveUsuario = usuarioService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUsuario);
    }
}
