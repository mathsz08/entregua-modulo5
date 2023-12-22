package com.siteviagem.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siteviagem.model.Destino;
import com.siteviagem.services.DestinoService;

import com.siteviagem.repositories.DestinoRepository;

@Service
public class DestinoServiceImpl implements DestinoService {
	@Autowired
	private DestinoRepository DestinoRepository;
	
	@Override
	public List<Destino> getAllDestinos() {
		return DestinoRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Destino getDestinoById(Long id) {
		return DestinoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Destino saveDestino(Destino Destino) {
		return DestinoRepository.save(Destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino DestinoAtt) {
		Destino DestinoExistente = DestinoRepository.findById(id).orElse(null);
		if(DestinoExistente != null) {
			DestinoExistente.setId_destino(DestinoAtt.getId_destino());
			DestinoExistente.setPais(DestinoAtt.getPais());
			DestinoExistente.setCidade(DestinoAtt.getCidade());
			DestinoExistente.setAeroporto(DestinoAtt.getAeroporto());
			
			return DestinoRepository.save(DestinoExistente);
		}else {
			throw new RuntimeException("Destino com Id " + id + " não encontrada"); 
		}
		
	}

	@Override
	public void deleteDestino(Long id) {
		DestinoRepository.deleteById(id);
		
	}
}
