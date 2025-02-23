package br.com.dessafio_cdc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@Table(name = "autor")
public class Autor {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Email
    private String email;

    @Column(nullable = false, length = 400)
    private String descricao;

    @Column(nullable = false)
    private Instant dataIn;




}
