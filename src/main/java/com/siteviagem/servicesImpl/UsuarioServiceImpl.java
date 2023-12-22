package com.siteviagem.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siteviagem.model.Usuario;
import com.siteviagem.repositories.UsuarioRepository;
import com.siteviagem.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return UsuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Usuario getUsuarioById(Long id) {
		return UsuarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario Usuario) {
		return UsuarioRepository.save(Usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario UsuarioAtt) {
		Usuario UsuarioExistente = UsuarioRepository.findById(id).orElse(null);
		if(UsuarioExistente != null) {
			UsuarioExistente.setNome(UsuarioAtt.getNome());
			UsuarioExistente.setRg(UsuarioAtt.getRg());
			UsuarioExistente.setEndereco(UsuarioAtt.getEndereco());
			UsuarioExistente.setSenha(UsuarioAtt.getSenha());
			UsuarioExistente.setLogin(UsuarioAtt.getLogin());
			return UsuarioRepository.save(UsuarioExistente);
		}else {
			throw new RuntimeException("Usuario com Id " + id + " não encontrada"); 
		}
		
	}

	@Override
	public void deleteUsuario(Long id) {
		UsuarioRepository.deleteById(id);
		
	}
}
