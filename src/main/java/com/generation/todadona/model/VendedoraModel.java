package com.generation.todadona.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_vendedoras")
public class VendedoraModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, max = 55)
	private String nomeVendedora;

	
	@Schema(example = "11122233344")
	@NotNull(message = "O atributo Cpf é Obrigatório!")
	@CPF(message = "O cpf deve ser válido!")
	private String cpf;

	
	private String foto_documento;

	@NotNull
	private String endereco;

	@NotNull
	@Size(min = 11)
	private String telefone;

	@NotNull
	
	@Email(message = "O atributo deve ser um email válido!")
	private String email;

	@NotNull
	@Size(min = 8, max = 255)
	private String senha;

	@OneToMany(mappedBy = "vendedoras", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vendedoras")
	private List<ProdutosModel> produtos;

	
	
	public VendedoraModel(Long id, String nomeVendedora, String cpf, String foto_documento, String senha, String endereco, String telefone, String email) {
		this.id = id;
		this.nomeVendedora = nomeVendedora;
		this.cpf = cpf;
		this.foto_documento = foto_documento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public VendedoraModel() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVendedora() {
		return nomeVendedora;
	}

	public void setNomeVendedora(String nomeVendedora) {
		this.nomeVendedora = nomeVendedora;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFoto_documento() {
		return foto_documento;
	}

	public void setFoto_documento(String foto_documento) {
		this.foto_documento = foto_documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
