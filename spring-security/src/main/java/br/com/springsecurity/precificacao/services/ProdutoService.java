package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoService {

    Optional<Produto> findById(Long produtoId);

    Optional<Produto> findByNome(String nomeDoProduto);

    Page<Produto> findAll(Pageable pageable);

    Page<Produto> findByTipoDeProdutos(Pageable pageable, TipoDeProdutos tipoDeProdutos);

    Page<Produto> findByGrupoDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

    Produto save(Produto produto);

    void deleteById(Long produtoId);
}
