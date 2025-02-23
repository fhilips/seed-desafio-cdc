package br.com.dessafio_cdc.resource;

import br.com.dessafio_cdc.dto.AutorRequest;
import br.com.dessafio_cdc.model.Autor;
import br.com.dessafio_cdc.respository.AutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorResource {

    @Autowired
    private final AutorRepository autorRepo;

    @Autowired
    private EmailDuplicadoValidatorValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping(value = "/cadastrar")
    @Transactional
    public ResponseEntity<String> cadastrar(@Valid @RequestBody AutorRequest autorRequest){
        Autor autor = autorRequest.toAutor();
        autorRepo.save(autor);
        return ResponseEntity.ok().build();
    }
}
