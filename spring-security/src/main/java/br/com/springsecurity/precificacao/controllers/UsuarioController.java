package br.com.springsecurity.precificacao.controllers;

import br.com.springsecurity.precificacao.models.Usuario;
import br.com.springsecurity.precificacao.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/id/{usuarioId}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long usuarioId){
        return ResponseEntity.ok(usuarioService.findById(usuarioId));
    }

    @GetMapping("/nomeCompleto/{nomeCompletoDoUsuario}")
    public ResponseEntity<Optional<Usuario>> findByNomeCompleto(@PathVariable String nomeCompletoDoUsuario){
        return ResponseEntity.ok(usuarioService.findByNomeCompleto(nomeCompletoDoUsuario));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<Usuario>> findByUsername(@PathVariable String username){
        return ResponseEntity.ok(usuarioService.findByUsername(username));
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> findAll(Pageable pageable){
        return ResponseEntity.ok(usuarioService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @PathVariable Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @DeleteMapping("/id/{idDoUsuario}")
    public ResponseEntity<Void> deleteById(@PathVariable Long usuarioId){
        usuarioService.deleteById(usuarioId);
        return ResponseEntity.noContent().build();
    }
}
