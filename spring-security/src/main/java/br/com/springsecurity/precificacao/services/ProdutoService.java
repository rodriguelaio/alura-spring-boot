package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoService {

    Optional<Produto> findById(Long id);

    Optional<Produto> findByNome(String nome);

    Page<Produto> findAll(Pageable pageable);

    Page<Optional<Produto>> findByTipo(Pageable pageable, TipoDeProdutos tipoDeProdutos);

    Page<Optional<Produto>> findByGrupo(Pageable pageable, GrupoDeProdutos grupoDeProdutos);

    Produto save(Produto produto);

    void deleteById(Long id);
}
