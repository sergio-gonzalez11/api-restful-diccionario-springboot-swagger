package api.rest.diccionario.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiccionarioDTO {

	@JsonAlias("word")
	private String palabra;

	@JsonAlias("origin")
	private String origen;

	@JsonAlias("meanings")
	private List<SignificadoDTO> significados;

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public List<SignificadoDTO> getSignificados() {
		return significados;
	}

	public void setSignificados(List<SignificadoDTO> significados) {
		this.significados = significados;
	}

}
