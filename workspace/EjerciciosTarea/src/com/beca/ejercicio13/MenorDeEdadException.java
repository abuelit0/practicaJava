package com.beca.ejercicio13;

import com.beca.ejercicio13.interfaz.IEdadExceptions;

public class MenorDeEdadException extends Exception implements IEdadExceptions{
	
	private Persona _responsable;
	
	public MenorDeEdadException(Persona responsable) {
		this._responsable = responsable.getPadre();
	}

	@Override
	public String llamadaDeAtencion() {
		// TODO Auto-generated method stub
		return "No deberias estar aqui sin tus papas niño!";
	}

	@Override
	public Persona reporte() {
		// TODO Auto-generated method stub
		return _responsable;
	}

}
