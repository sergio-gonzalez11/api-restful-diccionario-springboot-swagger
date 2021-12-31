package api.rest.diccionario.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.rest.diccionario.dto.DiccionarioDTO;
import api.rest.diccionario.exception.ResourceAccessException;
import api.rest.diccionario.handler.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Api-Rest-Pública Diccionario")
@RestController
@RequestMapping(value = "/diccionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiccionarioResource {

	final static String url = "https://api.dictionaryapi.dev/api/v2/entries/es";

	@Autowired
	private RestTemplate restTemplate;


	@ApiOperation(value = "Buscador de palabras en el diccionario")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK", response = DiccionarioDTO.class),
			@ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class) 
	})
	@GetMapping(value = "/{palabra}")
	public ResponseEntity<DiccionarioDTO> findById(@PathVariable("palabra") String palabra) throws ResourceAccessException {

		DiccionarioDTO dto = null;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccessControlAllowOrigin("*");

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<DiccionarioDTO[]> response = restTemplate.exchange(url + "/{word}/",
				HttpMethod.GET, entity, DiccionarioDTO[].class, palabra);

		dto = response.getBody()[0];

		return new ResponseEntity<DiccionarioDTO>(dto, HttpStatus.OK);
	}

}
