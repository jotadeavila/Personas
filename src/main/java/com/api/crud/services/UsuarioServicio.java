package com.api.crud.services;

import com.api.crud.models.UsuarioModel;
import com.api.crud.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositorio.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel){
        return usuarioRepositorio.save(usuarioModel);
    }

    public UsuarioModel obtenerUnUsuario(Long id){
        return usuarioRepositorio.findById(id).get();
    }

    public UsuarioModel modificarUsuario(UsuarioModel request, Long id){
        UsuarioModel usuarioModel = usuarioRepositorio.findById(id).get();

        usuarioModel.setNombre(request.getNombre());
        usuarioModel.setApellido(request.getApellido());
        usuarioModel.setEmail(request.getEmail());

        return usuarioModel;
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepositorio.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
