package br.com.springsecurity.precificacao.services.implementation;

import br.com.springsecurity.precificacao.models.Usuario;
import br.com.springsecurity.precificacao.repositories.UsuarioRepository;
import br.com.springsecurity.precificacao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> findById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    @Override
    public Optional<Usuario> findByNomeCompleto(String nomeCompletoDoUsuario) {
        return usuarioRepository.findByNomeCompleto(nomeCompletoDoUsuario);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
