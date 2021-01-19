package com.desafiosefaz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.faces.bean.ViewScoped;


@Controller
@ViewScoped
public class UsuarioController {

    @GetMapping
    public String index() {
        return "/login.jsf";
    }
}
