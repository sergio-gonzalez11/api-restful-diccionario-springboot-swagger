package api.rest.diccionario.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignificadoDTO {

	@JsonAlias("partOfSpeech")
	private String descripcion;
	
	@JsonAlias("definitions")
	private List<DefinicionDTO> definiciones;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<DefinicionDTO> getDefiniciones() {
		return definiciones;
	}

	public void setDefiniciones(List<DefinicionDTO> definiciones) {
		this.definiciones = definiciones;
	}

}
