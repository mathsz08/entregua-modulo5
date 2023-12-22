package com.siteviagem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siteviagem.model.Usuario;
import com.siteviagem.services.UsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService UsuarioService;
	
	@GetMapping
	public String ListUsuarios(Model model) {
		List<Usuario> Usuarios = UsuarioService.getAllUsuarios();
		model.addAttribute("usuarios", Usuarios);
		return "pages/usuarios";
	}
	
	// Formulario Criação
		@GetMapping("/novo")
		public String showFormAdd(Model model) {
			Usuario Usuario = new Usuario();
			model.addAttribute("usuario",Usuario);
			return "pages/create-form/create-usuario";
		}
		
		//Persistencia Criação 
		@PostMapping("/save")
		 public String saveUsuario(@ModelAttribute("usuario") Usuario Usuario) {
			 UsuarioService.saveUsuario(Usuario);
			 return "redirect:/usuarios";
		 }
		
		 // Formulario de edição
		 @GetMapping("/editar/{id}")
		 public String showFormForUpdate(@PathVariable Long id, Model model) {
			 Usuario Usuario = UsuarioService.getUsuarioById(id);
			 model.addAttribute("usuario",Usuario);
			 return "pages/update-form/update-usuario";
		 }
		 
		 //Persistencia de Edição
		 @PostMapping("/editar/{id}")
		 public String updateUsuario(@PathVariable Long id,@ModelAttribute("usuario") Usuario Usuario) {
			 UsuarioService.updateUsuario(id, Usuario);
			 return "redirect:/usuarios";
		 }
		 
		 // Excluir Usuario
		 @GetMapping("/deletar/{id}")
		 public String deleteUsuario(@PathVariable Long id) {
			 UsuarioService.deleteUsuario(id);
			 return "redirect:/usuarios";
		 }
	
}
