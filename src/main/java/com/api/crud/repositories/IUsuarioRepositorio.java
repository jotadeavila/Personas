package com.api.crud.repositories;

import com.api.crud.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<UsuarioModel, Long> {
}
