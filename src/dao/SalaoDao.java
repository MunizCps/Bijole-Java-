package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Cliente;
import bean.Fisica;
import bean.Salao;

public class SalaoDao {
	//Conexão
	private Connection connection;

	public SalaoDao() {
		connection = new FabricaConexoes().getConnection();
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Inserir
	public int inserir(Salao s) {
		int inseriu = 0;

		String sql = "INSERT INTO Salao(nome,preço,quant_pessoas,num_cadastro,bairro,cep,rua,num) VALUES (?,?,?,?,?,?,?,?);";
		String sqll = "INSERT INTO TelefoneCliente(codigoClie, telefonesClie) VALUES(?,?);";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, s.getNome());
			stmt.setDouble(2, s.getPreço());
			stmt.setInt(3, s.getQuant_pessoas());
			stmt.setInt(4, s.getNum_cadastro());
			stmt.setString(5, s.getBairro());
			stmt.setString(6, s.getCep());
			stmt.setString(7, s.getRua());
			stmt.setInt(8, s.getNum());
			inseriu = stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(inseriu);
		return inseriu;
	}

	
	/*------------------------------------------------------------------------------------------------*/
	
	//Get lista
	public ArrayList<Salao> getLista() {

		String sql = "Select * from Salao";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Salao> salaos = new ArrayList<>();
			Salao s;
			while (rs.next()) {
				s = new Salao();
				s.setNome(rs.getString("nome"));
				s.setPreço(rs.getDouble("preço"));
				s.setQuant_pessoas(rs.getInt("quant_pessoas"));
				s.setNum_cadastro(rs.getInt("num_cadastro"));
				s.setBairro(rs.getString("bairro"));
				s.setCep(rs.getString("cep"));
				s.setRua(rs.getString("rua"));
				s.setNum(rs.getInt("num"));

				salaos.add(s);
			}
			rs.close();
			stmt.close();
			return salaos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Verifica Salão(Eu quero os dados salões que tenham capacidade igual a ?(igual a o que a cerimonialista))
	public ArrayList<Salao> verificaSalao(int num_cadastro) {
		Salao s = null;
		ArrayList<Salao> sl = new ArrayList();
		String sql = "Select * from Salao where quant_pessoas  = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, num_cadastro);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				s = new Salao();
				s.setNome(rs.getString("nome"));
				s.setPreço(rs.getDouble("preço"));
				s.setQuant_pessoas(rs.getInt("quant_pessoas"));
				s.setNum_cadastro(rs.getInt("num_cadastro"));
				s.setBairro(rs.getString("bairro"));
				s.setCep(rs.getString("cep"));
				s.setRua(rs.getString("rua"));
				s.setNum(rs.getInt("num"));
				sl.add(s);
				
			}
			rs.close();
			stmt.close();
			return sl;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	/*------------------------------------------------------------------------------------------------*/
	
	//Remover
	public int remover(Salao s) {

		int removeu = 0;
		String sql = "DELETE FROM Salao WHERE num_cadastro= ?;";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, s.getNum_cadastro());
			removeu = stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;

	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Update
	public int update(Salao s) {
		int update = 0;

		String sql = "UPDATE Salao SET nome =?,preço = ?,quant_pessoas= ?,bairro=?,cep=?,rua =?, num = ? WHERE num_cadastro = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getNome());
			stmt.setDouble(2, s.getPreço());
			stmt.setInt(3, s.getQuant_pessoas());
			stmt.setString(4, s.getBairro());
			stmt.setString(5, s.getCep());
			stmt.setString(6, s.getRua());
			stmt.setInt(7, s.getNum());
			stmt.setInt(8, s.getNum_cadastro());

			update = stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(update);

		return update;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Insert telefone
	public int insert(Salao s) {
		int inseriu = 0;

		String sql = "INSERT INTO TelefoneSalao(numcadastroSalao, telefonesSalao ) VALUES(?,?);";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, s.getNum_cadastro());
			stmt.setString(2, s.getTel());
			inseriu = stmt.executeUpdate();
			stmt.close();

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(inseriu);
		return inseriu;
	}
	

	public int consultaSalao(Salao s) {
		int update = 0;
		String sql = "select nome, preço,quant_pessoas, num_cadastro,bairro,cep,rua,num from Salao where numcadastro = ? ;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, s.getNum_cadastro());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return update;
	}
	
	public ArrayList<Salao> getListatel() {

		String sql = "Select * from telefonesalao";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Salao> salaos = new ArrayList<>();
			Salao s;
			while (rs.next()) {
				s = new Salao();
				s.setNum_cadastro(rs.getInt("numcadastroSalao"));
				s.setTel(rs.getString("telefonesSalao"));

				salaos.add(s);
			}
			rs.close();
			stmt.close();
			return salaos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public int updatetel(Salao s) {
		int update = 0;

		String sql = "UPDATE telefonesalao SET telefonesSalao = ? WHERE numcadastroSalao= ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, s.getTel());
			stmt.setInt(2, s.getNum_cadastro());

			update = stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(update);

		return update;
	}

	
	
	
	//Função login
		public Salao login(int num_cadastro, String nome) {
			Salao s = null;
			String sql = "Select num from Salao where num_cadastro = ? and nome = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, num_cadastro);
				stmt.setString(2, nome);
				ResultSet rs = stmt.executeQuery();
				
				
				if (rs.next()) {
					s = new Salao();
					s.setNum(rs.getInt("num"));
				}
				rs.close();
				stmt.close();
				return s;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Salao RemoveS(int num_cadastro ) {
			Salao s = null;
			int removeu = 0;
			String sql = "DELETE FROM Salao WHERE num_cadastro = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, num_cadastro );
				removeu=stmt.executeUpdate();
				System.out.println(num_cadastro );
				
				stmt.close();
				System.out.println(s);
				return s;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Salao RemovetelS(int num_cadastro ) {
			Salao s = null;
			int removeu = 0;
			String sql = "DELETE FROM TelefoneSalao WHERE numcadastroSalao  = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, num_cadastro );
				removeu=stmt.executeUpdate();
				System.out.println(num_cadastro );
				
				stmt.close();
				System.out.println(s);
				return s;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	/*------------------------------------------------------------------------------------------------*/
	
	//Funções extras que provavelmente não vou usar(Porém vou guardar para caso eu precise)
	
	//Telefone
	/*
	 * while (c.getTelefones().size() > 0){ for(int i =0; i
	 * <c.getTelefones().size();i++) { c.getTel = c.getTelefones().get(i);
	 * 
	 * System.out.println(c.getTel); stmt=connection.prepareStatement(sql);
	 * stmt.setString(1,c.getTel()); stmt.close(); } }
	 */
	
	//Verifica salão
	/*String sql = "SELECT * FROM Salao WHERE num_cadastro=?;";
	try {
		PreparedStatement stmt1 = this.connection.prepareStatement(sql);

		stmt1.setInt(1, num_cadastro);
		ResultSet rs = stmt1.executeQuery();
		Salao s = new Salao();

		rs.first();

		s.setNum_cadastro(num_cadastro);
		s.setNome(rs.getString("nome"));
		s.setCep(rs.getString("cep"));
		s.setRua(rs.getString("rua"));
		s.setBairro(rs.getString("bairro"));
		s.setNum(rs.getInt("num"));
		s.setQuant_pessoas(rs.getInt("quant_pessoas"));
		s.setPreço(rs.getDouble("preço"));

		return s;
	}

	catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
}*/
	
	//Insert cliente
	/*
	 * while (c.getTelefones().size() > 0){ for(int i =0; i
	 * <c.getTelefones().size();i++) { c.getTel = c.getTelefones().get(i);
	 * 
	 * System.out.println(c.getTel); stmt=connection.prepareStatement(sql);
	 * stmt.setString(1,c.getTel()); stmt.close(); } }
	 */
	
	//Get lista
	/*
	 * public ArrayList<Salao> getLista(){ String sql =
	 * "SELECT * FROM Salao WHERE num_cadastro=?;"; PreparedStatement stmt; try {
	 * stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery();
	 * ArrayList<Salao> salao = new ArrayList<>(); Salao s; while(rs.next()) { s =
	 * new Salao(); s.setNome(rs.getString("nome"));
	 * s.setPreço(rs.getDouble("preço"));
	 * s.setQuant_pessoas(rs.getInt("quant_pessoas"));
	 * s.setNum_cadastro(rs.getInt("num_cadastro"));
	 * s.setBairro(rs.getString("bairro")); s.setCep(rs.getString("cep"));
	 * s.setRua(rs.getString("rua")); s.setNum(rs.getInt("num"));
	 * 
	 * 
	 * salao.add(s); } rs.close(); stmt.close(); return salao; } catch(SQLException
	 * e) { e.printStackTrace(); } return null;
	 * 
	 * 
	 * }
	 */

}
