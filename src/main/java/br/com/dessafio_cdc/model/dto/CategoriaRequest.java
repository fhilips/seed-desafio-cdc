package br.com.dessafio_cdc.model.dto;

import br.com.dessafio_cdc.error.UniqueValue;
import br.com.dessafio_cdc.model.Categoria;
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
public class CategoriaRequest {

    @NotBlank
    @UniqueValue(entityClass = Categoria.class, message = "Mais de uma categoria com o mesmo nome", fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this);
    }
}
