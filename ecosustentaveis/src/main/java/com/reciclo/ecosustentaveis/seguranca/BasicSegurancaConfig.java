package com.reciclo.ecosustentaveis.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSegurancaConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/usuario/logar").permitAll()
		.antMatchers("/usuario/cadastrar").permitAll()
		.antMatchers("/produto/all").permitAll()
		.antMatchers("/usuario/busca/{usuarioEmail}","/usuario/{usuarioId}","/usuario/email/{usuarioEmail}").permitAll()				
/*

PERMITEM TODAS AS REQUISICOES
*/
		.antMatchers(HttpMethod.POST).permitAll()
		.antMatchers(HttpMethod.PUT).permitAll()
		.antMatchers(HttpMethod.DELETE).permitAll()
		.antMatchers(HttpMethod.GET).permitAll()

		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
		
	}
	
	
}