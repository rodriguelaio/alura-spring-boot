package br.com.springsecurity.precificacao.repositories;

import br.com.springsecurity.precificacao.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT COALESCE(MAX(u.id), 0l) + 1l FROM Usuario u")
    Long getUsuarioNewId();

    Optional<Usuario> findByNomeCompleto(String nomeCompletoDoUsuario);

    //utilizar sempre o nome exato do atributo. Dessa forma o JPA ja cria as devidas amarrações
    Optional<Usuario> findByUsername(String username);

    Usuario save(Usuario usuario);

    void deleteById(Long usuarioId);
}
