package br.com.springsecurity.precificacao.security;

import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private AutenticacaoService autenticacaoService;

    @Autowired
    public SecurityConfigurations(AutenticacaoService autenticacaoService) {
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
//        List<Integer> aliceAndBob = new ArrayList<>();
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//
//        aliceAndBob.add(0);
//        aliceAndBob.add(0);
//        a.add(4);
//        a.add(2);
//        a.add(3);
//        b.add(3);
//        b.add(2);
//        b.add(1);
//        for(int i = 0; i < 3; i++){
//            if(a.get(i) < b.get(i)) {
//                aliceAndBob.set(1, aliceAndBob.get(1) + 1);
//                continue;
//            }
//            if(a.get(i) > b.get(i)) aliceAndBob.set(0, aliceAndBob.get(0) + 1);
//        }
//        System.out.println(aliceAndBob.get(0) + " - " + aliceAndBob.get(1));
//    }

//    public static void main(String[] args) {
//        List<List<Integer>> arr = new ArrayList<>();
//        int leftToRight = 0;
//        int rightToLeft = 0;
//        arr.add(Arrays.asList(10, 2, 3));
//        arr.add(Arrays.asList(4, 5, 6));
//        arr.add(Arrays.asList(-9, 8, 1));
//        for(int i = 0; i< arr.size(); i++){
//            leftToRight += arr.get(i).get(i);
//            rightToLeft += arr.get(i).get(arr.size() - 1 - i);
//        }
//        System.out.println(leftToRight + " - " + rightToLeft + " - " + (leftToRight < rightToLeft ? rightToLeft - leftToRight: leftToRight - rightToLeft));
//    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, -1, -1};
        double[] fractions = new double[3];
        for(int number : arr){
            if(number > 0){
                fractions[0]++;
                continue;
            }
            if(number < 0){
                fractions[1]++;
                continue;
            }
            fractions[2]++;
        }
        System.out.println(fractions[0] / arr.length);
        System.out.println(fractions[1] / arr.length);
        System.out.println(fractions[2] / arr.length);

    }
}