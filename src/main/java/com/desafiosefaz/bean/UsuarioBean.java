package com.desafiosefaz.bean;

import com.desafiosefaz.model.Telefone;
import com.desafiosefaz.model.Usuario;
import com.desafiosefaz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@ViewScoped
public class UsuarioBean {

    public UsuarioBean (){
        this.usuario = new Usuario();
    }
    private Usuario usuario;

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    private Telefone telefone = new Telefone();
    @Autowired
    private UsuarioService usuarioService;

    public String login(){

        Usuario usuario = usuarioService.login(getUsuario().getEmail(),getUsuario().getSenha());

        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        }

        setUsuario(new Usuario());
        return "/index.jsf";

    }
    public String cadastrar (){

        this.usuario.setTelefones(Arrays.asList(telefone));
        Usuario usuario = usuarioService.cadastrar(this.usuario);
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar!",
                            ""));
            return null;
        }

        setUsuario(new Usuario());
        return "/login.jsf";
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
