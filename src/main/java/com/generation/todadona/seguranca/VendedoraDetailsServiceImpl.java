package com.generation.todadona.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.todadona.model.VendedoraModel;
import com.generation.todadona.repository.VendedoraRepository;

@Service
public class VendedoraDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private VendedoraRepository vendedoraRepository;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Optional<VendedoraModel> user = vendedoraRepository.findByCpf(cpf);
		user.orElseThrow(() -> new UsernameNotFoundException(cpf + " not found."));

		return user.map(VendedoraDetailsImpl::new).get();
	}

}
