package com.desafiosefaz.bean;

import com.desafiosefaz.model.Usuario;
import com.desafiosefaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@Component
@ViewScoped
@SessionScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    @Autowired
    private UsuarioService usuarioService;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String login(){

        Usuario usuario = usuarioService.login(getUsuario().getEmail(),getUsuario().getSenha());

        if (usuario == null) {
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            System.err.println(usuario.getTelefones().get(0).getNumero());
            return "/login.jsf";
        }


    }

}
