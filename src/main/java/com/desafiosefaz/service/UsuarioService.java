package com.desafiosefaz.service;

import com.desafiosefaz.model.Usuario;
import com.desafiosefaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login (String email, String senha){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSenha(email,senha);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return null;
        }

    }
}
