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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_vendedoras")
public class VendedoraModel {
	

	public VendedoraModel() {
		super();
	}

	public VendedoraModel(long id, @NotNull @Size(min = 5, max = 55) String nomeVendedora,
			@NotNull @Size(min = 11, max = 11) String cpf, @NotNull String foto_documento,
			@NotNull @Size(min = 11, max = 255) String endereco, @NotNull @Size(min = 11, max = 11) String telefone,
			@NotNull @Size(min = 5, max = 55) String email, @NotNull @Size(min = 8) String senha) {
		super();
		this.id = id;
		this.nomeVendedora = nomeVendedora;
		this.cpf = cpf;
		this.foto_documento = foto_documento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 5, max = 55)
	private String nomeVendedora;

	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	private String foto_documento;

	@NotNull
	@Size(min = 11, max = 255)
	private String endereco;

	@NotNull
	@Size(min = 11, max = 11)
	private String telefone;

	@NotNull
	@Size(min = 5, max = 55)
	private String email;

	@NotNull
	@Size(min = 8)
	private String senha;

	@OneToMany(mappedBy = "vendedoras", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vendedoras")
	private List<ProdutosModel> produtos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<ProdutosModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosModel> produtos) {
		this.produtos = produtos;
	}

	
}
