package com.desafiosefaz.service;

import com.desafiosefaz.model.Usuario;
import com.desafiosefaz.repository.TelefoneRepository;
import com.desafiosefaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;

    public Usuario login (String email, String senha){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSenha(email,senha);
        if(usuario.isPresent()){
            return usuario.get();
        }
        return null;

    }
    public Usuario cadastrar (Usuario usuario){
        if(existeUsuario(usuario.getEmail())){
            return null;
        }
        Usuario u = usuarioRepository.save(usuario);
        u.getTelefones().forEach(telefone -> telefone.setUsuario(u));
        telefoneRepository.saveAll(u.getTelefones());
        return u;
    }

    public Usuario atualizar (Usuario usuario){

        Usuario u = usuarioRepository.save(usuario);
        telefoneRepository.saveAll(usuario.getTelefones());

        Optional<Usuario> user = usuarioRepository.findById(usuario.getId());
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public List<Usuario> getTodosUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return  usuarios;
    }

    public Usuario getUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            return  usuario.get();
        }
        return null;

    }
    public Boolean existeUsuario(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.isPresent();


    }

    public void deletar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
