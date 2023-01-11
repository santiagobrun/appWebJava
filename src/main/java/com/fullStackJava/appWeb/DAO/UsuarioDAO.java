package com.fullStackJava.appWeb.DAO;

import com.fullStackJava.appWeb.models.Usuario;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
