package br.com.springsecurity.precificacao.services;

import br.com.springsecurity.precificacao.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByUsername(String username);
    Page<Usuario> findAll(Pageable pageable);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
