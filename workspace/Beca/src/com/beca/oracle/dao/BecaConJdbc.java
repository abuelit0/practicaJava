package com.beca.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.beca.interfaz.IOperacionDB;

/**
 * Clase para realizar conexion a base de datos
 * @author HP
 *
 */
public class BecaConJdbc {
	
	private static final String USR = "beca";
	private static final String PASS = "beca";
	private static final String IP = "localhost";
	private Connection con;

	private void connectar(){
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + IP + ":1521:xe", USR, PASS);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Clase para realizar operaciones especificas en la base de datos
	 * @param odb
	 * @param sentencia
	 */
	public void operacion(IOperacionDB odb, String sentencia){
		
		connectar();
		
		try {
			odb.sentencia(sentencia, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			desconectar();
		}
	}
	
	private void desconectar(){
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			desconectar();
		}
	}
}
