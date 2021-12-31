package api.rest.diccionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6945249371810756182L;

    public ResourceNotFoundException(String resource) {
    	super("El registro " + resource + " no ha sido encontrado.");
    }

}
