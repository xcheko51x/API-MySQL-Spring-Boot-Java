package dev.xcheko51x.crud;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService servicio;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return servicio.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel agregarUsuario(
        @RequestBody UsuarioModel usuario
    ) {
        return this.servicio.agregarUsuario(usuario);
    }

    @DeleteMapping(path = "/{idUsuario}")
    public String eliminarUsuario(
        @PathVariable("idUsuario") Integer idUsuario
    ) {
        boolean isSuccess = this.servicio.eliminarUsuario(idUsuario);
        if(isSuccess) {
            return "Se eliminó correctamente el usuario";
        } else {
            return "No se pudó eliminar el usuario";
        }
    }

}
