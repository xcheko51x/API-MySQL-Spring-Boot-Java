package dev.xcheko51x.crud;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repositorio;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) repositorio.findAll();
    }

    public UsuarioModel agregarUsuario(UsuarioModel usuario) {
        return repositorio.save(usuario);
    }

    public Boolean eliminarUsuario(Integer idUsuario) {
        try {
            repositorio.deleteById(idUsuario);
            return true;
        } catch(Exception error) {
            return false;
        }
    }
}
