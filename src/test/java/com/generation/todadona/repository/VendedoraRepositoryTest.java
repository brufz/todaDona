package com.generation.todadona.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.todadona.model.VendedoraModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VendedoraRepositoryTest {
    
	@Autowired
	private VendedoraRepository vendedoraRepository;
	
	@BeforeAll
	void start(){
        
		vendedoraRepository.deleteAll();

		vendedoraRepository.save(new VendedoraModel(0L, "Joana da Silva", "43565467899", "https://i.imgur.com/FETvs2O.jpg",
                                           "Rua abc, 720", "1145567666", "joanadasilva@gmail.com","joaninha1123" ));
		
		vendedoraRepository.save(new VendedoraModel(0L, "Maria da Silva", "44465467899", "https://i.imgur.com/FETvs30.jpg",
                "Rua abc, 730", "1135567666", "mariadasilva@gmail.com","mariasilva1123"));
		
		vendedoraRepository.save(new VendedoraModel(0L, "Fatima dos Santos", "43566467899", "https://i.imgur.com/FETvs40.jpg",
                "Rua abcd, 720", "1345567666", "fatimadasilva@gmail.com","fatiminha1123" ));

		vendedoraRepository.save(new VendedoraModel(0L, "Marina da Silva", "42265467899", "https://i.imgurr.com/FETvs2O.jpg",
                "Rua abcdef, 720", "1145566666", "marinadasilva@gmail.com","marininha1123" ));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<VendedoraModel> usuario = vendedoraRepository.findByCpf("43565467899");
		assertTrue(usuario.get().getCpf().equals("43565467899"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<VendedoraModel> listaDeUsuarios = vendedoraRepository.findAllByNomeVendedoraContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNomeVendedora().equals("Joana da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNomeVendedora().equals("Maria da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNomeVendedora().equals("Marina da Silva"));
		
	}
    
}