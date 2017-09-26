package com.beca.interfaz;

import java.sql.Connection;
import java.sql.SQLException;

public interface IOperacionDB {
	public int sentencia(String s, Connection con) throws SQLException;
}
