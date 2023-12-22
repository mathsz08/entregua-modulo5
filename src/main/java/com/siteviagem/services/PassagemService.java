package com.siteviagem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siteviagem.model.Passagem;


@Service
public interface PassagemService {
List<Passagem> getAllPassagens();
	
	Passagem getPassagemById(Long id);
	
	Passagem savePassagem(Passagem Passagem);
	
	Passagem updatePassagem(Long id, Passagem PassagemAtt);
	
	void deletePassagem(Long id);
}
