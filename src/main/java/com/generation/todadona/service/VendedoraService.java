package com.generation.todadona.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.generation.todadona.model.VendedoraLogin;
import com.generation.todadona.model.VendedoraModel;
import com.generation.todadona.repository.VendedoraRepository;

@Service
@SuppressWarnings("deprecation")
public class VendedoraService {

	@Autowired
	private VendedoraRepository vendedoraRepository;

	public Optional<VendedoraModel> cadastrarUsuario(VendedoraModel vendedora) {
		if (vendedoraRepository.findByCpf(vendedora.getCpf()).isPresent())
			return Optional.empty();

		vendedora.setSenha(criptografarSenha(vendedora.getSenha()));

		return Optional.of(vendedoraRepository.save(vendedora));
	}

	private String criptografarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);

	}

	public Optional<VendedoraLogin> logarUsuario(Optional<VendedoraLogin> vendedoraLogin) {
		Optional<VendedoraModel> usuario = vendedoraRepository.findByCpf(vendedoraLogin.get().getCpf());

		if (usuario.isPresent()) {
			if (compararSenhas(vendedoraLogin.get().getSenha(), usuario.get().getSenha())) {
				vendedoraLogin.get().setCpf(usuario.get().getCpf());
				vendedoraLogin.get()
						.setToken(gerarBasicToken(vendedoraLogin.get().getCpf(), vendedoraLogin.get().getSenha()));
				vendedoraLogin.get().setSenha(usuario.get().getSenha());

				return vendedoraLogin;
			}
		}
		return Optional.empty();
	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(senhaDigitada, senhaBanco);

	}

	@SuppressWarnings("unused")
	private String gerarBasicToken(String usuario, String senha) {

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);

	}

}
