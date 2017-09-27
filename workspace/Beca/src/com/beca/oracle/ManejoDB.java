package com.beca.oracle;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import com.beca.interfaz.IEjemplos;
import com.beca.interfaz.IFuncionesDB;
import com.beca.interfaz.IOperacionDB;
import com.beca.oracle.dao.BecaConJdbc;

/**
 * Clase ejemplo para realizar operaciones con base de datos
 * @author HP
 *
 */
public class ManejoDB implements IEjemplos{
	
	@Override
	public void ejecutaEjemplo(String arg) {
		prueba();
	}
	
	private void prueba(){
		BecaConJdbc b = new BecaConJdbc();
		b.operacion(ejemplo, "SELECT * FROM PELICULAS");
	}
	
	public IOperacionDB ejemplo = (s, con) -> {
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(s);
		
		while(rs.next())
			System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		
		return 0;
	};
	
	public IFuncionesDB funcion = (con, s, p) -> {
		
		StringBuilder parametros = new StringBuilder();
		
		for (String parametro : p) {
			parametros.append(parametro);
			parametros.append(",");
		}
		
		
		CallableStatement cstmt = con.prepareCall("{? = call " + s + " (1)}");
		
		cstmt.registerOutParameter(1, Types.VARCHAR);
		
		cstmt.execute();
		
		String nomPel = cstmt.getString(1);
		
		System.out.println(nomPel);
		
		return 0;
	};

}