package com.beca.interfaz;

import java.sql.Connection;
import java.sql.SQLException;

public interface IFuncionesDB {
	public int sentencia(Connection con, String funcion, String ... strings ) throws SQLException;
}