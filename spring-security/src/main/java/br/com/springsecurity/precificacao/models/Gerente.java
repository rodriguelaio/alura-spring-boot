package br.com.springsecurity.precificacao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Gerente extends Pessoa{

    @OneToMany
    @JoinColumn(name = "gerente_id") //Desse modo, o hibernate não cria uma tabela intermediária para a amarração...
    private List<Produto> produto; //...mas insere na tabela filha um campo que receberá o código pai

    @ManyToMany
    @JoinTable(name = "gerente_grupo_de_produto", //nome da tabela que receberá a relação entre gerente x grupo
            joinColumns = @JoinColumn(name = "gerente_id"), //nome da coluna de dominio da relação
            inverseJoinColumns = @JoinColumn(name = "grupo_de_produto_id")) //nome da coluna dominada da relação
    private List<GrupoDeProdutos> gruposDeProdutos;

    @JsonIgnore
    public boolean isGruposDeProdutosEmpty(){
        return isEmpty(this.gruposDeProdutos);
    }
}
