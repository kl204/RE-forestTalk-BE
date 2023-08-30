package bitedu.bipa.forestTalk.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import bitedu.bipa.forestTalk.repository.user.LoginRepository;

public class JwtAuthenticationFilter implements Filter {
	
private LoginRepository loginRepository;
	
	public JwtAuthenticationFilter(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

}
