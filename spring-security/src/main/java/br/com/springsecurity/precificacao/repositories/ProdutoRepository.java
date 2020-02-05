package br.com.springsecurity.precificacao.repositories;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nome);

    Page<Optional<Produto>> findByTipo(Pageable pageable, TipoDeProdutos tipoDeProduto);

    Page<Optional<Produto>> findByGrupo(Pageable pageable, GrupoDeProdutos grupoDeProdutos);

}