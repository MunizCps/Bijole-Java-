package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cerimonialista;
import bean.Cliente;
import bean.Salao;


public class ClienteDao {
	//Conexão
	private Connection connection;
	
	public ClienteDao(){
		connection = new FabricaConexoes().getConnection();	
	}
	/*------------------------------------------------------------------------------------------------*/	
	
	//Inserir 
	public int inserir(Cliente c) {
		int inseriu=0;
		
		String sql="INSERT INTO Cliente(nome,email,rg,codigo,data_nasc,cep,rua,bairro,num,senha) VALUES (?,?,?,?,?,?,?,?,?,?);";
		String sqll = "INSERT INTO TelefoneCliente(codigoClie, telefonesClie) VALUES(?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		
		
		stmt.setString(1,c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3,c.getRg());
		stmt.setInt(4, c.getCodigo());
		stmt.setString(5, c.getData_nasc());
		stmt.setString(6,c.getCep());
		stmt.setString(7, c.getRua());
		stmt.setString(8, c.getBairro());
		stmt.setInt(9, c.getNum());
		stmt.setString(10, c.getSenha());
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		stmt=connection.prepareStatement(sqll);
		stmt.setInt(1, c.getCodigo());
		
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	/*------------------------------------------------------------------------------------------------*/
	public Cliente verificaClienteTel(int codigo) {
		Cliente c = null;
		String sql = "Select * from TelefoneCliente where codigoClie  = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Cliente();
				c.setCodigo(rs.getInt("codigoClie"));
				c.setTel(rs.getString("telefonesClie"));
				
				clientes.add(c);
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Cliente> getListaTel(){
		String sql = "Select * from TelefoneCliente";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> cliente = new ArrayList<>();
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setCodigo(rs.getInt("codigoClie"));
				c.setTel(rs.getString("telefonesClie"));
				
				
				cliente.add(c);
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	public ArrayList<Cliente> getLista2(){
		String sql = "Select * from Cliente where codigo = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setInt(1, Codigo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setRg(rs.getString("rg"));
				c.setCodigo(rs.getInt("codigo"));
				c.setData_nasc(rs.getString("data_nasc"));
				c.setCep(rs.getString("cep"));
				c.setRua(rs.getString("rua"));
				c.setBairro(rs.getString("bairro"));
				c.setNum(rs.getInt("num"));
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		/*------------------------------------------------------------------------------------------------*/
		
	}
	
		
	//Get lista
	public ArrayList<Cliente> getLista(){
		String sql = "Select * from Cliente";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setRg(rs.getString("rg"));
				c.setCodigo(rs.getInt("codigo"));
				c.setData_nasc(rs.getString("data_nasc"));
				c.setCep(rs.getString("cep"));
				c.setRua(rs.getString("rua"));
				c.setBairro(rs.getString("bairro"));
				c.setNum(rs.getInt("num"));
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		/*------------------------------------------------------------------------------------------------*/
		
		
	}
	public Cliente verificaClienteSenha(String senha) {
		Cliente c = null;
		String sql = "Select * from Cliente where senha = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, senha);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setRg(rs.getString("RG"));
				c.setEmail(rs.getString("email"));
				c.setCodigo(rs.getInt("codigo"));
				c.setRua(rs.getString("rua"));
				c.setBairro(rs.getString("bairro"));
				c.setCep(rs.getString("cep"));
				c.setNum(rs.getInt("num"));
				c.setData_nasc (rs.getString("data_nasc"));

				clientes.add(c);
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	//Verifica Cliente(Eu quero os dados de um cliente cujo o codigo seja ? (com o que a cerimonialista digitar))
	
	public Cliente verificaCliente(int codigo) {
		Cliente c = null;
		String sql = "Select * from Cliente where codigo = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			if (rs.next()) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setRg(rs.getString("RG"));
				c.setEmail(rs.getString("email"));
				c.setRua(rs.getString("rua"));
				c.setBairro(rs.getString("bairro"));
				c.setCep(rs.getString("cep"));
				c.setNum(rs.getInt("num"));
				c.setData_nasc (rs.getString("data_nasc"));

				clientes.add(c);
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Cliente> verificaCliente3(int codigo) {
		Cliente c = null;
		ArrayList<Cliente> cl = new ArrayList();
		String sql = "Select * from Cliente where codigo = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setRg(rs.getString("RG"));
				c.setEmail(rs.getString("email"));
				c.setRua(rs.getString("rua"));
				c.setBairro(rs.getString("bairro"));
				c.setCep(rs.getString("cep"));
				c.setNum(rs.getInt("num"));
				c.setData_nasc (rs.getString("data_nasc"));

				cl.add(c);
			}
			
			rs.close();
			stmt.close();
			return cl;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Get Cliente(Eu quero mostrar o RG de todos os clientes que não possuem telefone.)
	public ArrayList<Cliente> getClie(){
		String sql = "select distinct c.RG from Cliente c, telefoneCliente t where codigo NOT IN(select codigoclie from telefoneCliente);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setRg(rs.getString("RG"));
				
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Get cliente(Eu quero o código do cliente cujo o preço do orçamento da sua lista de desejos seja o de valor mais alto.)
	public ArrayList<Cliente> getClie2(){
		String sql = "select c.codigo from lista_de_desejos l, Cliente c where l.codigoclie = c.codigo and l.orçamento=(select max(orçamento) from lista_de_desejos);";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList<>();
			Cliente c;
			while(rs.next()) {
				c = new Cliente();
				c.setCodigo(rs.getInt("codigo"));
				
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		/*------------------------------------------------------------------------------------------------*/
	
	//Remover
	public int remover(Cliente c) {
		
			int removeu=0;
			String sql="DELETE FROM Cliente WHERE codigo= ?;";
			PreparedStatement stmt;

			try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, c.getCodigo());
			removeu=stmt.executeUpdate();

			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
			return removeu;
			
	}
	
	public Cliente RemoveCliente(int codigo) {
		Cliente c = null;
		int removeu = 0;
		String sql = "DELETE FROM Cliente WHERE codigo= ?;";
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
	
	public Cliente Removetel(int codigoClie ) {
		Cliente c = null;
		int removeu = 0;
		String sql = "DELETE FROM TelefoneCliente WHERE codigoClie = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigoClie );
			removeu=stmt.executeUpdate();
			System.out.println(codigoClie );
			
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
	public int update (Cliente c) {
		int update =0;
		
		String sql = "UPDATE Cliente SET nome =?,email = ?,rg= ?,data_nasc = ?,cep=?,rua=?,bairro =?, num = ? WHERE codigo = ?;";
		PreparedStatement stmt;
		
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getRg());
			stmt.setString(4, c.getData_nasc());
			stmt.setString(5, c.getCep());
			stmt.setString(6, c.getRua());
			stmt.setString(7, c.getBairro());
			stmt.setInt(8, c.getNum());
			stmt.setInt(9, c.getCodigo());
			
			update=stmt.executeUpdate();
			System.out.println(update);
			stmt.close();

			}catch(SQLException e) {
			e.printStackTrace();
			}
		System.out.println("testando");
		return update;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//Insert Telefone
	public int insert(Cliente c) {
		int inseriu=0;
		String sql = "INSERT INTO TelefoneCliente(codigoClie, telefonesClie) VALUES(?,?);";
		PreparedStatement stmt;
		

		try {
		stmt=connection.prepareStatement(sql);
		stmt.setInt(1, c.getCodigo());
		stmt.setString(2, c.getTel());
		inseriu=stmt.executeUpdate();
		stmt.close();
		
		}catch(SQLException e) {
		e.printStackTrace();
		}
		return inseriu;
		}
	
	public ArrayList<Cliente> getListatel() {

		String sql = "Select * from telefonecliente";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cliente> clientes= new ArrayList<>();
			Cliente c;
			while (rs.next()) {
				c = new Cliente();
				c.setCodigo(rs.getInt("codigoClie"));
				c.setTel(rs.getString("telefonesClie"));
				

				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	//Função login
	public Cliente login(int codigo, String senha) {
		Cliente c = null;
		String sql = "Select RG from Cliente where codigo = ? and senha = ?;";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.setString(2, senha);
			System.out.println(senha);
			ResultSet rs = stmt.executeQuery();
			
			
			if (rs.next()) {
				c = new Cliente();
				c.setRg(rs.getString("RG"));
			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	/*------------------------------------------------------------------------------------------------*/
	
	//Funções extras que provavelmente não vou usar(Porém vou guardar para caso eu precise)
	
	//telefone
	/*while (c.getTelefones().size() > 0){
	for(int i =0; i <c.getTelefones().size();i++) {
		 c.getTel = c.getTelefones().get(i);
		
		System.out.println(c.getTel);
		stmt=connection.prepareStatement(sql);
		stmt.setString(1,c.getTel());
		stmt.close();
	}
}*/
	/*------------------------------------------------------------------------------------------------*/
	
	//Cliente
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
