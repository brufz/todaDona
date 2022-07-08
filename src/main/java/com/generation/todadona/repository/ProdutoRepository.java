package com.generation.todadona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.todadona.model.ProdutosModel;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutosModel, Long> {
	
}
