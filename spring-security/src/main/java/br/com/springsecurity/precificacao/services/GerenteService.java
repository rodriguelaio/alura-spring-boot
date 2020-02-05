package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GerenteService {

    Optional<Gerente> findById(Long id);

    Optional<Gerente> findByNome(String nome);

    Optional<Gerente> findByProdutoId(Long produtoId);

    Page<Gerente> findAll(Pageable pageable);

    Page<Gerente> findByGrupoDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

    Gerente save(Gerente gerente);

    void deleteById(Long id);
}
