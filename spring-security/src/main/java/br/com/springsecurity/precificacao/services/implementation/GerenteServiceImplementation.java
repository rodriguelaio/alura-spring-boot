package br.com.springsecurity.precificacao.services.implementation;

import br.com.springsecurity.precificacao.models.Gerente;
import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
import br.com.springsecurity.precificacao.repository.GerenteRepository;
import br.com.springsecurity.precificacao.services.GerenteService;
import br.com.springsecurity.precificacao.services.GrupoDeProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GerenteServiceImplementation implements GerenteService {

    private final GerenteRepository gerenteRepository;
    private final GrupoDeProdutosService grupoDeProdutosService;

    @Autowired
    public GerenteServiceImplementation(GerenteRepository gerenteRepository, GrupoDeProdutosService grupoDeProdutosService){
        this.gerenteRepository = gerenteRepository;
        this.grupoDeProdutosService = grupoDeProdutosService;
    }

    @Override
    public Page<Gerente> findAll(Pageable pageable) {
        return gerenteRepository.findAll(pageable);
    }

    @Override
    public Optional<Gerente> findByNome(String nome) {
        return gerenteRepository.findByNome(nome);
    }

    @Override
    @Transactional
    public Gerente save(Gerente gerente) {
        gerente.setIdAsNull();
        validarGruposDeProduto(gerente);
        return gerenteRepository.save(gerente);
    }

    @Override
    public void deleteById(Long id) {
        gerenteRepository.deleteById(id);
    }

    private void validarGruposDeProduto(Gerente gerente){
        if (gerente.isGruposDeProdutoEmpty()) return;
        percorrerListaDeGruposDeProduto(gerente);
    }

    private void percorrerListaDeGruposDeProduto(Gerente gerente){
        List<GrupoDeProdutos> listaDeGruposDeProdutos = new ArrayList<>();
        for(GrupoDeProdutos grupoDeProdutos : gerente.getGruposDeProduto()){
            listaDeGruposDeProdutos.add(validarSeGrupoDeProdutosFoiPersistido(grupoDeProdutos));
        }
        gerente.setGruposDeProduto(listaDeGruposDeProdutos);
    }

    private GrupoDeProdutos validarSeGrupoDeProdutosFoiPersistido(GrupoDeProdutos grupoDeProdutos){
        if(this.grupoDeProdutosService.findById(grupoDeProdutos.getId()).isPresent()){
            return this.grupoDeProdutosService.findById(grupoDeProdutos.getId()).get();
        }
        return this.grupoDeProdutosService.save(grupoDeProdutos);
    }
}
