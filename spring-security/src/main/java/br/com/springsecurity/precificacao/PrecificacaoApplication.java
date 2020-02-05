package br.com.springsecurity.precificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//@EnableSpringDataWebSupport
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PrecificacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrecificacaoApplication.class, args);
    }

}