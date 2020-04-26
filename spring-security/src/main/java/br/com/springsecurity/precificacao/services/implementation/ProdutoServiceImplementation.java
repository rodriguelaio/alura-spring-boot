package br.com.springsecurity.precificacao.services.implementation;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.models.Produto;
import br.com.springsecurity.precificacao.repositories.ProdutoRepository;
import br.com.springsecurity.precificacao.services.GrupoDeProdutosService;
import br.com.springsecurity.precificacao.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoServiceImplementation implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final GrupoDeProdutosService grupoDeProdutosService;

    @Autowired
    public ProdutoServiceImplementation(ProdutoRepository produtoRepository, GrupoDeProdutosService grupoDeProdutosService){
        this.produtoRepository = produtoRepository;
        this.grupoDeProdutosService = grupoDeProdutosService;
    }

    @Override
    public Optional<Produto> findById(Long produtoId) {
        return produtoRepository.findById(produtoId);
    }

    @Override
    public Optional<Produto> findByNome(String nomeDoProduto) {
        return produtoRepository.findByNome(nomeDoProduto);
    }

    @Override
    public Page<Produto> findByTipoDeProdutos(Pageable pageable, TipoDeProdutos tipoDeProdutos) {
        return produtoRepository.findByTipoDeProdutos(pageable, tipoDeProdutos);
    }

    @Override
    public Page<Produto> findByGrupoDeProdutosId(Pageable pageable, Long grupoDeProdutosId) {
        return produtoRepository.findByGrupoDeProdutosId(pageable, grupoDeProdutosId);
    }

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Produto save(Produto produto) {
        produto.setIdAsNull();
        validarGruposDeProduto(produto);
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public void deleteById(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    private void validarGruposDeProduto(Produto produto){
        if (produto.isGrupoDeProdutosEmpty()) return;
        validarSeGrupoDeProdutosFoiPersistido(produto.getGrupoDeProdutos());
    }

    private GrupoDeProdutos validarSeGrupoDeProdutosFoiPersistido(GrupoDeProdutos grupoDeProdutos){
        if(grupoDeProdutosService.findById(grupoDeProdutos.getId()).isPresent()){
            return grupoDeProdutosService.findById(grupoDeProdutos.getId()).get();
        }
        return grupoDeProdutosService.save(grupoDeProdutos);
    }
}
