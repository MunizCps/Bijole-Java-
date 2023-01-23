package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cerimonialista;
import bean.Cliente;
import bean.Salao;

public class CerimonialistaDao {

	//Conexão
	private Connection connection;
	
	public CerimonialistaDao() {
		connection = new FabricaConexoes().getConnection();
		
	}
	/*------------------------------------------------------------------------------------------------*/
	//Inserir
	public int inserir(Cerimonialista ce) {
		int inseriu=0;
		
		
		String sql="INSERT INTO Cerimonialista(protocolo,email,cpf,nome) VALUES (?,?,?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		stmt.setInt(1, ce.getProtocolo());
		stmt.setString(2,ce.getEmail());
		stmt.setString(3, ce.getCpf());
		stmt.setString(4,ce.getNome());
		
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		
		
		
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		System.out.println(inseriu);
		return inseriu;
		
		}
	
	public Cerimonialista verificaCerimonialistaSenha(String senha) {
		Cerimonialista c = null;
		String sql = "Select * from Cerimonialista where senha = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, senha);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Cerimonialista();
				c.setNome(rs.getString("nome"));
				c.setSenha(rs.getString("senha"));
				c.setEmail(rs.getString("email"));
				c.setProtocolo(rs.getInt("protocolo"));
				c.setCpf(rs.getString("CPF"));

				
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cerimonialista verificaCerimonialistaTel(int protocolo) {
		Cerimonialista c = null;
		String sql = "Select * from TelefoneCerimonialista where protocoloCeri= ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, protocolo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Cerimonialista();
				c.setProtocolo(rs.getInt("protocoloCeri"));
				c.setTel(rs.getString("telefonesCeri"));
				
				
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int inserirC(Cerimonialista ce) {
		int inseriu=0;
		
		
		String sql="INSERT INTO Cerimonialista(protocolo,email,cpf,nome,senha) VALUES (?,?,?,?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		stmt.setInt(1, ce.getProtocolo());
		stmt.setString(2,ce.getEmail());
		stmt.setString(3, ce.getCpf());
		stmt.setString(4,ce.getNome());
		stmt.setString(5, ce.getSenha());
		
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		
		
		
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		System.out.println(inseriu);
		return inseriu;
		
		}
	
	/*------------------------------------------------------------------------------------------------*/
	//Get lista
	public ArrayList<Cerimonialista> getLista(){
		String sql = "Select * from Cerimonialista";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cerimonialista> cerimonialista = new ArrayList<>();
			Cerimonialista c;
			while(rs.next()) {
				c = new Cerimonialista();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setProtocolo(rs.getInt("protocolo"));
				c.setCpf(rs.getString("CPF"));
				
				
				cerimonialista.add(c);
			}
			rs.close();
			stmt.close();
			return cerimonialista;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	
	/*------------------------------------------------------------------------------------------------*/
	//get tel
	public ArrayList<Cerimonialista> getListaTel(){
		String sql = "Select * from TelefoneCerimonialista";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cerimonialista> cerimonialista = new ArrayList<>();
			Cerimonialista c;
			while(rs.next()) {
				c = new Cerimonialista();
				c.setProtocolo(rs.getInt("protocoloCeri"));
				c.setTel(rs.getString("telefonesCeri"));
				
				
				cerimonialista.add(c);
			}
			rs.close();
			stmt.close();
			return cerimonialista;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	/*------------------------------------------------------------------------------------------------*/
	//Remover
	public int remover(Cerimonialista ce) {
		
			int removeu=0;
			String sql="DELETE FROM Cerimonialista WHERE protocolo= ?;";
			PreparedStatement stmt;

			try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, ce.getProtocolo());
			removeu=stmt.executeUpdate();

			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
			return removeu;
			
	}
	/*------------------------------------------------------------------------------------------------*/
	//Update
	public int update (Cerimonialista ce) {
		int update =0;
		
		String sql = "UPDATE Cerimonialista SET email =?,cpf = ?,nome= ? WHERE protocolo= ?;";
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, ce.getEmail());
			stmt.setString(2, ce.getCpf());
			stmt.setString(3, ce.getNome());
			stmt.setInt(4, ce.getProtocolo());
			
			
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		System.out.println(update);
		return update;
	}
	
	public int updatetel (Cerimonialista ce) {
		int update =0;
		
		String sql = "UPDATE telefonecerimonialista SET telefonesCeri= ? WHERE protocoloCei= ?;";
		PreparedStatement stmt;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, ce.getTel());
			stmt.setInt(2, ce.getProtocolo());
			
			
			update=stmt.executeUpdate();
			
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		System.out.println(update);
		return update;
	}
	/*------------------------------------------------------------------------------------------------*/
	//Get Cerimonialista(Eu quero mostrar o CPF de todas as cerimonialistas que foram a um encontro com um cliente.)
	public ArrayList<Cerimonialista> getCeri() {

		String sql = "select c.CPF from  cerimonialista c where EXISTS(select * from encontro_encontra e where e.protocoloceri = protocolo);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cerimonialista> cerimonialistas = new ArrayList<>();
			Cerimonialista c;
			while (rs.next()) {
				c = new Cerimonialista();
				c.setCpf(rs.getString("CPF"));
				//c.setProtocolo(rs.getInt("protocolo"));
				

				cerimonialistas.add(c);
			}
			rs.close();
			stmt.close();
			return cerimonialistas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	//Insert Telefone
	public int insert(Cerimonialista c) {
		int inseriu=0;
		String sql = "INSERT INTO TelefoneCerimonialista(protocoloCeri , telefonesCeri ) VALUES(?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		stmt.setInt(1, c.getProtocolo());
		stmt.setString(2, c.getTel());
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	
	//Função login
		public Cerimonialista login(int protocolo, String senha) {
			Cerimonialista cy = null;
			String sql = "Select CPF from Cerimonialista where protocolo = ? and senha = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, protocolo);
				stmt.setString(2, senha);
				ResultSet rs = stmt.executeQuery();
				
				
				if (rs.next()) {
					cy = new Cerimonialista();
					cy.setCpf(rs.getString("CPF"));
				}
				rs.close();
				stmt.close();
				return cy;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Cerimonialista RemoveCeri(int protocolo ) {
			Cerimonialista c = null;
			int removeu = 0;
			String sql = "DELETE FROM Cerimonialista WHERE protocolo = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, protocolo );
				removeu=stmt.executeUpdate();
				System.out.println(protocolo );
				
				stmt.close();
				System.out.println(c);
				return c;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		public Cerimonialista RemoveTelceri(int protocoloCeri  ) {
			Cerimonialista c = null;
			int removeu = 0;
			String sql = "DELETE FROM TelefoneCerimonialista WHERE protocoloCeri  = ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, protocoloCeri  );
				removeu=stmt.executeUpdate();
				System.out.println(protocoloCeri  );
				
				stmt.close();
				System.out.println(c);
				return c;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	/*------------------------------------------------------------------------------------------------*/

	//Funções extras que provavelmente não vou usar(Porém vou guardar para caso eu precise)
	
	//Verifica
	/*public Cerimonialista verificaCerimonialista(int protocolo) {
		Cerimonialista c = null;
		String sql = "Select c.CPF  from Cerimonialista c where EXISTS(select * from encontro_encontra e where \r\n"
				+ "e.protocoloceri = c.protocolo);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setInt(1, protocolo);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				c = new Cerimonialista();
				c.setCpf(rs.getString("CPF"));
				c.setProtocolo(rs.getInt("protocolo"));
				

				
			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	
	
	/*------------------------------------------------------------------------------------------------*/
	//Consulta salao(Função do saão que envolve cerimonialista)
	/*public int consultaSalao (Salao s) {
		int update = 0;
		String sql = "select nome, preço,quant_pessoas, num_cadastro,bairro,cep,rua,num from Salao where numcadastro = ? ;";
		PreparedStatement stmt;	
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, s.getNum_cadastro());
		}catch(SQLException e) {
			e.printStackTrace();
			}
		
		return update;
	}*/
	
	/*------------------------------------------------------------------------------------------------*/
	//Telefone
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
