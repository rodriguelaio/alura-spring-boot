package br.com.springsecurity.precificacao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private AutenticacaoService autenticacaoService;

    @Autowired
    public SecurityConfigurations(AutenticacaoService autenticacaoService){
        this.autenticacaoService = autenticacaoService;
    }

    //Configuracao de autenticacao (acesso, login...)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configuracao de recursos estaticos (js, css, imagens...)
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    //Configuracao de autorizacao (url, perfil de acesso...)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/gerentes").permitAll() //Faço a liberação de todos os metodos GET da rota /gerentes
                .antMatchers(HttpMethod.GET, "/gerentes/**").permitAll() //Como meu endpoint tem um caminho antes da variavel, preciso usar ** ao inves de *
                .anyRequest().authenticated() //qualquer outra rota precisa de autenticação para ser acessada
                .and().formLogin(); //o spring exibe um formulário de login e senha
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }
}
