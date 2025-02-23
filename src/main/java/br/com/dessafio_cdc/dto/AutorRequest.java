package br.com.dessafio_cdc.dto;

import br.com.dessafio_cdc.model.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @Size(max = 400)
    private String descricao;

    public Autor toAutor() {
        return new Autor(this);
    }
}
