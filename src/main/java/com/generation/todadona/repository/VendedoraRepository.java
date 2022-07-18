package com.generation.todadona.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.todadona.model.VendedoraModel;

@Repository
public interface VendedoraRepository extends JpaRepository<VendedoraModel, Long> {
	public Optional<VendedoraModel> findByCpf(String cpf);
	public List<VendedoraModel> findAllByNomeVendedoraContainingIgnoreCase(@Param("nomeVendedora") String nomeVendedora);
}
