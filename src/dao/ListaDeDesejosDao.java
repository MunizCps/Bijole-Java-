package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Cerimonialista;
import bean.Cliente;
import bean.Encontro;
import bean.ListaDeDesejos;
import bean.Salao;

public class ListaDeDesejosDao {
		//Conexão
		private Connection connection;
		public ListaDeDesejosDao(){
			connection = new FabricaConexoes().getConnection();
		}
		/*------------------------------------------------------------------------------------------------*/
		
		//Inserir
		public int inserir(ListaDeDesejos l) {
			int inseriu=0;
			
			String sql="INSERT INTO Lista_de_desejos(id,quant_pessoas,tipo_Decoraçao,orçamento,tamanho_salao,cardapio_buffet,codigoclie,protocoloceri,data,hora) VALUES (?,?,?,?,?,?,?,?,?,?);";
		
			PreparedStatement stmt;
			

			try {
			stmt=connection.prepareStatement(sql);
			
			
			stmt.setInt(1,l.getId());
			stmt.setInt(2, l.getQuant_pessoas());
			stmt.setString(3,l.getTipo_Decoraçao());
			stmt.setDouble(4, l.getOrçamento());
			stmt.setString(5, l.getTamanho_salao());
			stmt.setString(6, l.getCardapio_buffet());
			stmt.setInt(7, l.getCodigoclie());
			stmt.setInt(8, l.getProtocoloceri());
			stmt.setString(9, l.getData());
			stmt.setString(10, l.getHora());
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
		public ArrayList<ListaDeDesejos> getLista(){
			String sql = "Select * from Lista_de_desejos";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				ArrayList<ListaDeDesejos> desejos = new ArrayList<>();
				ListaDeDesejos l;
				while(rs.next()) {
					l = new ListaDeDesejos();
					
					l.setQuant_pessoas(rs.getInt("Quant_pessoas"));
					l.setCodigoclie (rs.getInt("codigoclie"));
					l.setProtocoloceri (rs.getInt("protocoloceri"));
					l.setData(rs.getString("data"));
					l.setHora(rs.getString("hora"));
					l.setOrçamento (rs.getInt("orçamento"));
					l.setCardapio_buffet (rs.getString("cardapio_buffet"));
					l.setTipo_Decoraçao(rs.getString("tipo_de_decoracao"));
					l.setId(rs.getInt("ID"));
					l.setTamanho_salao (rs.getString("tamanho_do_salao"));
					desejos.add(l);
				}
				rs.close();
				stmt.close();
				return desejos;
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
			
			
		}
		/*------------------------------------------------------------------------------------------------*/
		
		//Verifica lista(Eu quero o orçamento da lista de desejos cujo o protocolo da cerimonialista termine com ?(com o que o cliente digitar))
		public ListaDeDesejos verificaLista(int protocoloceri) {
			ListaDeDesejos l = null;
			String sql = "Select orçamento from Lista_de_desejos where protocoloceri  = ?";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, protocoloceri);
				ResultSet rs = stmt.executeQuery();
				
				
				if (rs.next()) {
					l = new ListaDeDesejos();
					l.setOrçamento(rs.getDouble("orçamento"));
					

					
				}
				rs.close();
				stmt.close();
				return l;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		/*------------------------------------------------------------------------------------------------*/
		
		//Remover
		public int remover(ListaDeDesejos l) {
			
				int removeu=0;
				String sql="DELETE FROM Lista_de_desejos WHERE ID= ?;";
				PreparedStatement stmt;

				try {
				stmt=connection.prepareStatement(sql);
				stmt.setInt(1, l.getId());
				removeu=stmt.executeUpdate();

				stmt.close();

				}catch(SQLException e) {
				e.printStackTrace();
				}
				return removeu;
				
		}
		
		public ListaDeDesejos RemoveLista(int codigoclie) {
			ListaDeDesejos l = null;
			int removeu = 0;
			String sql = "DELETE FROM Lista_de_desejos WHERE codigoclie= ?;";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setInt(1, codigoclie);
				removeu=stmt.executeUpdate();
				System.out.println(codigoclie);
				
				stmt.close();
				System.out.println(l);
				return l;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public ListaDeDesejos RemoveListaCeri(int protocoloCeri  ) {
			ListaDeDesejos c = null;
			int removeu = 0;
			String sql = "DELETE FROM Lista_de_desejos WHERE protocoloCeri  = ?;";
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
		
		//Update
		public int update (ListaDeDesejos l) {
			int update =0;
			
			String sql = "UPDATE Lista_de_desejos SET quant_pessoas = ?,tipo_Decoraçao= ?,orçamento = ?,tamanho_salao=?, cardapio_buffet = ? WHERE id = ?;";
			PreparedStatement stmt;
			
			try {
				stmt=connection.prepareStatement(sql);
				stmt.setInt(1, l.getQuant_pessoas());
				stmt.setString(2, l.getTipo_Decoraçao());
				stmt.setDouble(3, l.getOrçamento());
				stmt.setString(4, l.getTamanho_salao());
				stmt.setString(5, l.getCardapio_buffet());
				stmt.setInt(6, l.getId());
				
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
