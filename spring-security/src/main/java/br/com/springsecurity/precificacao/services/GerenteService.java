package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GerenteService {

    Page<Gerente> findAll(Pageable pageable);

    Optional<Gerente> findByNome(String nome);

    Gerente save(Gerente gerente);

    void deleteById(Long id);

}
