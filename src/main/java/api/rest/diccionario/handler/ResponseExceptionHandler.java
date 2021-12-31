package api.rest.diccionario.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import api.rest.diccionario.exception.ResourceAccessException;

public class ResponseExceptionHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		return (response
				.getStatusCode()
				.series() == HttpStatus.Series.CLIENT_ERROR || 
				response
				.getStatusCode()
				.series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {

		if (response.getStatusCode()
				.series() == HttpStatus.Series.SERVER_ERROR) {
		} else if (response.getStatusCode()
				.series() == HttpStatus.Series.CLIENT_ERROR) {
			if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new ResourceAccessException();
			}
		}
	}

}
