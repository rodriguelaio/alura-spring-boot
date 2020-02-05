package br.com.springsecurity.precificacao.models;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private TipoDeProdutos tipoDeProdutos;

    @NotBlank
    @ManyToOne
    private GrupoDeProdutos grupoDeProdutos;

    @JsonIgnore
    public boolean isGrupoDeProdutosEmpty(){
        return this.grupoDeProdutos.equals(null);
    }

    public void setIdAsNull() {
        this.id = null;
    }
}
