package com.desafiosefaz.controller;

import com.desafiosefaz.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.Collection;

@Controller
@ViewScoped
public class UsuarioController {

    @GetMapping
    public String index(){
       // System.err.println("AQUI");
        return "/login.jsf";
    }

   public String getLogin(String login, String senha){

       FacesContext.getCurrentInstance().addMessage(
               null,
               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                       "Erro no Login!"));

        return "/hello.jsf";
    }

    public Collection<Usuario> getAllUsers(){
        Usuario user  = new Usuario();
        user.setEmail("Rodolfo");
        user.setSenha("122344");

        Usuario user2 = new Usuario();
        user2.setEmail("Julio");
        user2.setSenha("213123");

        return Arrays.asList(user,user2);
    }
}
