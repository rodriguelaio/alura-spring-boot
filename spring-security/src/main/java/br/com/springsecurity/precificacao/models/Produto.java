package br.com.springsecurity.precificacao.models;

import br.com.springsecurity.precificacao.enums.TipoDeProdutos;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private GrupoDeProdutos grupoDeProdutos;
}
