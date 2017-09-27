package mx.isban.ejemplo.modulo1.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

public class Usuario {
	
	@Pattern(regexp="[\\p{Alpha}]+[ ]*[\\p{Alpha}]+",message="Error de validación")
	private String nombre;
	
	private long saldo;
	
	@AssertTrue
	private boolean cliente;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

}
