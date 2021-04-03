package com.neuwirt.mycar.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;

@Entity
@Table(name="tb_carro")
public class Carro {	
	
	@Id
	private String placa;
	
	@NotNull
	@Size(max = 30)
	private String marca;
	
	@NotNull
	@Size(max = 30)
	private String modelo;
	
	@NotNull
	private Integer ano;
	
	@Size(max = 15)
	private String cor;
	
	@NotNull
	private Double valor;

	public Carro(String placa, String marca, String modelo, Integer ano, String cor, Double valor) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.valor = valor;
	}
	
	Carro(){
		
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
	
}
