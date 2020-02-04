package br.com.springsecurity.precificacao.repository;

import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDeProdutosRepository extends JpaRepository<GrupoDeProdutos, Long> {
}
