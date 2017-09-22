package com.beca.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.beca.interfaz.IOperacionDB;

public class BecaConJdbc {
	
	private static final String usr = "beca";
	private static final String pass = "beca";
	private static final String ip = "localhost";//"192.168.100.109";
	private Connection con;
	
	public void connectar(){
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@" + ip + ":1521:xe", usr, pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void operacion(IOperacionDB odb, String sentencia){
		
		connectar();
		
		try {
			
			odb.sentencia(sentencia, con);
			
		} catch (SQLException e) {
			desconectar();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
	
	public void desconectar(){
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}