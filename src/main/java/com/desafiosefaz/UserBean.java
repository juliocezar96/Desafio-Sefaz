package com.desafiosefaz;

import com.desafiosefaz.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.view.ViewScoped;
import java.util.Arrays;
import java.util.Collection;

@Component
@ViewScoped
public class UserBean {

    @Autowired
    private MsgService msgService;

    public String getMsg() {
        return msgService.getMsg();
    }


}