package br.com.springsecurity.precificacao.repositories;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nomeDoProduto);

    //utilizar sempre o nome exato do atributo. Dessa forma o JPA ja cria as devidas amarrações
    Page<Produto> findByTipoDeProdutos(Pageable pageable, TipoDeProdutos tipoDeProduto);

    Page<Produto> findByGrupoDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

}