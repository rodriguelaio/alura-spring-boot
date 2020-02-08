package br.com.springsecurity.precificacao.repositories;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    @Query("SELECT COALESCE(MAX(g.id), 0l) + 1l FROM Gerente g")
    Long getGerenteMaxId();

    Optional<Gerente> findByNomeCompleto(String nomeCompletoDoGerente);

    //utilizar sempre o nome exato do atributo. Dessa forma o JPA ja cria as devidas amarrações
    Optional<Gerente> findByProdutoId(Long produtoId);

    Page<Gerente> findByGruposDeProdutosId(Pageable pageable, Long grupoDeProdutosId);

    void deleteById(Long gerenteId);
}
