package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Cerimonialista;
import bean.Encontro;
import bean.Salao;
import dao.CerimonialistaDao;
import dao.EncontroDao;
import dao.SalaoDao;

public class Tela_principal_Salao extends JFrame {

	private JPanel contentPane;
	private JTable table_2;
	private JTextField protocolo_text;
	private JTable table;
	private JTable table_1;
	private JTextField nome_text;
	private JTextField num_cad_text;
	private JTextField qnt_text;
	private JTextField rua_text;
	private JTextField preco_text;
	private JTextField bairro_text;
	private JTextField cep_text;
	private JTextField numero_text;
	private JTextField telefone_text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_principal_Salao frame = new Tela_principal_Salao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Tela_principal_Salao() throws ParseException{
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
		tabbedPane.setBounds(0, 0, 694, 360);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Salao.class.getResource("/img/balao-de-ar.png")), panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 493, 44);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.BOLD, 12));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Num. Cadastro", "Nome", "CEP", "Rua", "Bairro", "Num", "Qnt. Pessoas", "Pre\u00E7o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblNewLabel_1.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/balao-de-ar1.png")));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(154, 0, 362, 64);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(503, 61, 176, 44);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(Color.DARK_GRAY);
		table_1.setForeground(Color.WHITE);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Num. Cadastro", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(38, 141, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("N\u00FAmero Cadastro");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(204, 135, 154, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel label = new JLabel("Quant. Pessoas");
		label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		label.setBounds(368, 135, 141, 26);
		panel.add(label);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(519, 135, 125, 26);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Rua");
		lblNewLabel_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(38, 208, 46, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Bairro");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(204, 208, 70, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("N\u00FAmero");
		lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(368, 208, 88, 14);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("CEP");
		lblNewLabel_1_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(520, 208, 46, 14);
		panel.add(lblNewLabel_1_6);
		
		nome_text = new JTextField();
		nome_text.setForeground(Color.BLACK);
		nome_text.setColumns(10);
		nome_text.setBackground(Color.WHITE);
		nome_text.setBounds(38, 156, 104, 26);
		panel.add(nome_text);
		
		num_cad_text = new JTextField();
		num_cad_text.setForeground(Color.BLACK);
		num_cad_text.setColumns(10);
		num_cad_text.setBackground(Color.WHITE);
		num_cad_text.setBounds(204, 156, 104, 26);
		panel.add(num_cad_text);
		
		qnt_text = new JTextField();
		qnt_text.setForeground(Color.BLACK);
		qnt_text.setColumns(10);
		qnt_text.setBackground(Color.WHITE);
		qnt_text.setBounds(368, 156, 104, 26);
		panel.add(qnt_text);
		
		rua_text = new JTextField();
		rua_text.setForeground(Color.BLACK);
		rua_text.setColumns(10);
		rua_text.setBackground(Color.WHITE);
		rua_text.setBounds(38, 222, 104, 26);
		panel.add(rua_text);
		
		preco_text = new JTextField();
		preco_text.setForeground(Color.BLACK);
		preco_text.setColumns(10);
		preco_text.setBackground(Color.WHITE);
		preco_text.setBounds(519, 156, 104, 26);
		panel.add(preco_text);
		
		bairro_text = new JTextField();
		bairro_text.setForeground(Color.BLACK);
		bairro_text.setColumns(10);
		bairro_text.setBackground(Color.WHITE);
		bairro_text.setBounds(204, 222, 104, 26);
		panel.add(bairro_text);
		
		cep_text = new JTextField();
		cep_text.setForeground(Color.BLACK);
		cep_text.setColumns(10);
		cep_text.setBackground(Color.WHITE);
		cep_text.setBounds(520, 222, 104, 26);
		panel.add(cep_text);
		
		numero_text = new JTextField();
		numero_text.setForeground(Color.BLACK);
		numero_text.setColumns(10);
		numero_text.setBackground(Color.WHITE);
		numero_text.setBounds(368, 222, 104, 26);
		panel.add(numero_text);
		
		telefone_text = new JTextField();
		telefone_text.setForeground(Color.BLACK);
		telefone_text.setColumns(10);
		telefone_text.setBackground(Color.WHITE);
		telefone_text.setBounds(38, 285, 104, 26);
		panel.add(telefone_text);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Telefone");
		lblNewLabel_1_2_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(38, 270, 88, 14);
		panel.add(lblNewLabel_1_2_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 125, 658, 2);
		panel.add(separator);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num_cadastro= Integer.parseInt(num_cad_text.getText());
				
				
				SalaoDao sadao = new SalaoDao();
				
				
				
				
				/*int protocoloR = Integer.parseInt(Protocolo_text.getText());
				CerimonialistaDao adao = new CerimonialistaDao();
				EncontroDao adao2 = new EncontroDao();
				ListaDeDesejosDao adao3 = new ListaDeDesejosDao();
				CerimonialistaDao adao4 = new CerimonialistaDao();
				
				adao4.RemoveTelceri(protocoloR);
				adao3.RemoveListaCeri(protocoloR);
				adao2.RemoveEncontroCeri(protocoloR);
				adao.RemoveCeri(protocoloR);*/
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/remover.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(583, 272, 40, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num_cadastro= Integer.parseInt(num_cad_text.getText());
				String tel= telefone_text.getText();
				
				Salao salao =new Salao(num_cadastro,tel);
				SalaoDao salDao= new SalaoDao();
				
				salDao.insert(salao);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/sinal-de-mais.png")));
		btnNewButton_3.setOpaque(true);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(533, 272, 40, 39);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numCad= Integer.parseInt(num_cad_text.getText());
				String nome= nome_text.getText();
				String cep= cep_text.getText();
				String rua= rua_text.getText();
				String bairro= bairro_text.getText();
				int num= Integer.parseInt(bairro_text.getText());
				int qut_pessoas= Integer.parseInt(qnt_text.getText());
				int preço= Integer.parseInt(preco_text.getText());
				String tel= telefone_text.getText();
				
				Salao salao1=new Salao(nome,preço,qut_pessoas, numCad,bairro,cep, rua, num);
				Salao salaotel = new  Salao(numCad,tel);
				SalaoDao SalDao1 = new SalaoDao();
				
				SalDao1.update(salao1);
				SalDao1.updatetel(salaotel);
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/editar.png")));
		btnNewButton_4.setOpaque(true);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(483, 272, 40, 39);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalãoTela sal = null;
				try {
					sal = new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sal = new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sal.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_1_1.setOpaque(true);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(10, 10, 30, 23);
		panel.add(btnNewButton_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Salao.class.getResource("/img/perfil-de-usuario.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Encontro");
		lblNewLabel_1_1.setBounds(248, 5, 234, 39);
		lblNewLabel_1_1.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/m\u00E3o-clientes.png")));
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		panel_1.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 61, 451, 250);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setForeground(Color.WHITE);
		table_2.setBackground(Color.DARK_GRAY);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "C\u00F3digo Cliente", "Protocolo", "Num. Cadastro"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel = new JLabel("Protocolo");
		lblNewLabel.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/prancheta.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(511, 55, 234, 44);
		panel_1.add(lblNewLabel);
		
		protocolo_text = new JTextField();
		protocolo_text.setBounds(511, 109, 154, 27);
		panel_1.add(protocolo_text);
		protocolo_text.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocolo= Integer.parseInt(protocolo_text.getText());
				
				Encontro en= new Encontro(protocolo);
				EncontroDao enDao1 = new EncontroDao();
				
				enDao1.update3(en);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/remover.png")));
		btnNewButton.setBounds(525, 146, 40, 39);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=0;
				
				ImageIcon icon2 = new ImageIcon(Tela_principal_Cliente.class.getResource("/img/choque.png"));
				ImageIcon icon = new ImageIcon(Tela_principal_Cliente.class.getResource("/img/surpresa.png"));
				
				if(protocolo_text.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Digite o Protocolo da Cerimonialista para aceitar o encontro!!", "Aviso",i, icon2);
					
					
				}else {
					JOptionPane.showInternalMessageDialog(null, "Seu encontro está marcado!!", "Encontro",i, icon);

				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/verifica.png")));
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(595, 146, 40, 39);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalãoTela sal = null;
				try {
					sal = new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sal = new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sal.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(Tela_principal_Salao.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(10, 5, 30, 23);
		panel_1.add(btnNewButton_1_1);
		tabbedPane.setBackgroundAt(1, Color.BLACK);
	}
}
