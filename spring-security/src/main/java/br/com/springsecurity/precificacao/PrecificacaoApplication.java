package br.com.springsecurity.precificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class PrecificacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrecificacaoApplication.class, args);
    }

}