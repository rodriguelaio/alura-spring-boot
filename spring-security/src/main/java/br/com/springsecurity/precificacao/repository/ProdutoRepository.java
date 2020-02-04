package br.com.springsecurity.precificacao.repository;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.GrupoDeProduto;
import br.com.springsecurity.precificacao.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nome);

    List<Produto> findByTipo(TipoDeProdutos tipoDeProduto);

    List<Produto> findByGrupo(GrupoDeProduto grupoDeProduto);

}
