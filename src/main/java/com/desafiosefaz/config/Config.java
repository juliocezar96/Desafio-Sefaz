package com.desafiosefaz.config;

import com.desafiosefaz.model.Telefone;
import com.desafiosefaz.model.Usuario;
import com.desafiosefaz.repository.TelefoneRepository;
import com.desafiosefaz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setSenha("123");
        usuario.setEmail("julio@hotmail.com");
        usuario.setNome("julio");

        Telefone telefone = new Telefone();
        telefone.setDdd(81);
        telefone.setNumero("992014818");
        telefone.setTipo("Celular");
        telefone.setUsuario(usuario);

        Telefone telefone1 = new Telefone();
        telefone1.setDdd(81);
        telefone1.setNumero("992014819");
        telefone1.setTipo("Celular");
        telefone1.setUsuario(usuario);

        usuarioRepository.save(usuario);
        telefoneRepository.saveAll(Arrays.asList(telefone,telefone1));
    }
}
