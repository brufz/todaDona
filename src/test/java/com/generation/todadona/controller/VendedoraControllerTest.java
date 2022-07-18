package com.generation.todadona.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.todadona.model.VendedoraModel;
import com.generation.todadona.repository.VendedoraRepository;
import com.generation.todadona.service.VendedoraService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VendedoraControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private VendedoraService vendedoraService;

    @Autowired
	private VendedoraRepository vendedoraRepository;
	
	@BeforeAll
	void start(){

		vendedoraRepository.deleteAll();
	}

	@Test
	@Order(1)
	@DisplayName("Cadastrar Um Usuário")
	public void deveCriarUmUsuario() {

		HttpEntity<VendedoraModel> requisicao = new HttpEntity<VendedoraModel>(new VendedoraModel(0L, 
				"Joana da Silva", "43565467899", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));

		ResponseEntity<VendedoraModel> resposta = testRestTemplate
			.exchange("/vendedora/cadastrar", HttpMethod.POST, requisicao, VendedoraModel.class);

		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNomeVendedora(), resposta.getBody().getNomeVendedora());
		assertEquals(requisicao.getBody().getCpf(), resposta.getBody().getCpf());
	}

	@Test
	@Order(2)
	@DisplayName("Não deve permitir duplicação do Usuário")
	public void naoDeveDuplicarUsuario() {

		vendedoraService.cadastrarUsuario(new VendedoraModel(0L, "Joana da Silva", "43565467899", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));

		HttpEntity<VendedoraModel> requisicao = new HttpEntity<VendedoraModel>(new VendedoraModel(0L, "Joana da Silva", "43565467899", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));

		ResponseEntity<VendedoraModel> resposta = testRestTemplate
			.exchange("/vendedora/cadastrar", HttpMethod.POST, requisicao, VendedoraModel.class);

		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	/*
	@Test
	@Order(3)
	@DisplayName("Alterar um Usuário")
	public void deveAtualizarUmUsuario() {

		Optional<VendedoraModel> usuarioCreate = vendedoraService.cadastrarUsuario(new VendedoraModel( 
				0L, "Joaninha da Silva", "43565467339", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));

		VendedoraModel usuarioUpdate = new VendedoraModel(usuarioCreate.get().getId(), 
				"Joaninha da Silva", "43565467331", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123");
		
		HttpEntity<VendedoraModel> requisicao = new HttpEntity<VendedoraModel>(usuarioUpdate);

		ResponseEntity<VendedoraModel> resposta = testRestTemplate
			.withBasicAuth("root", "root")
			.exchange("/usuarios/atualizar", HttpMethod.PUT, requisicao, VendedoraModel.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals(usuarioUpdate.getNome_vendedora(), resposta.getBody().getNome_vendedora());
		assertEquals(usuarioUpdate.getCpf(), resposta.getBody().getCpf());
	} */

	@Test
	@Order(4)
	@DisplayName("Listar todos os Usuários")
	public void deveMostrarTodosUsuarios() {

		vendedoraService.cadastrarUsuario(new VendedoraModel(0L, "Joana da Silva", "43565467899", "https://i.imgur.com/FETvs2O.jpg",
		                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));
		
		vendedoraService.cadastrarUsuario(new VendedoraModel(0L, "Joaninha da Silva", "43335467899", "https://i.imgur.com/FETvs2O.jpg",
                "Rua abc, 720", "1145567666", "joanadasilva@gmail.com", "joaninha123"));

		ResponseEntity<String> resposta = testRestTemplate
			.withBasicAuth("root", "root")
			.exchange("/usuarios/all", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

}