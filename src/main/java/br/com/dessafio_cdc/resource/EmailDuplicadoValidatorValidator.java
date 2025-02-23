package br.com.dessafio_cdc.resource;

import br.com.dessafio_cdc.dto.AutorRequest;
import br.com.dessafio_cdc.respository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailDuplicadoValidatorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequest request = (AutorRequest) target;
        boolean isExisteEmailCadastrado = autorRepo.existsByEmail(request.getEmail());

        if(isExisteEmailCadastrado) {
            errors.rejectValue("email", null, "Email já cadastrado no sistema!");
        }
    }
}
