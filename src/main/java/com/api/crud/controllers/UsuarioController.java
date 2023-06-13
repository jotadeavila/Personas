package com.api.crud.controllers;

import com.api.crud.models.UsuarioModel;
import com.api.crud.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/personas")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ArrayList<UsuarioModel> getUsuarios(){
        return this.usuarioServicio.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioServicio.guardarUsuario(usuarioModel);
    }

    @GetMapping(path = "/{id}")
    public UsuarioModel getUnUsuario(@PathVariable("id") Long id){
        return this.usuarioServicio.obtenerUnUsuario(id);
    }

    @PutMapping(path = "/{id}")
    public UsuarioModel putUsuario(@RequestBody UsuarioModel request, @PathVariable("id") Long id){
        return this.usuarioServicio.modificarUsuario(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUsuario(@PathVariable("id") Long id){
        boolean res = usuarioServicio.eliminarUsuario(id);

        if(res){
            return "Eliminado";
        }else{
            return "Ha ocurrido un error";
        }
    }
}