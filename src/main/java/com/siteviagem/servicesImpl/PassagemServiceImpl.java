package com.siteviagem.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siteviagem.model.Passagem;
import com.siteviagem.services.PassagemService;
import com.siteviagem.repositories.PassagemRepository;
@Service
public class PassagemServiceImpl implements PassagemService{
	@Autowired
	private PassagemRepository PassagemRepository;
	
	@Override
	public List<Passagem> getAllPassagens() {
		return PassagemRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Passagem getPassagemById(Long id) {
		return PassagemRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Passagem savePassagem(Passagem Passagem) {
		return PassagemRepository.save(Passagem);
	}

	@Override
	public Passagem updatePassagem(Long id, Passagem PassagemAtt) {
		Passagem PassagemExistente = PassagemRepository.findById(id).orElse(null);
		if(PassagemExistente != null) {
			PassagemExistente.setId_passagem(PassagemAtt.getId_passagem());
			PassagemExistente.setValor(PassagemAtt.getValor());
			PassagemExistente.setCompanhia(PassagemAtt.getCompanhia());
			PassagemExistente.setDataIda(PassagemAtt.getDataIda());
			PassagemExistente.setDataVolta(PassagemAtt.getDataVolta());
			return PassagemRepository.save(PassagemExistente);
		}else {
			throw new RuntimeException("Passagem com Id " + id + " não encontrada"); 
		}
		
	}

	@Override
	public void deletePassagem(Long id) {
		PassagemRepository.deleteById(id);
		
	}
}
