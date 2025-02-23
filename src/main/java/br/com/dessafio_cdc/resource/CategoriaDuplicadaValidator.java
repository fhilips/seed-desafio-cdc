package br.com.dessafio_cdc.resource;

import br.com.dessafio_cdc.model.dto.AutorRequest;
import br.com.dessafio_cdc.model.dto.CategoriaRequest;
import br.com.dessafio_cdc.respository.AutorRepository;
import br.com.dessafio_cdc.respository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoriaDuplicadaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequest request = (CategoriaRequest) target;
        boolean isExisteNomeCadastrado = categoriaRepository.existsByNome(request.getNome());

        if(isExisteNomeCadastrado) {
            errors.rejectValue("nome", null, "Nome de categoria já existe no sistema!");
        }
    }
}
