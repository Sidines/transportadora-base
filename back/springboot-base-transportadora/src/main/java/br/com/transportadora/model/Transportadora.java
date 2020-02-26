package br.com.transportadora.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

//import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
@Entity(name = "TbTransportadora")
public class Transportadora implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoTransportadora;
	
	@NotNull
	private String email;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String empresa;
	
	@NotNull
	private String telefone; 
	
	@NotNull
	private String modal;
	
	@NotNull
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Endereco> enderecos;
	
	
	public Long getCodigoTransportadora() {
		return codigoTransportadora;
	}
	public void setCodigoTransportadora(Long codigoTransportadora) {
		this.codigoTransportadora = codigoTransportadora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getModal() {
		return modal;
	}
	public void setModal(String modal) {
		this.modal = modal;
	}
	public List<Endereco> getEndereco() {
		return enderecos;
	}
	public void setEndereco(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
