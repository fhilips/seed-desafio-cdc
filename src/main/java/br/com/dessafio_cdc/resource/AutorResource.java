package br.com.dessafio_cdc.resource;

import br.com.dessafio_cdc.dto.AutorRequest;
import br.com.dessafio_cdc.model.Autor;
import br.com.dessafio_cdc.respository.AutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("autor")
@RequiredArgsConstructor
public class AutorResource {

    private final AutorRepository autorRepo;

    @PostMapping(value = "/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toAutor();
        autorRepo.save(autor);

        return ResponseEntity.ok().build();
    }
}
