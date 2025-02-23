package br.com.dessafio_cdc.model;

import br.com.dessafio_cdc.model.dto.CategoriaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Categoria(CategoriaRequest categoriaRequest) {
        this.nome = categoriaRequest.getNome();
    }
}
