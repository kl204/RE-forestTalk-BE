package bitedu.bipa.forestTalk.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import bitedu.bipa.forestTalk.repository.user.LoginRepository;

/*
  인증
  인증이 필요한 경우 반드시 JwtAuthorizationFilter를 태워서 session에 user정보를 담아가야 한다
  url : bean.addUrlPatterns("/user/*") => FilterConfig.java
*/
public class JwtAuthorizationFilter implements Filter {
	
	private LoginRepository loginRepository;
	
	public JwtAuthorizationFilter(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

}
