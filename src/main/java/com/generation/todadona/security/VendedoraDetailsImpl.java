package com.generation.todadona.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.todadona.model.VendedoraModel;

public class VendedoraDetailsImpl implements UserDetails {
	public static final long serialVersionUID = 1L;

	private String userCpf;
	private String password;

	private List<GrantedAuthority> authorities;

	public VendedoraDetailsImpl(VendedoraModel user) {
		this.userCpf = user.getCpf();
		this.password = user.getSenha();
	}

	public VendedoraDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userCpf;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
