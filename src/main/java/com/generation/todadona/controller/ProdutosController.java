package com.generation.todadona.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.todadona.model.ProdutosModel;
import com.generation.todadona.repository.ProdutoRepository;


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	public ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity <List<ProdutosModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<ProdutosModel> getById(@PathVariable long id){
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ProdutosModel> post (@RequestBody @Valid ProdutosModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutosModel> put (@RequestBody @Valid ProdutosModel produto){
		return repository.findById(produto.getId()).map(resp -> {
			return ResponseEntity.ok().body(repository.save(produto));
		}).orElse(ResponseEntity.notFound().build());		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return repository.findById(id).map(resp -> {repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}	
}
