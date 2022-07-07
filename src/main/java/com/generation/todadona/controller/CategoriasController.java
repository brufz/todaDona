package com.generation.todadona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.todadona.model.CategoriasModel;
import com.generation.todadona.repository.CategoriasRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
	
	@Autowired
	public CategoriasRepository repository;

	@GetMapping
	public ResponseEntity<List<CategoriasModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
}
