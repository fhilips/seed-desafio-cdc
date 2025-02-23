package br.com.dessafio_cdc.model;

import br.com.dessafio_cdc.dto.AutorRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;

    @Column(nullable = false, length = 400)
    private String descricao;

    @Column(nullable = false)
    private Instant dataIn;

    public Autor(AutorRequest autorRequest) {
        this.nome = autorRequest.getNome();
        this.email = autorRequest.getEmail();
        this.descricao = autorRequest.getDescricao();
        this.dataIn = Instant.now();
    }
}
