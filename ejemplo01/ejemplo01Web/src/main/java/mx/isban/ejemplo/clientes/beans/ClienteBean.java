package mx.isban.ejemplo.clientes.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


public class ClienteBean {


	@NotNull
	@Size(min=8, max=8)
	private String codigo;

	@NotNull
	@Size(min=1, max=40)
	private String nombre;

	@NotNull
	@Size(min=1, max=40)
	private String apellido;

	@NotNull
	@Range(min=18, max=99)
	private String edad;

	@NotNull
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;

	@NotNull
	@Size(min=2, max=2)
	private String mes;

	@AssertTrue
	private boolean activo;
	
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
