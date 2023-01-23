package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;
import bean.Juridica;
import bean.Salao;

public class JuridicaDao {
	//Conexão
	private Connection connection;
	
	public JuridicaDao(){
		connection = new FabricaConexoes().getConnection();
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Inserir
	public int inserir(Juridica j) {
		int inseriu=0;
		
		String sql="INSERT INTO Juridica(CNPJ, codigo) VALUES (?,?);";
		//String sqll = "INSERT INTO TelefoneCliente(codigoClie, telefonesClie) VALUES(?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		
		stmt.setString(1,j.getCNPJ());
		stmt.setInt(2, j.getCodigo());
		
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	/*------------------------------------------------------------------------------------------------*/
	
	//Get lista
	public ArrayList<Juridica> getLista(){
		String sql = "Select * from Juridica;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Juridica> juridica = new ArrayList<>();
			Juridica j;
			while(rs.next()) {
				j = new Juridica(sql, 0);
				j.setCNPJ(rs.getString("CNPJ"));
				j.setCodigo(rs.getInt("Codigo"));
				
				
				juridica.add(j);
			}
			rs.close();
			stmt.close();
			return juridica;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Remover
	public int remover(Juridica j) {
		
			int removeu=0;
			String sql="DELETE FROM Juridica WHERE codigo= ?;";
			PreparedStatement stmt;

			try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, j.getCodigo());
			removeu=stmt.executeUpdate();

			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
			return removeu;
			
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Update
	public int update (Juridica j) {
		int update = 0;
		
		String sql = "UPDATE Juridica SET CNPJ =? WHERE codigo = ?;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, j.getCNPJ());
			System.out.println(j.getCNPJ());
			stmt.setInt(2, j.getCodigo());
			System.out.println(j.getCodigo());
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		System.out.println(update);
		return update;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Funções extras que provavelmente não vou usar(Porém vou guardar para caso eu precise)
	
	/*while (c.getTelefones().size() > 0){
	for(int i =0; i <c.getTelefones().size();i++) {
		 c.getTel = c.getTelefones().get(i);
		
		System.out.println(c.getTel);
		stmt=connection.prepareStatement(sql);
		stmt.setString(1,c.getTel());
		stmt.close();
	}
}*/
	
}
