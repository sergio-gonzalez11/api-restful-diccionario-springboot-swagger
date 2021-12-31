package api.rest.diccionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceAccessException extends RuntimeException {
	private static final long serialVersionUID = -6945249371810756182L;

    public ResourceAccessException() {
    	super("El recurso al que se quiere conectar no contiene datos");
    }
    
    public ResourceAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessException(String message) {
        super(message);
    }

    public ResourceAccessException(Throwable cause) {
        super(cause);
    }
}
