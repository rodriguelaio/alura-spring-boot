package br.com.springsecurity.precificacao.security;

import br.com.springsecurity.precificacao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private UsuarioService usuarioService;

    @Autowired
    public AutenticacaoService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioService.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado!"));
    }
}
