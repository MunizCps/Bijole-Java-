package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.text.MaskFormatter;

import bean.Cerimonialista;
import bean.Cliente;
import bean.Encontro;
import bean.ListaDeDesejos;
import bean.Salao;
import dao.CerimonialistaDao;
import dao.ClienteDao;
import dao.EncontroDao;
import dao.ListaDeDesejosDao;
import dao.SalaoDao;

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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class Tela_principal_Cerimonialista extends JFrame {

	private JPanel contentPane;
	private JTable salaoTable;
	private JTable salao_telTable;
	private JTextField num_cad_text;
	private JTextField data_text;
	private JTextField hora_text;
	private JTable table_2;
	private JTextField codigoClie_text;
	private JTable clienteTable;
	private JTable clienteTelTable;
	private JTextField pesquisa_text;
	private JTable ceriTable;
	private JTable infoTable;
	private JTextField Protocolo_text;
	private JTextField nome_text;
	private JTextField email_text;
	private JTextField cpf_text;
	private JTextField telefone_text;
	private JTextField ID_text;
	private JTextField qnt_pessoas_text;
	private JTextField deco_text;
	private JTextField orcamento_text;
	private JTextField tamanho_text;
	private JTextField cardapio_text;
	private JTextField codigo_text;
	private JTable desejos2Table;
	private JTable desejos1Table;
	private JTextField pesquisa2_text;
	private JTextField protoco_text;
	private JTextField protocoloceri_text;
	private JTextField data2_text;
	private JTextField hora2_text;
	private JTable resultadoTable;
	private JTextField codigo1_text;
	private JTextField nome1_text;
	private JTextField RG1_text;
	private JTextField email1_text;
	private JTextField rua1_text;
	private JTextField bairro1_text;
	private JTextField CEP1_text;
	private JTextField num1_text;
	private JTextField data1_text;
	private JTextField tel1_text;
	private JTextField textSenha;
	private JTextField text_protocolo;
	private JTextField text_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_principal_Cerimonialista frame = new Tela_principal_Cerimonialista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public Tela_principal_Cerimonialista() throws ParseException {
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
		tabbedPane.setBounds(0, 0, 694, 372);
		contentPane.add(tabbedPane);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.WHITE);
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/mulher.png")),
				panel_4, null);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblNewLabel_1_1_1_1_1
				.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/mulher1.png")));
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1.setBounds(183, 0, 312, 39);
		panel_4.add(lblNewLabel_1_1_1_1_1);

		JScrollPane ScrollPane5 = new JScrollPane();
		ScrollPane5.setBounds(10, 64, 485, 44);
		panel_4.add(ScrollPane5);

		ceriTable = new JTable();
		ceriTable.setBackground(Color.DARK_GRAY);
		ceriTable.setForeground(Color.WHITE);
		ceriTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Protocolo", "E-mail", "CPF"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		ScrollPane5.setViewportView(ceriTable);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(494, 64, 185, 44);
		panel_4.add(scrollPane_6);

		infoTable = new JTable();
		infoTable.setForeground(Color.WHITE);
		infoTable.setBackground(Color.DARK_GRAY);
		infoTable.setModel(new DefaultTableModel(
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
		scrollPane_6.setViewportView(infoTable);
		
		

		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(47, 147, 46, 20);
		panel_4.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_2 = new JLabel("Protocolo");
		lblNewLabel_1_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(370, 144, 70, 26);
		panel_4.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("E-mail");
		lblNewLabel_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(209, 150, 46, 14);
		panel_4.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_3 = new JLabel("CPF");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(47, 235, 70, 14);
		panel_4.add(lblNewLabel_1_3);

		Protocolo_text = new JTextField();
		Protocolo_text.setForeground(Color.BLACK);
		Protocolo_text.setColumns(10);
		Protocolo_text.setBackground(Color.WHITE);
		Protocolo_text.setBounds(370, 175, 141, 34);
		panel_4.add(Protocolo_text);

		nome_text = new JTextField();
		nome_text.setForeground(Color.BLACK);
		nome_text.setColumns(10);
		nome_text.setBackground(Color.WHITE);
		nome_text.setBounds(47, 175, 141, 34);
		panel_4.add(nome_text);

		email_text = new JTextField();
		email_text.setForeground(Color.BLACK);
		email_text.setColumns(10);
		email_text.setBackground(Color.WHITE);
		email_text.setBounds(209, 175, 141, 34);
		panel_4.add(email_text);

		cpf_text = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpf_text.setBounds(47, 259, 141, 34);
		panel_4.add(cpf_text);
		cpf_text.setColumns(10);

		JLabel lblNewLabel_1_3_1 = new JLabel("Telefone");
		lblNewLabel_1_3_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(209, 233, 70, 14);
		panel_4.add(lblNewLabel_1_3_1);

		telefone_text = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		telefone_text.setForeground(Color.BLACK);
		telefone_text.setColumns(10);
		telefone_text.setBackground(Color.WHITE);
		telefone_text.setBounds(209, 259, 141, 34);
		panel_4.add(telefone_text);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 137, 669, 2);
		panel_4.add(separator_2);

		JButton btnNewButton_1_4 = new JButton("");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocoloR = Integer.parseInt(Protocolo_text.getText());
				CerimonialistaDao adao = new CerimonialistaDao();
				EncontroDao adao2 = new EncontroDao();
				ListaDeDesejosDao adao3 = new ListaDeDesejosDao();
				CerimonialistaDao adao4 = new CerimonialistaDao();
				
				adao4.RemoveTelceri(protocoloR);
				adao3.RemoveListaCeri(protocoloR);
				adao2.RemoveEncontroCeri(protocoloR);
				adao.RemoveCeri(protocoloR);
			}
		});
		btnNewButton_1_4.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/remover.png")));
		btnNewButton_1_4.setOpaque(true);
		btnNewButton_1_4.setContentAreaFilled(false);
		btnNewButton_1_4.setBackground(Color.WHITE);
		btnNewButton_1_4.setBounds(612, 259, 40, 39);
		panel_4.add(btnNewButton_1_4);

		JButton btnNewButton_3_1 = new JButton("");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocolo= Integer.parseInt(Protocolo_text.getText());
				String tel= telefone_text.getText();
				
				Cerimonialista ceri1 = new Cerimonialista(protocolo, tel);
				CerimonialistaDao dao1 = new CerimonialistaDao();
				
				dao1.insert(ceri1);
			}
		});
		btnNewButton_3_1
				.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/sinal-de-mais.png")));
		btnNewButton_3_1.setOpaque(true);
		btnNewButton_3_1.setContentAreaFilled(false);
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(562, 259, 40, 39);
		panel_4.add(btnNewButton_3_1);

		JButton btnNewButton_3_2 = new JButton("");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome= nome_text.getText();
				String email= email_text.getText();
				int protocolo= Integer.parseInt(Protocolo_text.getText());
				String cpf= cpf_text.getText();
				String telefone= telefone_text.getText();
				
				Cerimonialista ceri = new Cerimonialista(protocolo, email, cpf, nome);
				Cerimonialista cerim= new Cerimonialista(protocolo, telefone);
				
				CerimonialistaDao dao= new CerimonialistaDao();
				
				dao.update(ceri);
				dao.updatetel(cerim);
				
			}
		});
		btnNewButton_3_2.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/editar.png")));
		btnNewButton_3_2.setOpaque(true);
		btnNewButton_3_2.setContentAreaFilled(false);
		btnNewButton_3_2.setBackground(Color.WHITE);
		btnNewButton_3_2.setBounds(518, 259, 40, 39);
		panel_4.add(btnNewButton_3_2);

		JButton btnNewButton_1_5 = new JButton("");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaTela cerimo = null;
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerimo.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_5.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_5.setOpaque(true);
		btnNewButton_1_5.setForeground(Color.WHITE);
		btnNewButton_1_5.setContentAreaFilled(false);
		btnNewButton_1_5.setBackground(Color.WHITE);
		btnNewButton_1_5.setBounds(10, 0, 30, 23);
		panel_4.add(btnNewButton_1_5);
		
		textSenha = new JTextField();
		textSenha.setForeground(Color.BLACK);
		textSenha.setColumns(10);
		textSenha.setBackground(Color.WHITE);
		textSenha.setBounds(370, 259, 141, 34);
		panel_4.add(textSenha);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Senha");
		lblNewLabel_1_1_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_2_1.setBounds(370, 227, 70, 26);
		panel_4.add(lblNewLabel_1_1_2_1);
		
		JButton btnNewButton_3_2_1 = new JButton("");
		btnNewButton_3_2_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/MicrosoftTeams-image (6).png")));
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = textSenha.getText();
				int protocolo = Integer.parseInt(Protocolo_text.getText());
				
				CerimonialistaDao adao5 = new CerimonialistaDao();
				Cerimonialista a = adao5.verificaCerimonialistaSenha(senha);
				DefaultTableModel model5 = (DefaultTableModel) ceriTable.getModel();
				model5.addRow(new Object[] {a.getNome(),a.getProtocolo(),a.getEmail(),a.getCpf()});
				
				CerimonialistaDao adao6 = new CerimonialistaDao();
				Cerimonialista aa = adao6.verificaCerimonialistaTel(protocolo);
				System.out.println(aa);
				DefaultTableModel model6 = (DefaultTableModel) infoTable.getModel();
				model6.addRow(new Object[] {aa.getProtocolo(),aa.getTel()});
			}
		});
		btnNewButton_3_2_1.setOpaque(true);
		btnNewButton_3_2_1.setContentAreaFilled(false);
		btnNewButton_3_2_1.setBackground(Color.WHITE);
		btnNewButton_3_2_1.setBounds(562, 208, 40, 39);
		panel_4.add(btnNewButton_3_2_1);

		JPanel numero_cad_text = new JPanel();
		numero_cad_text.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/balao-de-ar.png")),
				numero_cad_text, null);
		tabbedPane.setBackgroundAt(1, Color.BLACK);
		numero_cad_text.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Sal\u00F5es de Eventos");
		lblNewLabel_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/balao-de-ar1.png")));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(200, -11, 279, 64);
		numero_cad_text.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 48, 472, 142);
		numero_cad_text.add(scrollPane);

		salaoTable = new JTable();
		salaoTable.setForeground(Color.WHITE);
		salaoTable.setBackground(Color.DARK_GRAY);
		salaoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num_Cadastro", "Nome", "CEP", "Rua", "Bairro", "Numero", "Quant_Pessoa", "Pre\u00E7o"
			}
		));
		scrollPane.setViewportView(salaoTable);
		
		SalaoDao adao = new SalaoDao();
		ArrayList <Salao> salao = new ArrayList();
		salao = adao.getLista();
		DefaultTableModel model = (DefaultTableModel) salaoTable.getModel();
		for(int i =0;i<salao.size();i++) {
		model.addRow(new Object[] {
				salao.get(i).getNum_cadastro(),
				salao.get(i).getNome(),
				salao.get(i).getCep(),
				salao.get(i).getRua(),
				salao.get(i).getBairro(),
				salao.get(i).getNum(),
				salao.get(i).getQuant_pessoas(),
				salao.get(i).getPreço()
				
				});
		}

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 216, 469, 95);
		numero_cad_text.add(scrollPane_1);

		salao_telTable = new JTable();
		salao_telTable.setForeground(Color.WHITE);
		salao_telTable.setBackground(Color.DARK_GRAY);
		salao_telTable.setModel(new DefaultTableModel(
			new Object[][] {
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
		scrollPane_1.setViewportView(salao_telTable);
		
		
		
		SalaoDao saladao= new SalaoDao();
		ArrayList <Salao> salao2 = new ArrayList();
		salao2 = saladao.getListatel();
		DefaultTableModel modelsalao = (DefaultTableModel) salao_telTable.getModel();
		for(int i =0;i<salao2.size();i++) {
		modelsalao.addRow(new Object[] {
				salao2.get(i).getNum_cadastro(),
				salao2.get(i).getTel()
				});
		}

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 201, 469, 4);
		numero_cad_text.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Num. Cadastro");
		lblNewLabel_2.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/prancheta.png")));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2.setBounds(508, 11, 150, 36);
		numero_cad_text.add(lblNewLabel_2);

		num_cad_text = new JTextField();
		num_cad_text.setColumns(10);
		num_cad_text.setBounds(508, 49, 167, 25);
		numero_cad_text.add(num_cad_text);

		JLabel lblNewLabel_2_1 = new JLabel("Data");
		lblNewLabel_2_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/calendario.png")));
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(508, 77, 96, 35);
		numero_cad_text.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Hora");
		lblNewLabel_2_2.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/relogio.png")));
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(508, 140, 96, 36);
		numero_cad_text.add(lblNewLabel_2_2);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaTela cerimo = null;
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerimo.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 11, 30, 23);
		numero_cad_text.add(btnNewButton_1);

		data_text = new JFormattedTextField(new MaskFormatter("##/##/####"));
		data_text.setColumns(10);
		data_text.setBounds(508, 114, 167, 25);
		numero_cad_text.add(data_text);

		hora_text = new JFormattedTextField(new MaskFormatter("##:##:##"));
		hora_text.setColumns(10);
		hora_text.setBounds(508, 175, 167, 25);
		numero_cad_text.add(hora_text);

		JButton btnNewButton_4 = new JButton("Enviar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num_cad= Integer.parseInt(num_cad_text.getText());
				String data = data_text.getText();
				String hora= hora_text.getText();
				int protocolo = Integer.parseInt(protoco_text.getText());
				
				Encontro en= new Encontro(num_cad, protocolo, data, hora);
				EncontroDao enDao = new EncontroDao();
				
				enDao.update2(en);
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/selecione.png")));
		btnNewButton_4.setOpaque(true);
		btnNewButton_4.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(564, 277, 111, 34);
		numero_cad_text.add(btnNewButton_4);
		
		protoco_text = new JTextField();
		protoco_text.setColumns(10);
		protoco_text.setBounds(508, 236, 167, 25);
		numero_cad_text.add(protoco_text);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Protocolo");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/mulher1.png")));
		lblNewLabel_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(508, 201, 150, 36);
		numero_cad_text.add(lblNewLabel_2_2_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("",
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/perfil-de-usuario.png")), panel_1,
				null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Agenda Clientes");
		lblNewLabel_1_1.setBounds(227, 5, 288, 39);
		lblNewLabel_1_1
				.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/m\u00E3o-clientes.png")));
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
				String.class, String.class, Integer.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		/*EncontroDao adao2 = new EncontroDao();
		ArrayList <Cerimonialista> ceri2 = new ArrayList();
		ceri2 = adao2.getListaTel();
		DefaultTableModel mode = (DefaultTableModel) table_2.getModel();
		for(int i =0;i<ceri2.size();i++) {
			mode.addRow(new Object[] {ceri2.get(i).getProtocolo(),ceri2.get(i).getTel()});
		}*/
		scrollPane_2.setViewportView(table_2);

		JLabel lblNewLabel = new JLabel("C\u00F3digo Cliente");
		lblNewLabel.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/prancheta.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(501, 30, 234, 44);
		panel_1.add(lblNewLabel);

		codigoClie_text = new JTextField();
		codigoClie_text.setBounds(501, 73, 154, 27);
		panel_1.add(codigoClie_text);
		codigoClie_text.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo =Integer.parseInt(codigoClie_text.getText());
				
				EncontroDao enDao1 = new EncontroDao();
				
				enDao1.RemoveEncontro(codigo);
				
				
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/remover.png")));
		btnNewButton.setBounds(511, 110, 40, 39);
		panel_1.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				
				ImageIcon icon2 = new ImageIcon(Tela_principal_Cliente.class.getResource("/img/choque.png"));
				ImageIcon icon = new ImageIcon(Tela_principal_Cliente.class.getResource("/img/surpresa.png"));
				
				if(codigoClie_text.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Digite o código do cliente para aceitar o encontro!!", "Aviso",i, icon2);
					
					
				}else {
					JOptionPane.showInternalMessageDialog(null, "Seu encontro está marcado, agora escolha escolha o salão que deseja!!", "Encontro",i, icon);

				}
				
				
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/verifica.png")));
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(584, 110, 40, 39);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaTela cerimo = null;
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerimo.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_1.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_1.setOpaque(true);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(10, 5, 30, 23);
		panel_1.add(btnNewButton_1_1);
		
		text_protocolo = new JTextField();
		text_protocolo.setColumns(10);
		text_protocolo.setBounds(501, 179, 154, 27);
		panel_1.add(text_protocolo);
		
		text_senha = new JTextField();
		text_senha.setColumns(10);
		text_senha.setBounds(501, 243, 154, 27);
		panel_1.add(text_senha);
		
		JLabel lblNewLabel_3 = new JLabel("Protocolo");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_3.setBounds(501, 138, 234, 44);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha");
		lblNewLabel_3_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(501, 205, 125, 44);
		panel_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocolo = Integer.parseInt(text_protocolo.getText());
				String senha = text_senha.getText();
				
				EncontroDao adao7 = new EncontroDao();
				Encontro a = adao7.verificaEncontroSenha(senha);
				DefaultTableModel model5 = (DefaultTableModel) table_2.getModel();
				model5.addRow(new Object[] {a.getData(),a.getHora(),a.getCodigoclie(),a.getProtocoloceri()});
				
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/MicrosoftTeams-image (6).png")));
		btnNewButton_2_1.setOpaque(true);
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(559, 272, 40, 39);
		panel_1.add(btnNewButton_2_1);
		tabbedPane.setBackgroundAt(2, Color.BLACK);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/alvo.png")), panel_2,
				null);
		tabbedPane.setBackgroundAt(3, Color.BLACK);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Clientes");
		lblNewLabel_1_1_1
				.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/m\u00E3o-clientes.png")));
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(255, 0, 160, 39);
		panel_2.add(lblNewLabel_1_1_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 50, 479, 126);
		panel_2.add(scrollPane_3);

		clienteTable = new JTable();
		clienteTable.setBackground(Color.DARK_GRAY);
		clienteTable.setForeground(Color.WHITE);
		clienteTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "RG", "Email", "Rua", "Bairro", "CEP", "Num", "data_nac"
			}
		));
		scrollPane_3.setViewportView(clienteTable);
		
		ClienteDao adao3 = new ClienteDao();
		ArrayList <Cliente> cli = new ArrayList();
		cli = adao3.getLista();
		DefaultTableModel model3 = (DefaultTableModel) clienteTable.getModel();
		for(int i =0;i<cli.size();i++) {
		model3.addRow(new Object[] {
				cli.get(i).getCodigo(),
				cli.get(i).getNome(),
				cli.get(i).getRg(),
				cli.get(i).getEmail(),
				cli.get(i).getRua(),
				cli.get(i).getBairro(),
				cli.get(i).getCep(),
				cli.get(i).getNum(),
				cli.get(i).getData_nasc(),
				});
		}

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 215, 479, 88);
		panel_2.add(scrollPane_4);

		clienteTelTable = new JTable();
		clienteTelTable.setBackground(Color.DARK_GRAY);
		clienteTelTable.setForeground(Color.WHITE);
		clienteTelTable.setModel(new DefaultTableModel(
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
		scrollPane_4.setViewportView(clienteTelTable);
		
		ClienteDao clidao = new ClienteDao();
		ArrayList <Cliente> listacli = new ArrayList();
		listacli = clidao.getListatel();
		DefaultTableModel modelocli = (DefaultTableModel) clienteTelTable.getModel();
		for(int i =0;i<listacli.size();i++) {
		modelocli.addRow(new Object[] {
				listacli.get(i).getCodigo(),
				listacli.get(i).getTel()
				});
		}

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(499, 50, 1, 253);
		panel_2.add(separator_1);

		pesquisa_text = new JTextField();
		pesquisa_text.setBounds(499, 10, 143, 29);
		panel_2.add(pesquisa_text);
		pesquisa_text.setColumns(10);
		
		codigo1_text = new JTextField();
		codigo1_text.setForeground(Color.WHITE);
		codigo1_text.setBackground(Color.DARK_GRAY);
		codigo1_text.setBounds(510, 43, 170, 29);
		panel_2.add(codigo1_text);
		codigo1_text.setColumns(10);
		
		nome1_text = new JTextField();
		nome1_text.setForeground(Color.WHITE);
		nome1_text.setBackground(Color.DARK_GRAY);
		nome1_text.setColumns(10);
		nome1_text.setBounds(510, 66, 170, 29);
		panel_2.add(nome1_text);
		
		RG1_text = new JTextField();
		RG1_text.setForeground(Color.WHITE);
		RG1_text.setBackground(Color.DARK_GRAY);
		RG1_text.setColumns(10);
		RG1_text.setBounds(510, 93, 170, 29);
		panel_2.add(RG1_text);
		
		email1_text = new JTextField();
		email1_text.setForeground(Color.WHITE);
		email1_text.setBackground(Color.DARK_GRAY);
		email1_text.setColumns(10);
		email1_text.setBounds(510, 119, 170, 29);
		panel_2.add(email1_text);
		
		rua1_text = new JTextField();
		rua1_text.setForeground(Color.WHITE);
		rua1_text.setBackground(Color.DARK_GRAY);
		rua1_text.setColumns(10);
		rua1_text.setBounds(510, 147, 170, 29);
		panel_2.add(rua1_text);
		
		bairro1_text = new JTextField();
		bairro1_text.setForeground(Color.WHITE);
		bairro1_text.setBackground(Color.DARK_GRAY);
		bairro1_text.setColumns(10);
		bairro1_text.setBounds(510, 172, 170, 29);
		panel_2.add(bairro1_text);
		
		CEP1_text = new JTextField();
		CEP1_text.setForeground(Color.WHITE);
		CEP1_text.setBackground(Color.DARK_GRAY);
		CEP1_text.setColumns(10);
		CEP1_text.setBounds(510, 199, 170, 29);
		panel_2.add(CEP1_text);
		
		num1_text = new JTextField();
		num1_text.setForeground(Color.WHITE);
		num1_text.setBackground(Color.DARK_GRAY);
		num1_text.setColumns(10);
		num1_text.setBounds(510, 227, 170, 29);
		panel_2.add(num1_text);
		
		data1_text = new JTextField();
		data1_text.setForeground(Color.WHITE);
		data1_text.setBackground(Color.DARK_GRAY);
		data1_text.setColumns(10);
		data1_text.setBounds(510, 251, 170, 29);
		panel_2.add(data1_text);
		
		tel1_text = new JTextField();
		tel1_text.setForeground(Color.WHITE);
		tel1_text.setColumns(10);
		tel1_text.setBackground(Color.DARK_GRAY);
		tel1_text.setBounds(510, 276, 170, 28);
		panel_2.add(tel1_text);
		
		


		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RG1_text.setText("");
				int codigop= Integer.parseInt(pesquisa_text.getText());
				
				ClienteDao CliAdao= new ClienteDao();
				ArrayList<Cliente> CliList =CliAdao.verificaCliente3(codigop);
							
				Cliente recebe;
			
				for(int i = 0; i< CliList.size();i++) {
				recebe=CliList.get(i);
				codigo1_text.setText(String.valueOf(codigop));
				nome1_text.setText(String.valueOf(recebe.getNome()));
				RG1_text.setText(String.valueOf(recebe.getRg()));
				email1_text.setText(String.valueOf(recebe.getEmail()));
				rua1_text.setText(String.valueOf(recebe.getRua()));
				bairro1_text.setText(String.valueOf(recebe.getBairro()));
				CEP1_text.setText(String.valueOf(recebe.getCep()));
				num1_text.setText(String.valueOf(recebe.getNum()));
				data1_text.setText(String.valueOf(recebe.getData_nasc()));
				tel1_text.setText(String.valueOf(recebe.getTel()));
				}	
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lupa.png")));
		btnNewButton_3.setBounds(640, 9, 39, 29);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaTela cerimo = null;
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerimo.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_2.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_2.setOpaque(true);
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(10, 0, 30, 23);
		panel_2.add(btnNewButton_1_2);
		
		JButton btnNewButton_3_4 = new JButton("");
		btnNewButton_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigo1_text.setText("");
				nome1_text.setText("");
				RG1_text.setText("");
				email1_text.setText("");
				rua1_text.setText("");
				bairro1_text.setText("");
				CEP1_text.setText("");
				num1_text.setText("");
				data1_text.setText("");
				tel1_text.setText("");
				
				
				ClienteDao clidao = new ClienteDao();
				ArrayList<Cliente> CliLista =clidao.getClie();
				
				Cliente recebe;
				
				ImageIcon icon = new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/prancheta.png"));
				
				for(int i=0; i<CliLista.size();i++) {
					recebe= CliLista.get(i);
					JOptionPane.showInternalMessageDialog(null, recebe.getRg(), "RG",i, icon);
				}
								
				
			}
		});
		btnNewButton_3_4.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lupaetel.png")));
		btnNewButton_3_4.setBounds(461, 10, 39, 29);
		panel_2.add(btnNewButton_3_4);
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("",
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lista-de-desejos.png")), panel_3,
				null);
		tabbedPane.setBackgroundAt(4, Color.BLACK);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Lista de Desejos");
		lblNewLabel_1_1_1_1.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lista-de-desejos (1).png")));
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1.setBounds(217, 0, 277, 39);
		panel_3.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton_1_3 = new JButton("");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CerimonialistaTela cerimo = null;
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerimo = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerimo.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1_3.setIcon(
				new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1_3.setOpaque(true);
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setContentAreaFilled(false);
		btnNewButton_1_3.setBackground(Color.WHITE);
		btnNewButton_1_3.setBounds(10, 0, 30, 23);
		panel_3.add(btnNewButton_1_3);
		
		ID_text = new JTextField();
		ID_text.setForeground(Color.BLACK);
		ID_text.setColumns(10);
		ID_text.setBackground(Color.WHITE);
		ID_text.setBounds(10, 77, 106, 34);
		panel_3.add(ID_text);
		
		qnt_pessoas_text = new JTextField();
		qnt_pessoas_text.setForeground(Color.BLACK);
		qnt_pessoas_text.setColumns(10);
		qnt_pessoas_text.setBackground(Color.WHITE);
		qnt_pessoas_text.setBounds(10, 145, 106, 34);
		panel_3.add(qnt_pessoas_text);
		
		deco_text = new JTextField();
		deco_text.setForeground(Color.BLACK);
		deco_text.setColumns(10);
		deco_text.setBackground(Color.WHITE);
		deco_text.setBounds(10, 213, 106, 34);
		panel_3.add(deco_text);
		
		orcamento_text = new JTextField();
		orcamento_text.setForeground(Color.BLACK);
		orcamento_text.setColumns(10);
		orcamento_text.setBackground(Color.WHITE);
		orcamento_text.setBounds(151, 77, 106, 34);
		panel_3.add(orcamento_text);
		
		tamanho_text = new JTextField();
		tamanho_text.setForeground(Color.BLACK);
		tamanho_text.setColumns(10);
		tamanho_text.setBackground(Color.WHITE);
		tamanho_text.setBounds(151, 145, 106, 34);
		panel_3.add(tamanho_text);
		
		cardapio_text = new JTextField();
		cardapio_text.setForeground(Color.BLACK);
		cardapio_text.setColumns(10);
		cardapio_text.setBackground(Color.WHITE);
		cardapio_text.setBounds(151, 213, 106, 34);
		panel_3.add(cardapio_text);
		
		codigo_text = new JTextField();
		codigo_text.setForeground(Color.BLACK);
		codigo_text.setColumns(10);
		codigo_text.setBackground(Color.WHITE);
		codigo_text.setBounds(10, 277, 106, 34);
		panel_3.add(codigo_text);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("ID");
		lblNewLabel_1_2_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(10, 53, 46, 14);
		panel_3.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Quant. Pessoas");
		lblNewLabel_1_2_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_3.setBounds(10, 121, 135, 14);
		panel_3.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Tipo de Decora\u00E7\u00E3o");
		lblNewLabel_1_2_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_4.setBounds(10, 189, 182, 14);
		panel_3.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Or\u00E7amento");
		lblNewLabel_1_2_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_5.setBounds(151, 53, 106, 14);
		panel_3.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("Tamanho do Sal\u00E3o");
		lblNewLabel_1_2_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_6.setBounds(151, 121, 157, 14);
		panel_3.add(lblNewLabel_1_2_6);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("Card\u00E1pio do Buffet");
		lblNewLabel_1_2_7.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_7.setBounds(151, 189, 135, 14);
		panel_3.add(lblNewLabel_1_2_7);
		
		JLabel lblNewLabel_1_2_8 = new JLabel("C\u00F3digo");
		lblNewLabel_1_2_8.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_8.setBounds(10, 251, 79, 23);
		panel_3.add(lblNewLabel_1_2_8);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(304, 145, 364, 102);
		panel_3.add(scrollPane_7);
		
		desejos2Table = new JTable();
		desejos2Table.setBackground(Color.DARK_GRAY);
		desejos2Table.setForeground(Color.WHITE);
		desejos2Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Decora\u00E7\u00E3o", "Codigo", "Protocolo", "Data", "Hora"
			}
		));
		scrollPane_7.setViewportView(desejos2Table);
		
		ListaDeDesejosDao listadao2 = new ListaDeDesejosDao();
		ArrayList <ListaDeDesejos> lista2 = new ArrayList();
		lista2 = listadao2.getLista();
		DefaultTableModel modelo2 = (DefaultTableModel) desejos2Table.getModel();
		for(int i =0;i<lista2.size();i++) {
		modelo2.addRow(new Object[] {
				lista2.get(i).getTipo_Decoraçao(),
				lista2.get(i).getCodigoclie(),
				lista2.get(i).getProtocoloceri(),
				lista2.get(i).getData(),
				lista2.get(i).getHora()
				});
		}
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(304, 49, 364, 86);
		panel_3.add(scrollPane_8);
		
		desejos1Table = new JTable();
		desejos1Table.setForeground(Color.WHITE);
		desejos1Table.setBackground(Color.DARK_GRAY);
		desejos1Table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Or\u00E7amento", "Buffet", "Tam. Sl\u00E3o", "Qnt_Pessoas"
			}
		));
		scrollPane_8.setViewportView(desejos1Table);
		
		
		ListaDeDesejosDao listadao1 = new ListaDeDesejosDao();
		ArrayList <ListaDeDesejos> lista1 = new ArrayList();
		lista1 = listadao1.getLista();
		DefaultTableModel modelo1 = (DefaultTableModel) desejos1Table.getModel();
		for(int i =0;i<lista1.size();i++) {
		modelo1.addRow(new Object[] {
				lista1.get(i).getId(),
				lista1.get(i).getOrçamento(),
				lista1.get(i).getCardapio_buffet(),
				lista1.get(i).getTamanho_salao(),
				lista1.get(i).getQuant_pessoas()
				});
		}
		
		JButton btnNewButton_4_1 = new JButton("Enviar");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id= Integer.parseInt(ID_text.getText());
				int qunt_pessoas= Integer.parseInt(qnt_pessoas_text.getText());
				String decoracao = deco_text.getText();
				Double orcamento = Double.parseDouble(orcamento_text.getText());
				String tamanho = tamanho_text.getText();
				String cardapio = cardapio_text.getText();
				int codigo = Integer.parseInt(codigo_text.getText());
				int protocolo= Integer.parseInt(protocoloceri_text.getText());
				String data2= data2_text.getText();
				String hora2= hora2_text.getText();
				
				ListaDeDesejos lista = new ListaDeDesejos(id, qunt_pessoas, decoracao,orcamento,tamanho, cardapio, codigo, protocolo, data2, hora2);
				
				ListaDeDesejosDao listadao = new ListaDeDesejosDao();
				
				listadao.inserir(lista);
				
			}
		});
		btnNewButton_4_1.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/verifica.png")));
		btnNewButton_4_1.setOpaque(true);
		btnNewButton_4_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnNewButton_4_1.setContentAreaFilled(false);
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.setBounds(545, 272, 123, 41);
		panel_3.add(btnNewButton_4_1);
		
		protocoloceri_text = new JTextField();
		protocoloceri_text.setForeground(Color.BLACK);
		protocoloceri_text.setColumns(10);
		protocoloceri_text.setBackground(Color.WHITE);
		protocoloceri_text.setBounds(151, 277, 106, 34);
		panel_3.add(protocoloceri_text);
		
		JLabel lblNewLabel_1_2_8_1 = new JLabel("Protocolo");
		lblNewLabel_1_2_8_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_8_1.setBounds(151, 251, 79, 23);
		panel_3.add(lblNewLabel_1_2_8_1);
		
		data2_text = new JFormattedTextField(new MaskFormatter("##/##/####"));
		data2_text.setForeground(Color.BLACK);
		data2_text.setColumns(10);
		data2_text.setBackground(Color.WHITE);
		data2_text.setBounds(293, 277, 106, 34);
		panel_3.add(data2_text);
		
		hora2_text =new JFormattedTextField(new MaskFormatter("##:##:##"));
		hora2_text.setForeground(Color.BLACK);
		hora2_text.setColumns(10);
		hora2_text.setBackground(Color.WHITE);
		hora2_text.setBounds(430, 277, 106, 34);
		panel_3.add(hora2_text);
		
		JLabel lblNewLabel_1_2_8_1_1 = new JLabel("Data");
		lblNewLabel_1_2_8_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_8_1_1.setBounds(293, 251, 79, 23);
		panel_3.add(lblNewLabel_1_2_8_1_1);
		
		JLabel lblNewLabel_1_2_8_1_2 = new JLabel("Hora");
		lblNewLabel_1_2_8_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2_8_1_2.setBounds(430, 251, 79, 23);
		panel_3.add(lblNewLabel_1_2_8_1_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lupa.png")), panel_5, null);
		tabbedPane.setBackgroundAt(5, Color.BLACK);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Pesquisa");
		lblNewLabel_1_1_1_1_2.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/MicrosoftTeams-image (6).png")));
		lblNewLabel_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_2.setBounds(257, 11, 277, 39);
		panel_5.add(lblNewLabel_1_1_1_1_2);
		
		pesquisa2_text = new JTextField();
		pesquisa2_text.setColumns(10);
		pesquisa2_text.setBounds(143, 72, 341, 39);
		panel_5.add(pesquisa2_text);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(0, 145, 689, 169);
		panel_5.add(scrollPane_9);
		
		resultadoTable = new JTable();
		resultadoTable.setBackground(Color.DARK_GRAY);
		resultadoTable.setForeground(Color.WHITE);
		resultadoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num. Cadastro", "Nome", "CEP", "Rua", "Bairro", "Num", "Qnt Pessoas", "Pre\u00E7o"
			}
		));
		scrollPane_9.setViewportView(resultadoTable);
		
		JButton btnNewButton_3_3 = new JButton("");
		btnNewButton_3_3.setIcon(new ImageIcon(Tela_principal_Cerimonialista.class.getResource("/img/lupa.png")));
		btnNewButton_3_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int resultado= Integer.parseInt(pesquisa2_text.getText());
				SalaoDao salaoadao = new SalaoDao();
				
				ArrayList<Salao> salaolista = salaoadao.verificaSalao(resultado);
				
				
				SalaoDao salaoAdao = new SalaoDao();
				ArrayList <Salao> salaoList = new ArrayList();
				salaoList = salaoAdao.verificaSalao(resultado);
				DefaultTableModel modelSalao = (DefaultTableModel) resultadoTable.getModel();
				for(int i =0;i<salaoList.size();i++) {
				modelSalao.addRow(new Object[] {
						salaoList.get(i).getNum_cadastro(),
						salaoList.get(i).getNome(),
						salaoList.get(i).getCep(),
						salaoList.get(i).getRua(),
						salaoList.get(i).getBairro(),
						salaoList.get(i).getNum(),
						salaoList.get(i).getQuant_pessoas(),
						salaoList.get(i).getPreço()
						
						});
				}
				
				
				
				
			}
		});
		btnNewButton_3_3.setBounds(494, 74, 40, 37);
		panel_5.add(btnNewButton_3_3);
		
		
		
		
	}
}

