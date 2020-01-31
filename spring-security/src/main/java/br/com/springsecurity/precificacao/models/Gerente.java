package br.com.springsecurity.precificacao.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Gerente extends Pessoa{

    @OneToMany
    private List<Produto> produto;

    @ManyToMany
    @JoinTable(name = "gerente_grupo_de_produto", //nome da tabela que receberá a relação entre gerente x grupo
            joinColumns = @JoinColumn(name = "id_gerente"), //nome da coluna de dominio da relação
            inverseJoinColumns = @JoinColumn(name = "id_grupo_de_produto")) //nome da coluna dominada da relação
    private List<GrupoDeProduto> grupoDeProduto;

}
