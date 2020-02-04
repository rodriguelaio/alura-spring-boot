package br.com.springsecurity.precificacao.repository;

import br.com.springsecurity.precificacao.models.GrupoDeProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoDeProdutoRepository extends JpaRepository<GrupoDeProduto, Long> {

    Optional<GrupoDeProduto> findByNome(String nome);

}
