package br.com.springsecurity.precificacao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //Configuracao de autenticacao (acesso, login...)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    //Configuracao de recursos estaticos (js, css, imagens...)
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    //Configuracao de autorizacao (url, perfil de acesso...)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/gerentes").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
