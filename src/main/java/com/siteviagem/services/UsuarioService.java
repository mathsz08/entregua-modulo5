package com.siteviagem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siteviagem.model.Usuario;

@Service
public interface UsuarioService {
	
List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(Long id);
	
	Usuario saveUsuario(Usuario Usuario);
	
	Usuario updateUsuario(Long id, Usuario UsuarioAtt);
	
	void deleteUsuario(Long id);
	
}
