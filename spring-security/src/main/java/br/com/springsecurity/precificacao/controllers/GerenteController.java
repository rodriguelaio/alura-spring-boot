package br.com.springsecurity.precificacao.controllers;

import br.com.springsecurity.precificacao.models.Gerente;
import br.com.springsecurity.precificacao.services.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Page<Gerente>> findAll(@PageableDefault(sort = "id",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 24) Pageable pageable){
        return ResponseEntity.ok(gerenteService.findAll(pageable));
    }

    @GetMapping("/id/{gerenteId}")
    public ResponseEntity<Optional<Gerente>> findById(@PathVariable Long gerenteId){
        return ResponseEntity.ok(gerenteService.findById(gerenteId));
    }

    @GetMapping("/nomeCompleto/{nomeCompletoDoGerente}")
    public ResponseEntity<Optional<Gerente>> findByNomeCompleto(@PathVariable String nomeCompletoDoGerente){
        return ResponseEntity.ok(gerenteService.findByNomeCompleto(nomeCompletoDoGerente));
    }

    @GetMapping("/produtoId/{produtoId}")
    public ResponseEntity<Optional<Gerente>> findByProdutoId(@PathVariable Long produtoId){
        return ResponseEntity.ok(gerenteService.findByProdutoId(produtoId));
    }

    @GetMapping("/grupoDeProdutosId/{grupoDeProdutosId}")
    public ResponseEntity<Page<Gerente>> findByGruposDeProdutosId(Pageable pageable,
                                                                  @PathVariable Long grupoDeProdutosId){
        return ResponseEntity.ok(gerenteService.findByGruposDeProdutosId(pageable, grupoDeProdutosId));
    }

    @PostMapping
    public ResponseEntity<Gerente> save(@Valid @RequestBody Gerente gerente){
        return ResponseEntity.status(HttpStatus.CREATED).body(gerenteService.save(gerente));
    }

    @DeleteMapping("id/{gerenteId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long gerenteId){
        gerenteService.deleteById(gerenteId);
        return ResponseEntity.noContent().build();
    }
}
