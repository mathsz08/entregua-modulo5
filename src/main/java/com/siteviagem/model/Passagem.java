package com.siteviagem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_passagem;
	private String dataIda;
	private String dataVolta;
	private String companhia;
	
	@OneToOne
	private Destino destino;
	private double valor;
	
	
	
	public Passagem() {
		
	}
	public Passagem(long id_passagem, String dataIda, String dataVolta, String companhia, double valor) {
		super();
		this.id_passagem = id_passagem;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.companhia = companhia;
		this.valor = valor;
	}
	public long getId_passagem() {
		return id_passagem;
	}
	public void setId_passagem(long id_passagem) {
		this.id_passagem = id_passagem;
	}
	public String getDataIda() {
		return dataIda;
	}
	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}
	public String getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	public String getCompanhia() {
		return companhia;
	}
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}
