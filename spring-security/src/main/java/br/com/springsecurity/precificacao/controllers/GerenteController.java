package br.com.springsecurity.precificacao.controllers;

import br.com.springsecurity.precificacao.models.Gerente;
import br.com.springsecurity.precificacao.services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    private final GerenteService gerenteService;

    @Autowired
    public GerenteController(GerenteService gerenteService){
        this.gerenteService = gerenteService;
    }

    @GetMapping
    public ResponseEntity<Page<Gerente>> findAll(Pageable pageable){
        return ResponseEntity.ok(gerenteService.findAll(pageable));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Gerente>> findById(Long id){
        return ResponseEntity.ok(gerenteService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Optional<Gerente>> findByNome(String nome){
        return ResponseEntity.ok(gerenteService.findByNome(nome));
    }

    @GetMapping("/produtoId/{produtoId}")
    public ResponseEntity<Optional<Gerente>> findByProdutoId(Long produtoId){
        return ResponseEntity.ok(gerenteService.findByProdutoId(produtoId));
    }

    @GetMapping("/grupoDeProdutosId/{grupoDeProdutosId}")
    public ResponseEntity<Page<Gerente>> findByGruposDeProdutosId(Pageable pageable, Long grupoDeProdutosId){
        return ResponseEntity.ok(gerenteService.findByGruposDeProdutosId(pageable, grupoDeProdutosId));
    }

    @PostMapping
    public ResponseEntity<Gerente> save(Gerente gerente){
        return ResponseEntity.status(HttpStatus.CREATED).body(gerenteService.save(gerente));
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteById(Long id){
        gerenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
