package com.beca.ejercicio13;

import com.beca.ejercicio13.interfaz.IEdadExceptions;

public class AdolecenteException extends Exception implements IEdadExceptions{
	
	private Persona _infractor;
	
	public AdolecenteException(Persona infractor) {
		this._infractor = infractor;
	}

	@Override
	public String llamadaDeAtencion() {
		// TODO Auto-generated method stub
		return "Regresa cuando seas mayor jovencito!";
	}

	@Override
	public Persona reporte() {
		// TODO Auto-generated method stub
		return _infractor;
	}

}
