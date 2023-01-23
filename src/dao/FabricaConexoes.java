package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	//Criando conexão com mysql
	public Connection getConnection() {
		try {
		return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coala_eventos1?useSSL=false", "root", "SEnhacomida1");
		}catch(SQLException e) {
		e.printStackTrace();
		}

		
		return null;
		}
}
