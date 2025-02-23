package br.com.dessafio_cdc.model.dto;

import br.com.dessafio_cdc.error.UniqueValue;
import br.com.dessafio_cdc.model.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorRequest {

    @UniqueValue(entityClass = Autor.class, message = "Mais de um autor com o mesmo nome", fieldName = "nome")
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
