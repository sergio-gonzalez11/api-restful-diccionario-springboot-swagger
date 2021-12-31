package api.rest.diccionario.handler;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Api-Error") 
public class ApiError {

	@NotNull
	@ApiModelProperty(value = "Estado del error Http")
	private HttpStatus status;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	@ApiModelProperty(value = "Fecha en la que se produce el error")
	private Date fecha = new Date();

	@NotNull
	@ApiModelProperty(value = "Mensaje identificativo del error")
	private String mensaje;

	@NotNull
	@ApiModelProperty(value = "Descripción de la ruta Uri")
	private String descripcion;

	@NotNull
	@ApiModelProperty(value = "Identificación de sesión especificada por el cliente")
	private String sesionId;

	public ApiError() {
		super();
	}

	public ApiError(@NotNull HttpStatus status, Date fecha, @NotNull String mensaje, @NotNull String descripcion,
			@NotNull String sesionId) {
		super();
		this.status = status;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
		this.sesionId = sesionId;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSesionId() {
		return sesionId;
	}

	public void setSesionId(String sesionId) {
		this.sesionId = sesionId;
	}

}
