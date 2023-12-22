package com.siteviagem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_destino;
	private String cidade;
	private String pais;
	private String aeroporto;
	
	public Destino() {
		
	}
	public Destino(long id_destino, String cidade, String pais, String aeroporto) {
		super();
		this.id_destino = id_destino;
		this.cidade = cidade;
		this.pais = pais;
		this.aeroporto = aeroporto;
	}
	public long getId_destino() {
		return id_destino;
	}
	public void setId_destino(long id_destino) {
		this.id_destino = id_destino;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(String aeroporto) {
		this.aeroporto = aeroporto;
	}
	
}
