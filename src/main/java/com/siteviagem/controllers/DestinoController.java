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

import com.siteviagem.model.Destino;
import com.siteviagem.services.DestinoService;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
	@Autowired
	private DestinoService DestinoService;
	
	@GetMapping
	public String ListDestinos(Model model) {
		List<Destino> destinos = DestinoService.getAllDestinos();
		model.addAttribute("destinos", destinos);
		return "pages/promocoes";
	}
	
	// Formulario Criação
		@GetMapping("/novo")
		public String showFormAdd(Model model) {
			Destino Destino = new Destino();
			model.addAttribute("destino",Destino);
			return "pages/create-form/create-destino";
		}
		
		//Persistencia Criação 
		@PostMapping("/save")
		 public String saveDestino(@ModelAttribute("Destino") Destino Destino) {
			 DestinoService.saveDestino(Destino);
			 return "redirect:/destinos";
		 }
		
		 // Formulario de edição
		 @GetMapping("/editar/{id}")
		 public String showFormForUpdate(@PathVariable Long id, Model model) {
			 Destino Destino = DestinoService.getDestinoById(id);
			 model.addAttribute("destino",Destino);
			 return "pages/update-form/update-destino";
		 }
		 
		 //Persistencia de Edição
		 @PostMapping("/editar/{id}")
		 public String updateDestino(@PathVariable Long id,@ModelAttribute("destino") Destino Destino) {
			 DestinoService.updateDestino(id, Destino);
			 return "redirect:/destinos";
		 }
		 
		 // Excluir Destino
		 @GetMapping("/deletar/{id}")
		 public String deleteDestino(@PathVariable Long id) {
			 DestinoService.deleteDestino(id);
			 return "redirect:/destinos";
		 }
	
}
