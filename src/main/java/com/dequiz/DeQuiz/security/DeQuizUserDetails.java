package com.dequiz.DeQuiz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.dequiz.DeQuiz.dto.DeQuizLogin;

public class DeQuizUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private DeQuizLogin deQuizLogin;
	
	public DeQuizUserDetails(DeQuizLogin deQuizLoginPara) {
		this.deQuizLogin = deQuizLoginPara;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList <SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return deQuizLogin.getDqlPassword();
	}

	@Override
	public String getUsername() {
		return deQuizLogin.getDqlUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
