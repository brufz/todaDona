package com.generation.todadona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.todadona.model.CategoriasModel;

@Repository
public interface CategoriasRepository extends JpaRepository <CategoriasModel, Long>{

	public List<CategoriasModel> findAllByCategoriaContainingIgnoreCase(@Param ("categoria") String categoria);
}
