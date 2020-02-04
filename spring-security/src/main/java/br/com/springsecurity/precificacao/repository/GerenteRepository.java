package br.com.springsecurity.precificacao.repository;

import br.com.springsecurity.precificacao.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    Optional<Gerente> findByNome(String nome);

}
