package com.siteviagem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siteviagem.model.Destino;

@Service
public interface DestinoService {
	
	List<Destino> getAllDestinos();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino Destino);
	
	Destino updateDestino(Long id, Destino DestinoAtt);
	
	void deleteDestino(Long id);
}
