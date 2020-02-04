package br.com.springsecurity.precificacao.services.implementation;

import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.repository.GrupoDeProdutosRepository;
import br.com.springsecurity.precificacao.services.GrupoDeProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrupoDeProdutosServiceImplementation implements GrupoDeProdutosService {

    private final GrupoDeProdutosRepository grupoDeProdutosRepository;

    @Autowired
    public GrupoDeProdutosServiceImplementation(GrupoDeProdutosRepository grupoDeProdutosRepository){
        this.grupoDeProdutosRepository = grupoDeProdutosRepository;
    }

    @Override
    public Optional<GrupoDeProdutos> findById(Long id){
        return this.grupoDeProdutosRepository.findById(id);
    }

    @Override
    public Page<GrupoDeProdutos> findAll(Pageable pageable){
        return this.grupoDeProdutosRepository.findAll(pageable);
    }

    @Override
    public GrupoDeProdutos save(GrupoDeProdutos grupoDeProdutos) {
        return this.grupoDeProdutosRepository.save(grupoDeProdutos);
    }

    @Override
    public void deleteById(Long id) {
        this.grupoDeProdutosRepository.deleteById(id);
    }
}
