package com.siteviagem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/cadastro")
	public String cadastro() {
		return "pages/cadastro";
	}
	@GetMapping("/home")
	public String home() {
		return "pages/home";
	}
	@GetMapping("/contato")
	public String contato() {
		return "pages/contato";
	}
	@GetMapping("/destino")
	public String destino() {
		return "pages/destinos";
	}
	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}
	@GetMapping("/promocoes")
	public String promocoes() {
		return "pages/promocoes";
	}
}
