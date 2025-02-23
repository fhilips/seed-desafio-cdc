package br.com.dessafio_cdc.resource;

import br.com.dessafio_cdc.model.Categoria;
import br.com.dessafio_cdc.model.dto.CategoriaRequest;
import br.com.dessafio_cdc.respository.CategoriaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaResource {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @PostMapping(value = "/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@Valid @RequestBody CategoriaRequest request){
        Categoria categoria = request.toCategoria();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
