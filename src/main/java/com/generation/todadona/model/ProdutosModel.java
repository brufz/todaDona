package com.generation.todadona.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ProdutosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 2 , max = 100)
	private String nome_produto;

	@NotNull
	@Column(columnDefinition = "decimal(10,2)")
	private double valor_produto; 
	
	@NotNull
	@Size (min = 10 , max = 500)
	private String descricao_produto; 
	
	public String getDescricao_produto() {
		return descricao_produto;
	}
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	public CategoriasModel getCategorias() {
		return categorias;
	}
	public void setCategorias(CategoriasModel categorias) {
		this.categorias = categorias;
	}
	public VendedoraModel getVendedoras() {
		return vendedoras;
	}
	public void setVendedoras(VendedoraModel vendedoras) {
		this.vendedoras = vendedoras;
	}
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private CategoriasModel categorias;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private VendedoraModel vendedoras; 
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public double getValor_produto() {
		return valor_produto;
	}
	public void setValor_produto(double valor_produto) {
		this.valor_produto = valor_produto;
	}
	
}
