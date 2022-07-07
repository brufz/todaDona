package com.generation.todadona.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class CategoriasModel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size (min = 2 , max = 100)
		private String categoria;
		
		@OneToMany(mappedBy = "categorias", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categorias")
		private List<ProdutosModel> produtos;


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
		public List<ProdutosModel> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<ProdutosModel> produtos) {
			this.produtos = produtos;
		}
		
}
