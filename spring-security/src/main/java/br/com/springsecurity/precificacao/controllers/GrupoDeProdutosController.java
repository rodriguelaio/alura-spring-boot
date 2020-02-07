package br.com.springsecurity.precificacao.controllers;

import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.services.GrupoDeProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/gruposDeProdutos")
public class GrupoDeProdutosController {

    private final GrupoDeProdutosService grupoDeProdutosService;

    @Autowired
    public GrupoDeProdutosController(GrupoDeProdutosService grupoDeProdutosService){
        this.grupoDeProdutosService = grupoDeProdutosService;
    }

    @GetMapping("/id/{grupoDeProdutosId}")
    public ResponseEntity<Optional<GrupoDeProdutos>> findById(@PathVariable Long grupoDeProdutosId){
        return ResponseEntity.ok(grupoDeProdutosService.findById(grupoDeProdutosId));
    }

    @GetMapping
    public ResponseEntity<Page<GrupoDeProdutos>> findAll(Pageable pageable){
        return ResponseEntity.ok(grupoDeProdutosService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<GrupoDeProdutos> save(@Valid @RequestBody GrupoDeProdutos grupoDeProdutos){
        return ResponseEntity.status(HttpStatus.CREATED).body(grupoDeProdutosService.save(grupoDeProdutos));
    }

    @DeleteMapping("/id/{grupoDeProdutosId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long grupoDeProdutosId){
        grupoDeProdutosService.deleteById(grupoDeProdutosId);
        return ResponseEntity.noContent().build();
    }
}
