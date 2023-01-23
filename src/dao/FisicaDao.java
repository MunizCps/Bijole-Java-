package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;
import bean.Fisica;


public class FisicaDao {
	//Conexãoo
	private Connection connection;
	
	public FisicaDao(){
		connection = new FabricaConexoes().getConnection();
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Inserir
	public int inserir(Fisica f) {
		int inseriu=0;
		
		String sql="INSERT INTO Fisica(CPF, codigo) VALUES (?,?);";
		//String sqll = "INSERT INTO TelefoneCliente(codigoClie, telefonesClie) VALUES(?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		
		stmt.setString(1,f.getCPF());
		stmt.setInt(2, f.getCodigo());
		
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	/*------------------------------------------------------------------------------------------------*/
	
	//Get lista
	public ArrayList<Fisica> getLista(){
		String sql = "Select * from Fisica;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Fisica> fisica = new ArrayList<>();
			Fisica f;
			while(rs.next()) {
				f = new Fisica(sql, 0);
				f.setCPF(rs.getString("CPF"));
				f.setCodigo(rs.getInt("Codigo"));
				
				
				fisica.add(f);
			}
			rs.close();
			stmt.close();
			return fisica;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Remover
	public int remover(Fisica f) {
		
			int removeu=0;
			String sql="DELETE FROM Fisica WHERE codigo= ?;";
			PreparedStatement stmt;

			try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, f.getCodigo());
			removeu=stmt.executeUpdate();

			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
			return removeu;
			
	}
	
	public Cliente RemoveFisica(int codigo) {
		Cliente c = null;
		int removeu = 0;
		String sql = "DELETE FROM Fisica WHERE codigo= ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			removeu=stmt.executeUpdate();
			System.out.println(codigo);
			
			stmt.close();
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Update
	public int update (Fisica f) {
		int update = 0;
		
		String sql = "UPDATE Fisica SET CPF =? WHERE codigo = ?;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, f.getCPF());
			stmt.setInt(2, f.getCodigo());
			
			
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		
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
