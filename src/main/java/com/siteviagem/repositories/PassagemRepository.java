package com.siteviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siteviagem.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem,Long> {

}
