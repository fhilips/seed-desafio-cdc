package br.com.dessafio_cdc.respository;

import br.com.dessafio_cdc.model.Autor;
import br.com.dessafio_cdc.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(@NotBlank String nome);
}
