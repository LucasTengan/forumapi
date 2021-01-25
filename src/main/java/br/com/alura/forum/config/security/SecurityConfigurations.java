package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	// Configurações de autenticação -> acesso, login...
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// Configurações de autorização -> url's, quem pode acesssar cada url...
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
	}
	
	// Configurações de recursos estáticos -> javascripts, css, imagens...
	@Override
	public void configure(WebSecurity web) throws Exception {

		
	}
}
