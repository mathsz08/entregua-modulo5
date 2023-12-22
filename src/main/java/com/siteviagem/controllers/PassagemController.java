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

import com.siteviagem.model.Passagem;
import com.siteviagem.services.PassagemService;

@Controller
@RequestMapping("/passagens")
public class PassagemController {
	@Autowired
	private PassagemService PassagemService;
	
	@GetMapping
	public String ListPassagems(Model model) {
		List<Passagem> Passagens = PassagemService.getAllPassagens();
		model.addAttribute("passagens", Passagens);
		return "pages/passagens";
	}
	
	// Formulario Criação
		@GetMapping("/novo")
		public String showFormAdd(Model model) {
			Passagem Passagem = new Passagem();
			model.addAttribute("passagem",Passagem);
			return "pages/create-form/create-passagem";
		}
		
		//Persistencia Criação 
		@PostMapping("/save")
		 public String savePassagem(@ModelAttribute("Passagem") Passagem Passagem) {
			 PassagemService.savePassagem(Passagem);
			 return "redirect:/passagens";
		 }
		
		 // Formulario de edição
		 @GetMapping("/editar/{id}")
		 public String showFormForUpdate(@PathVariable Long id, Model model) {
			 Passagem Passagem = PassagemService.getPassagemById(id);
			 model.addAttribute("passagem",Passagem);
			 return "pages/update-form/update-passagem";
		 }
		 
		 //Persistencia de Edição
		 @PostMapping("/editar/{id}")
		 public String updatePassagem(@PathVariable Long id,@ModelAttribute("passagem") Passagem Passagem) {
			 PassagemService.updatePassagem(id, Passagem);
			 return "redirect:/passagens";
		 }
		 
		 // Excluir Passagem
		 @GetMapping("/deletar/{id}")
		 public String deletePassagem(@PathVariable Long id) {
			 PassagemService.deletePassagem(id);
			 return "redirect:/passagens";
		 }
	
}
