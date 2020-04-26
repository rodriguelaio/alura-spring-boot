//package br.com.springsecurity.precificacao.utils;
//
//import br.com.springsecurity.precificacao.models.Gerente;
//import br.com.springsecurity.precificacao.models.GrupoDeProdutos;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PersistGrupoDeProdutosAsAttribute {
//
//    public static void persistGrupoDeProdutosAsAttibrute(Class classeGenerica) {
//        validarGruposDeProduto(classeGenerica);
//    }
//
//    private void validarClassePrincipal(Class classeGenerica){
//        try {
//            Method naosei = classeGenerica.getClass().getDeclaredMethod("isGruposDeProdutoEmpty");
//            naosei.;
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void validarGruposDeProduto(Class classePrincipal){
//        if (classePrincipal.getClass().getMethods(). isGruposDeProdutoEmpty()) return;
//        percorrerListaDeGruposDeProduto(gerente);
//    }
//
//    private void percorrerListaDeGruposDeProduto(Gerente gerente){
//        List<GrupoDeProdutos> listaDeGruposDeProdutos = new ArrayList<>();
//        for(GrupoDeProdutos grupoDeProdutos : gerente.getGruposDeProduto()){
//            listaDeGruposDeProdutos.add(validarSeGrupoDeProdutosFoiPersistido(grupoDeProdutos));
//        }
//        gerente.setGruposDeProduto(listaDeGruposDeProdutos);
//    }
//
//    private GrupoDeProdutos validarSeGrupoDeProdutosFoiPersistido(GrupoDeProdutos grupoDeProdutos){
//        if(this.grupoDeProdutosService.findById(grupoDeProdutos.getId()).isPresent()){
//            return this.grupoDeProdutosService.findById(grupoDeProdutos.getId()).get();
//        }
//        return this.grupoDeProdutosService.save(grupoDeProdutos);
//    }
//}
