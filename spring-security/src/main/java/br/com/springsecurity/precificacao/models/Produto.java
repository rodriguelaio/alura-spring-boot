package br.com.springsecurity.precificacao.models;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Produto implements Serializable {

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
        return this.grupoDeProdutos == null;
    }

    public void setIdAsNull() {
        this.id = null;
    }
}
