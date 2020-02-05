package br.com.springsecurity.precificacao.repositories;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    Optional<Gerente> findByNome(String nome);

    Optional<Gerente> findByProdutoId(Long produtoId);

    Page<Gerente> findByGrupoDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

    void deleteById(Long id);

}
