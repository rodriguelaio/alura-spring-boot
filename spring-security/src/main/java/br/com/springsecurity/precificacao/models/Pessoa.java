package br.com.springsecurity.precificacao.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public class Pessoa implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotBlank
    private String nomeCompleto;

    public void setNewId(Long newId) {
        this.id = newId;
    }
}
