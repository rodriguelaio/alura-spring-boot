package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GerenteService {

    Optional<Gerente> findById(Long gerenteId);

    Optional<Gerente> findByNomeCompleto(String nomeCompletoDoGerente);

    Optional<Gerente> findByProdutoId(Long produtoId);

    Page<Gerente> findAll(Pageable pageable);

    Page<Gerente> findByGruposDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

    Gerente save(Gerente gerente);

    void deleteById(Long gerenteId);
}
