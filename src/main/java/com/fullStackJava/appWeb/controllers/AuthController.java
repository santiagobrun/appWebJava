package com.fullStackJava.appWeb.controllers;

import com.fullStackJava.appWeb.DAO.UsuarioDAO;
import com.fullStackJava.appWeb.models.Usuario;
import com.fullStackJava.appWeb.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuarioDAO.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLogueado != null){
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()),usuarioLogueado.getEmail());
            return tokenJwt;
        }

        return "FAIL";
    }

}
