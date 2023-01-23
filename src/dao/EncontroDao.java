package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cliente;
import bean.Encontro;
import bean.ListaDeDesejos;

public class EncontroDao {
	
	//Conexão
	private Connection connection;
	public EncontroDao(){
		connection = new FabricaConexoes().getConnection();
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Inserir
	public int inserir(Encontro ee) {
		int inseriu=0;
		
		String sql="INSERT INTO Encontro_encontra(data,hora,codigoclie,protocoloceri,numcadastro) VALUES (?,?,?,?,?);";
	
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		
		stmt.setString(1,ee.getData());
		stmt.setString(2, ee.getHora());
		stmt.setInt(3,ee.getCodigoclie());
		stmt.setInt(4, ee.getProtocoloceri());
		stmt.setInt(5, ee.getNumcadastro());
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	/*------------------------------------------------------------------------------------------------*/
	
	public int inserir2(Encontro e) {
		int inseriu=0;
		
		String sql="INSERT INTO Encontro_encontra(data,hora,codigoclie,protocoloceri) VALUES (?,?,?,?);";
	
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		
		stmt.setString(1,e.getData());
		stmt.setString(2, e.getHora());
		stmt.setInt(3,e.getCodigoclie());
		stmt.setInt(4, e.getProtocoloceri());
		
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException ee) {
		ee.printStackTrace();
		}
		return inseriu;
		}
	/*------------------------------------------------------------------------------------------------*/
	public Encontro InserirEncontro(int codigoClie, int protocoloceri, String data, String hora) {
		Encontro c = null;
		int inseriu = 0;
		String sql = "INSERT INTO Encontro_encontra(data,hora,codigoclie,protocoloceri) VALUES (?,?,?,?);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,c.getData());
			stmt.setString(2, c.getHora());
			stmt.setInt(3,c.getCodigoclie());
			stmt.setInt(4, c.getProtocoloceri());
			
			inseriu=stmt.executeUpdate();
			System.out.println(codigoClie);
			
			stmt.close();
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*------------------------------------------------------------------------------------------------*/
	
	//Get lista
	public ArrayList<Encontro> getLista(){
		String sql = "Select * from Encontro";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Encontro> encontros = new ArrayList<>();
			Encontro ee;
			while(rs.next()) {
				ee = new Encontro();
				ee.setCodigoclie (rs.getInt("codigoclie"));
				ee.setProtocoloceri (rs.getInt("protocoloceri"));
				ee.setNumcadastro (rs.getInt("numcadastro "));
				ee.setData(rs.getString("data"));
				ee.setHora(rs.getString("hora"));
				
				
				encontros.add(ee);
			}
			rs.close();
			stmt.close();
			return encontros;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	/*------------------------------------------------------------------------------------------------*/
		
	//Remover
	}
	public int remover(Encontro ee) {
		
			int removeu=0;
			String sql="DELETE FROM Encontro_encontra WHERE codigoclie= ?;";
			PreparedStatement stmt;

			try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, ee.getCodigoclie());
			removeu=stmt.executeUpdate();

			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
			return removeu;
			
	}
	
	public Encontro RemoveEncontro(int codigoClie) {
		Encontro c = null;
		int removeu = 0;
		String sql = "DELETE FROM Encontro_encontra WHERE codigoClie= ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigoClie);
			removeu=stmt.executeUpdate();
			System.out.println(codigoClie);
			
			stmt.close();
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Encontro RemoveEncontroCeri(int protocoloCeri) {
		Encontro c = null;
		int removeu = 0;
		String sql = "DELETE FROM Encontro_encontra WHERE protocoloCeri = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, protocoloCeri);
			removeu=stmt.executeUpdate();
			System.out.println(removeu + "aaaaaaaaaaa");
			System.out.println(protocoloCeri);
			
			stmt.close();
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Encontro RemoveEncontroS(int numcadastro) {
		Encontro c = null;
		int removeu = 0;
		String sql = "DELETE FROM Encontro_encontra WHERE numcadastro= ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, numcadastro);
			removeu=stmt.executeUpdate();
			System.out.println(numcadastro);
			
			stmt.close();
			System.out.println(c);
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*------------------------------------------------------------------------------------------------*/
	public Encontro verificaEncontroSenha(String senha) {
		Encontro c = null;
		String sql = "Select * from Encontro_encontra where protocoloceri = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, senha);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Encontro();
				c.setCodigoclie(rs.getInt("codigoclie"));
				c.setProtocoloceri (rs.getInt("protocoloceri"));
				c.setData(rs.getString("data"));
				c.setHora(rs.getString("hora"));
				

				
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//Update
	public int update (Encontro ee) {
		int update =0;
		
		String sql = "UPDATE Encontro_encontra SET data =?,hora = ?,codigoclie= ?,protocoloceri = ?,numeroCadastroSa=? WHERE codigoclie = ?;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, ee.getData());
			stmt.setString(2, ee.getHora());
			stmt.setInt(3, ee.getCodigoclie());
			stmt.setInt(4, ee.getProtocoloceri());
			stmt.setInt(5, ee.getNumcadastro());
			
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		return update;
	}
	
	
	public int update2 (Encontro ee) {
		int update =0;
		
		String sql = "UPDATE Encontro_encontra SET numCadastro=? WHERE protocoloceri= ? and data=? and hora=? and numCadastro is null;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, ee.getNumcadastro());
			stmt.setInt(2, ee.getProtocoloceri());
			stmt.setString(3, ee.getData());
			stmt.setString(4, ee.getHora());
			
		
			
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		
		return update;
	}
	
	
	public int update3 (Encontro ee) {
		int update =0;
		
		String sql = "UPDATE Encontro_encontra SET numCadastro=null WHERE protocoloceri= ?;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, ee.getProtocoloceri());
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
