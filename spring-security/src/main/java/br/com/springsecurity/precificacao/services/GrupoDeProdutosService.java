package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GrupoDeProdutosService {

    Optional<GrupoDeProdutos> findById(Long grupoDeProdutosId);

    Page<GrupoDeProdutos> findAll(Pageable pageable);

    GrupoDeProdutos save(GrupoDeProdutos grupoDeProdutos);

    void deleteById(Long grupoDeProdutosId);
}
