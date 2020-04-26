package br.com.springsecurity.precificacao.controllers;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import br.com.springsecurity.precificacao.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/id/{produtoId}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long produtoId){
        return ResponseEntity.ok(produtoService.findById(produtoId));
    }

    @GetMapping("/nome/{nomeDoProduto}")
    public ResponseEntity<Optional<Produto>> findByNome(@PathVariable String nomeDoProduto){
        return ResponseEntity.ok(produtoService.findByNome(nomeDoProduto));
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> findAll(Pageable pageable){
        return ResponseEntity.ok(produtoService.findAll(pageable));
    }

    @GetMapping("/tipo/{tipoDeProdutos}")
    public ResponseEntity<Page<Produto>> findByTipoDeProduto(Pageable pageable,
                                                             @PathVariable TipoDeProdutos tipoDeProdutos){
        return ResponseEntity.ok(produtoService.findByTipoDeProdutos(pageable, tipoDeProdutos));
    }

    @GetMapping("grupoDeProdutosId/{grupoDeProdutosId}")
    public ResponseEntity<Page<Produto>> findByGrupoDeProdutosId(Pageable pageable,
                                                                 @PathVariable Long grupoDeProdutosId){
        return ResponseEntity.ok(produtoService.findByGrupoDeProdutosId(pageable, grupoDeProdutosId));
    }

    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @DeleteMapping("/id/{produtoId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long produtoId){
        produtoService.deleteById(produtoId);
        return ResponseEntity.noContent().build();
    }
}
