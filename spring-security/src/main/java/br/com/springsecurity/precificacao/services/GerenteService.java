package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.Gerente;

public interface GerenteService {

    Gerente findByNome(String nome);

    Gerente save(Gerente gerente);

}
