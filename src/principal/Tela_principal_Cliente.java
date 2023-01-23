package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.ToolTipManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


import bean.Cerimonialista;
import bean.Cliente;
import bean.Encontro;
import bean.ListaDeDesejos;
import dao.CerimonialistaDao;
import dao.ClienteDao;
import dao.EncontroDao;
import dao.FabricaConexoes;
import dao.FisicaDao;
import dao.ListaDeDesejosDao;
import principal.ClienteTela;


import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Cerimonialista;

public class Tela_principal_Cliente extends JFrame {

	private JPanel contentPane;
	private JTextField text_protocoloE;
	private JTable ceriTable;
	private JTable ceriTable2;
	private JTable ceri_Table3;
	private JTable ceriTable4;
	private JTextField text_nomeC;
	private JTextField text_emailC;
	private JTextField text_rgC;
	private JTextField text_codigoR;
	private JTextField text_dataC;
	private JTextField text_cepC;
	private JTextField text_ruaC;
	private JTextField text_numeroC;
	private JTextField text_telefoneE;
	private JTextField text_bairroC;
	private JTextField text_Consulta;
	private JTextField text_codigoE;
	private JTextField text_dataE;
	private JTextField text_horaE;
	private FabricaConexoes conexao ;
	private JTextField textSenha;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_principal_Cliente frame = new Tela_principal_Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	public void carregaTabela() {
	DefaultTableModel modelo= (DefaultTableModel) ceriTable.getModel();
	modelo.setNumRows(0);
	try {
	Connection con = conexao.getConnection();
	PreparedStatement stmt;
	ResultSet rs;
	stmt= con.prepareStatement("select * from cerimonialista;");
	rs = stmt.executeQuery();
	while(rs.next()) {
	modelo.addRow(new Object[] {
	rs.getInt(0),
	rs.getString(1),
	rs.getString(2),
	rs.getString(3)
	});
	}
	con.close();
	stmt.close();
	rs.close();
	}catch(Exception e) {
	e.printStackTrace();
	
	}
	}
*/
	/*public void PopularJTable(String sql) {
		  try
		  {
		   Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/coala_eventos4?useSSL=false","root","lucas230320");
		   PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
		   banco.execute(); // cria o vetor
		 
		   ResultSet resultado = banco.executeQuery(sql);
		 
		   DefaultTableModel model =(DefaultTableModel) ceriTable.getModel();
		   model.setNumRows(0);
		 
		   while(resultado.next())
		   {
		       model.addRow(new Object[] 
		       { 
		          //retorna os dados da tabela do BD, cada campo e um coluna.
		          resultado.getString("protocolo"),
		          resultado.getString("email"),
		          resultado.getString("cpf"),
		          resultado.getString("nome")
		       }); 
		  } 
		   banco.close();
		   con.close();
		  }
		 catch (SQLException ex)
		 {
		    System.out.println("o erro foi " +ex);
		  }
		 }*/
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	
	public Tela_principal_Cliente() throws ParseException {
		//this.PopularJTable("SELECT * FROM Cerimonialista ");
		setBackground(Color.BLACK);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 684, 360);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cliente.class.getResource("/img/mulher.png")), panel, null);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 47, 441, 161);
		panel.add(scrollPane);
		
		ceriTable = new JTable();
		ceriTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Protocolo", "Email", "CPF", "Nome"
			}
		));
		ceriTable.setForeground(Color.WHITE);
		ceriTable.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(ceriTable);
		CerimonialistaDao adao1 = new CerimonialistaDao();
		ArrayList <Cerimonialista> ceri = new ArrayList();
		ceri = adao1.getLista();
		DefaultTableModel model = (DefaultTableModel) ceriTable.getModel();
		for(int i =0;i<ceri.size();i++) {
			model.addRow(new Object[] {ceri.get(i).getProtocolo(),ceri.get(i).getEmail(),ceri.get(i).getCpf(),ceri.get(i).getNome() });
		}
		
		JSeparator separator = new JSeparator();
		
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 219, 441, 2);
		panel.add(separator);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 232, 441, 95);
		panel.add(scrollPane_1);
		
		ceriTable2 = new JTable();
		ceriTable2.setBackground(Color.DARK_GRAY);
		ceriTable2.setForeground(Color.WHITE);
		
		
		ceriTable2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Protocolo", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		CerimonialistaDao adao2 = new CerimonialistaDao();
		ArrayList <Cerimonialista> ceri2 = new ArrayList();
		ceri2 = adao2.getListaTel();
		DefaultTableModel mode = (DefaultTableModel) ceriTable2.getModel();
		for(int i =0;i<ceri2.size();i++) {
			mode.addRow(new Object[] {ceri2.get(i).getProtocolo(),ceri2.get(i).getTel()});
		}
		scrollPane_1.setViewportView(ceriTable2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/mulher1.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(211, 0, 176, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cerimonialistas");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(246, 11, 205, 25);
		panel.add(lblNewLabel_1);
		
		text_protocoloE = new JTextField();
		text_protocoloE.setColumns(10);
		text_protocoloE.setBounds(488, 47, 167, 25);
		panel.add(text_protocoloE);
		
		JLabel lblNewLabel_2 = new JLabel("Protocolo");
		lblNewLabel_2.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/prancheta.png")));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2.setBounds(488, 7, 150, 36);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dataE = text_dataE.getText();
				String horaE= text_horaE.getText();
				int protocoloE = Integer.parseInt(text_protocoloE.getText());
				int codigoE = Integer.parseInt(text_codigoE.getText());
				Encontro c = new Encontro(dataE,horaE,codigoE,protocoloE);
				EncontroDao adao10 = new EncontroDao();
				adao10.inserir2(c);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/selecione.png")));
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(532, 270, 123, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("Data");
		lblNewLabel_2_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/calendario.png")));
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(488, 71, 96, 35);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hora");
		lblNewLabel_2_2.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/relogio.png")));
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(488, 132, 96, 36);
		panel.add(lblNewLabel_2_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 0, 30, 23);
		panel.add(btnNewButton_1);
		
		text_codigoE = new JTextField();
		text_codigoE.setColumns(10);
		text_codigoE.setBounds(488, 234, 167, 25);
		panel.add(text_codigoE);
		
		JLabel lblNewLabel_3 = new JLabel(" C\u00F3digo");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_3.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/selecionado.png")));
		lblNewLabel_3.setBounds(488, 202, 96, 31);
		panel.add(lblNewLabel_3);
		
		text_dataE = new JTextField();
		text_dataE.setColumns(10);
		text_dataE.setBounds(488, 108, 167, 25);
		panel.add(text_dataE);
		
		text_horaE = new JTextField();
		text_horaE.setColumns(10);
		text_horaE.setBounds(488, 168, 167, 25);
		panel.add(text_horaE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cliente.class.getResource("/img/perfil-de-usuario.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Encontros");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/calendario.png")));
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1_2.setBounds(248, 10, 175, 39);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 71, 468, 241);
		panel_1.add(scrollPane_2);
		
		table = new JTable();
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num. Cadastro", "Protocolo", "c\u00F3digo", "Data", "Hora"
			}
		));
		scrollPane_2.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cliente.class.getResource("/img/perfil-online.png")), panel_2, null);
		tabbedPane.setBackgroundAt(2, Color.BLACK);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/perfil-online (1).png")));
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(176, 0, 313, 39);
		panel_2.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 63, 538, 44);
		panel_2.add(scrollPane_3);
		
		ceri_Table3 = new JTable();
		ceri_Table3.setBackground(Color.DARK_GRAY);
		ceri_Table3.setForeground(Color.WHITE);
		
		ceri_Table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "E-mail", "RG", "C\u00F3digo", "Data Nasc.", "CEP", "Bairro", "Rua", "Num"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
		});
		
		
		scrollPane_3.setViewportView(ceri_Table3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(546, 63, 123, 44);
		panel_2.add(scrollPane_4);
		
		ceriTable4 = new JTable();
		ceriTable4.setBackground(Color.DARK_GRAY);
		ceriTable4.setForeground(Color.WHITE);
		
		ceriTable4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
		});
		
		scrollPane_4.setViewportView(ceriTable4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 130, 659, 2);
		panel_2.add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 143, 46, 14);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(139, 143, 46, 14);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("RG");
		lblNewLabel_1_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(272, 143, 46, 14);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("C\u00F3digo");
		lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(409, 143, 88, 19);
		panel_2.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Data Nasc");
		lblNewLabel_1_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(546, 143, 88, 14);
		panel_2.add(lblNewLabel_1_6);
		
		text_nomeC = new JTextField();
		text_nomeC.setForeground(Color.BLACK);
		text_nomeC.setColumns(10);
		text_nomeC.setBackground(Color.WHITE);
		text_nomeC.setBounds(10, 168, 104, 26);
		panel_2.add(text_nomeC);
		
		text_emailC = new JTextField();
		text_emailC.setForeground(Color.BLACK);
		text_emailC.setColumns(10);
		text_emailC.setBackground(Color.WHITE);
		text_emailC.setBounds(139, 168, 104, 26);
		panel_2.add(text_emailC);
		
		text_rgC = new JTextField();
		text_rgC.setForeground(Color.BLACK);
		text_rgC.setColumns(10);
		text_rgC.setBackground(Color.WHITE);
		text_rgC.setBounds(272, 168, 104, 26);
		panel_2.add(text_rgC);
		
		text_codigoR = new JTextField();
		text_codigoR.setForeground(Color.BLACK);
		text_codigoR.setColumns(10);
		text_codigoR.setBackground(Color.WHITE);
		text_codigoR.setBounds(409, 168, 104, 26);
		panel_2.add(text_codigoR);
		
		text_dataC=new JFormattedTextField(new MaskFormatter("##/##/####"));
		text_dataC.setForeground(Color.BLACK);
		text_dataC.setColumns(10);
		text_dataC.setBackground(Color.WHITE);
		text_dataC.setBounds(546, 168, 104, 26);
		panel_2.add(text_dataC);
		
		text_cepC = new JTextField();
		text_cepC.setForeground(Color.BLACK);
		text_cepC.setColumns(10);
		text_cepC.setBackground(Color.WHITE);
		text_cepC.setBounds(10, 239, 104, 26);
		panel_2.add(text_cepC);
		
		text_ruaC = new JTextField();
		text_ruaC.setForeground(Color.BLACK);
		text_ruaC.setColumns(10);
		text_ruaC.setBackground(Color.WHITE);
		text_ruaC.setBounds(272, 242, 104, 26);
		panel_2.add(text_ruaC);
		
		text_numeroC = new JTextField();
		text_numeroC.setForeground(Color.BLACK);
		text_numeroC.setColumns(10);
		text_numeroC.setBackground(Color.WHITE);
		text_numeroC.setBounds(409, 242, 104, 26);
		panel_2.add(text_numeroC);
		
		text_telefoneE=new JFormattedTextField(new MaskFormatter("(##)#####.####"));
		text_telefoneE.setForeground(Color.BLACK);
		text_telefoneE.setColumns(10);
		text_telefoneE.setBackground(Color.WHITE);
		text_telefoneE.setBounds(546, 242, 104, 26);
		panel_2.add(text_telefoneE);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CEP");
		lblNewLabel_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 219, 46, 14);
		panel_2.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Bairro");
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(139, 219, 46, 14);
		panel_2.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Rua");
		lblNewLabel_1_4_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_4_1.setBounds(272, 219, 46, 14);
		panel_2.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("N\u00FAmero");
		lblNewLabel_1_5_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(409, 219, 88, 19);
		panel_2.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Telefone");
		lblNewLabel_1_6_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_6_1.setBounds(546, 219, 88, 14);
		panel_2.add(lblNewLabel_1_6_1);
		
		JComboBox pessoaComboBox = new JComboBox();
		pessoaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa Fis\u00EDca", "Pessoa  Jur\u00EDdica"}));
		
		
		pessoaComboBox.setForeground(Color.WHITE);
		pessoaComboBox.setBackground(Color.BLACK);
		pessoaComboBox.setBounds(139, 287, 104, 24);
		panel_2.add(pessoaComboBox);
		
		
		JButton btnNewButton_1_4 = new JButton("");
		btnNewButton_1_4.setToolTipText("Se quiser fazer uma exclusão adicione um código e especifique se você é um cliente físico ou jurídico, "
				+ "após isso apenas clique nesse botão e a exclusão será executada");
		
		btnNewButton_1_4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ToolTipManager.sharedInstance().setDismissDelay(8000);
			}

			
		});
		btnNewButton_1_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(pessoaComboBox.getSelectedItem().equals("Pessoa Fisíca")) {
					int codigoR = Integer.parseInt(text_codigoR.getText());
					ClienteDao adao = new ClienteDao();
					FisicaDao adao1 = new FisicaDao();
					EncontroDao adao2 = new EncontroDao();
					ListaDeDesejosDao adao3 = new ListaDeDesejosDao();
					ClienteDao adao4 = new ClienteDao();
					adao1.RemoveFisica(codigoR);
					adao2.RemoveEncontro(codigoR);
					adao3.RemoveLista(codigoR);
					adao4.Removetel(codigoR);
					adao.RemoveCliente(codigoR);
					
				}
			}
		});
		btnNewButton_1_4.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/remover.png")));
		btnNewButton_1_4.setOpaque(true);
		btnNewButton_1_4.setContentAreaFilled(false);
		btnNewButton_1_4.setBackground(Color.WHITE);
		btnNewButton_1_4.setBounds(610, 279, 40, 39);
		panel_2.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_4_1 = new JButton("");
		btnNewButton_1_4_1.setToolTipText("Se quiser fazer um adição de telefone, digite seu código e seu telefone, e logo após isso clique nesse botão");
		btnNewButton_1_4_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoT = Integer.parseInt(text_codigoR.getText());
				String telT = text_telefoneE.getText();
				Cliente ca = new Cliente(codigoT,telT);
				ClienteDao adao = new ClienteDao();
				adao.insert(ca);
			}
		});
		btnNewButton_1_4_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/sinal-de-mais.png")));
		btnNewButton_1_4_1.setOpaque(true);
		btnNewButton_1_4_1.setContentAreaFilled(false);
		btnNewButton_1_4_1.setBackground(Color.WHITE);
		btnNewButton_1_4_1.setBounds(560, 279, 40, 39);
		panel_2.add(btnNewButton_1_4_1);
		
		JButton btnNewButton_1_4_2 = new JButton();
		btnNewButton_1_4_2.setToolTipText("Digite todos os dados (com exceção do telefone) e clique no botão para editar os dados");
		btnNewButton_1_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeC = text_nomeC.getText();
				String dataC = text_dataC.getText();
				String cepC = text_cepC.getText();
				String emailC = text_emailC.getText();
				String bairroC= text_bairroC.getText();
				String RGC = text_rgC.getText();
				String rua = text_ruaC.getText();
				int codigoC = Integer.parseInt(text_codigoR.getText());
				int numC = Integer.parseInt(text_numeroC.getText());
				Cliente ca = new Cliente();
				ClienteDao adao2 = new ClienteDao();
				Cliente la = new Cliente(nomeC,emailC,RGC,dataC,cepC,rua,bairroC,numC,codigoC);
				adao2.update(la);
				}
		});
		btnNewButton_1_4_2.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/editar.png")));
		btnNewButton_1_4_2.setOpaque(true);
		btnNewButton_1_4_2.setContentAreaFilled(false);
		btnNewButton_1_4_2.setBackground(Color.WHITE);
		btnNewButton_1_4_2.setBounds(508, 279, 40, 39);
		panel_2.add(btnNewButton_1_4_2);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_1_1.setOpaque(true);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(10, 0, 30, 23);
		panel_2.add(btnNewButton_1_1_1);
		
		text_bairroC = new JTextField();
		text_bairroC.setForeground(Color.BLACK);
		text_bairroC.setColumns(10);
		text_bairroC.setBackground(Color.WHITE);
		text_bairroC.setBounds(139, 242, 104, 26);
		panel_2.add(text_bairroC);
		
		JButton buttonsenha = new JButton();
		buttonsenha.setToolTipText("Digite o codigo e a senha e depois clique nesse botão para obter seus dados");
		buttonsenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		buttonsenha.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/lupa.png")));
		buttonsenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoB = Integer.parseInt(text_codigoR.getText());
				String senha = textSenha.getText();
				
				ClienteDao adao4 = new ClienteDao();
				ArrayList <Cliente> clie = new ArrayList();
				
				Cliente cliea = adao4.verificaClienteSenha(senha);
				System.out.println(codigoB);
				System.out.println(cliea);
				DefaultTableModel model5 = (DefaultTableModel) ceri_Table3.getModel();
				model5.addRow(new Object[] {cliea.getNome(),cliea.getEmail(),cliea.getRg(),cliea.getCodigo(),cliea.getData_nasc(),cliea.getCep(),cliea.getBairro(),cliea.getRua(),cliea.getNum()});

				
				ClienteDao adao3 = new ClienteDao();
				ArrayList <Cliente> Clie = new ArrayList();
				cliea = adao3.verificaClienteTel(codigoB);
				
				
				DefaultTableModel model3 = (DefaultTableModel) ceriTable4.getModel();
		
					model3.addRow(new Object[] {codigoB,cliea.getTel()});
				
			}
			
			
		});
		buttonsenha.setToolTipText("Digite o codigo e a senha e depois clique nesse botão para obter seus dados");
		buttonsenha.setOpaque(true);
		buttonsenha.setContentAreaFilled(false);
		buttonsenha.setBackground(Color.WHITE);
		buttonsenha.setBounds(449, 277, 40, 39);
		panel_2.add(buttonsenha);
		
		textSenha = new JTextField();
		textSenha.setForeground(Color.BLACK);
		textSenha.setColumns(10);
		textSenha.setBackground(Color.WHITE);
		textSenha.setBounds(10, 289, 104, 26);
		panel_2.add(textSenha);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Senha");
		lblNewLabel_1_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 274, 46, 14);
		panel_2.add(lblNewLabel_1_2_1_1);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cliente.class.getResource("/img/lupa.png")), panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pesquisa");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/MicrosoftTeams-image (6).png")));
		lblNewLabel_1_1_1_1.setBounds(242, 11, 256, 39);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		panel_3.add(lblNewLabel_1_1_1_1);
		
		text_Consulta = new JTextField();
		text_Consulta.setColumns(10);
		text_Consulta.setBounds(108, 74, 341, 39);
		panel_3.add(text_Consulta);
		
		JTextPane result = new JTextPane();
		result.setForeground(Color.WHITE);
		result.setBackground(Color.DARK_GRAY);
		result.setBounds(0, 136, 679, 186);
		panel_3.add(result);
		
		JButton btnNewButton_3_3_1 = new JButton("");
		btnNewButton_3_3_1.setToolTipText("Digite o protocolo da cerimonialista desejada, e clique no botão para obter o orçamento da lista de desejos da cerimonialista");
		btnNewButton_3_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_3_3_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/lupa32.png")));
		btnNewButton_3_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int consulta = Integer.parseInt(text_Consulta.getText());
				CerimonialistaDao adao4 = new CerimonialistaDao();
				ListaDeDesejosDao adao7 = new ListaDeDesejosDao();
				ListaDeDesejos c  = adao7.verificaLista(consulta);
				
				result.setText(String.valueOf(c.getOrçamento()));
				
				

				
			}
		});
		btnNewButton_3_3_1.setBounds(468, 74, 40, 37);
		panel_3.add(btnNewButton_3_3_1);
		
		JButton btnNewButton_3_3_1_1 = new JButton("");
		btnNewButton_3_3_1_1.setToolTipText("Clique no botão para mostrar o CPF de todas as cerimonialistas que foram a um encontro com um cliente");
		btnNewButton_3_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		btnNewButton_3_3_1_1.setIcon(new ImageIcon(Tela_principal_Cliente.class.getResource("/img/procurar.png")));
		btnNewButton_3_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaDao adao6 = new CerimonialistaDao();
				ArrayList<Cerimonialista> ceriLi =adao6.getCeri();
			
				ImageIcon icon = new ImageIcon(Tela_principal_Cliente.class.getResource("/img/prancheta.png"));
				
				for(int i = 0; i< ceriLi.size();i++) {
					String recebe=ceriLi.get(i).getCpf();
					JOptionPane.showInternalMessageDialog(null, recebe, "CPF",i, icon);

					
				
				}
				
			
					
			}
		});
		btnNewButton_3_3_1_1.setBounds(530, 74, 40, 37);
		panel_3.add(btnNewButton_3_3_1_1);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
