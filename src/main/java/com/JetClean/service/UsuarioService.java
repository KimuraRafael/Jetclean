package com.JetClean.service;

import com.JetClean.dto.UsuarioRequest;
import com.JetClean.dto.UsuarioResponse;
import com.JetClean.entity.Usuario;
import com.JetClean.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse save(UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());
        return UsuarioResponse.from(usuarioRepository.save(usuario));
    }
}
