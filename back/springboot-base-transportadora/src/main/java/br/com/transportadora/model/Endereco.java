package br.com.transportadora.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;



@Builder
@AllArgsConstructor
@Entity(name = "TbEndereco")
public class Endereco implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoEndereco;
	
	@NotNull
	private String rua; 
	
	@NotNull
	private String numero; 
	
	@NotNull
	private String bairro;
	
	@NotNull
	private String cidade;
	
	@NotNull
	private String uf;
	
	@ManyToOne
	private Transportadora transportadora;

	public Long getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
	
	public Transportadora getTransportadora() {
		return transportadora;
	}
	
}
