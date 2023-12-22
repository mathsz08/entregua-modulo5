package com.siteviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siteviagem.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
