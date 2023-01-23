package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bean.Fisica;
import bean.Cliente;
import dao.ClienteDao;
import dao.FisicaDao;

public class ClienteTela extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField text_codigoL;
	private JTextField textField_3;
	private JButton entrar;
	private JLabel lblNewLabel;
	private JTextField text_nome;
	private JTextField text_codigo;
	private JTextField text_RG;
	private JTextField text_email;
	private JTextField text_rua;
	private JTextField text_num;
	private JTextField text_bairro;
	private JTextField text_cep;
	private JTextField CPF_text;
	private JTextField CNPJ_text;
	private JLabel CNPJ_label;
	private JTextField text_Codigotel;
	private JTextField text_tel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton cadastrar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_8;
	private JTextField text_data;
	private JButton btnNewButton_1;
	private JTextField text_senha;
	private JLabel lblSenha;
	private JLabel lblSenha_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteTela frame = new ClienteTela();
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
	public ClienteTela() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.UTILITY);
		setForeground(Color.BLACK);
		setBounds(100, 100, 700, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 684, 371);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(Color.BLACK);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(ClienteTela.class.getResource("/img/selecionado.png")), panel, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel.setLayout(null);
		
		text_codigoL = new JTextField();
		text_codigoL.setForeground(Color.BLACK);
		text_codigoL.setColumns(10);
		text_codigoL.setBackground(Color.WHITE);
		text_codigoL.setBounds(237, 144, 180, 31);
		panel.add(text_codigoL);
		
		
		JPasswordField text_senhaL = new JPasswordField();
		text_senhaL.setForeground(Color.BLACK);
		text_senhaL.setColumns(10);
		text_senhaL.setBackground(Color.WHITE);
		text_senhaL.setBounds(237, 208, 180, 31);
		panel.add(text_senhaL);
		
		entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoL =Integer.parseInt(text_codigoL.getText());
				String senhaL = text_senhaL.getText();
				
				ClienteDao adao2 = new ClienteDao();
				Cliente a = adao2.login(codigoL, senhaL);
				System.out.println(codigoL);
				System.out.println(senhaL);
				System.out.println(a);
				if(a == null) {
					JOptionPane.showMessageDialog(null,"Este usuario não está cadastrado!!!");
				}else {
				Tela_principal_Cliente TPC = null;
				try {
					TPC = new Tela_principal_Cliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					TPC= new Tela_principal_Cliente();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TPC.setVisible(true);

				dispose();
			}
			}
			
		});
		
		entrar.setContentAreaFilled(false);
		entrar.setOpaque(true);
		entrar.setBackground(new Color(30, 144, 255));
		entrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		entrar.setBounds(282, 268, 89, 23);
		panel.add(entrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/clientes.png")));
		lblNewLabel.setBounds(185, 29, 289, 58);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton.setBounds(10, 11, 30, 23);
		panel.add(btnNewButton);
		
		lblSenha = new JLabel("Codigo");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSenha.setBounds(237, 115, 85, 20);
		panel.add(lblSenha);
		
		lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setForeground(Color.BLACK);
		lblSenha_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSenha_1.setBounds(237, 177, 85, 20);
		panel.add(lblSenha_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(ClienteTela.class.getResource("/img/grupo.png")), panel_1, null);
		panel_1.setLayout(null);
		
		text_nome = new JTextField();
		text_nome.setForeground(Color.BLACK);
		text_nome.setBackground(Color.WHITE);
		text_nome.setBounds(54, 99, 104, 26);
		panel_1.add(text_nome);
		text_nome.setColumns(10);
		
		text_codigo = new JTextField();
		text_codigo.setForeground(Color.BLACK);
		text_codigo.setColumns(10);
		text_codigo.setBackground(Color.WHITE);
		text_codigo.setBounds(54, 161, 104, 26);
		panel_1.add(text_codigo);
		
		text_RG = new JTextField();
		text_RG.setForeground(Color.BLACK);
		text_RG.setColumns(10);
		text_RG.setBackground(Color.WHITE);
		text_RG.setBounds(54, 218, 104, 26);
		panel_1.add(text_RG);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(56, 74, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(54, 136, 70, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RG");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(54, 195, 70, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Data Nascimento");
		lblNewLabel_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(54, 255, 125, 26);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		text_email = new JTextField();
		text_email.setForeground(Color.BLACK);
		text_email.setColumns(10);
		text_email.setBackground(Color.WHITE);
		text_email.setBounds(269, 99, 104, 26);
		panel_1.add(text_email);
		
		text_rua = new JTextField();
		text_rua.setForeground(Color.BLACK);
		text_rua.setColumns(10);
		text_rua.setBackground(Color.WHITE);
		text_rua.setBounds(269, 161, 104, 26);
		panel_1.add(text_rua);
		
		text_num = new JTextField();
		text_num.setForeground(Color.BLACK);
		text_num.setColumns(10);
		text_num.setBackground(Color.WHITE);
		text_num.setBounds(269, 218, 104, 26);
		panel_1.add(text_num);
		
		text_bairro = new JTextField();
		text_bairro.setForeground(Color.BLACK);
		text_bairro.setColumns(10);
		text_bairro.setBackground(Color.WHITE);
		text_bairro.setBounds(269, 282, 104, 26);
		panel_1.add(text_bairro);
		
		text_cep = new JTextField();
		text_cep.setForeground(Color.BLACK);
		text_cep.setColumns(10);
		text_cep.setBackground(Color.WHITE);
		text_cep.setBounds(502, 99, 104, 26);
		panel_1.add(text_cep);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(269, 74, 46, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Rua");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(269, 142, 70, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("N\u00FAmero");
		lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(269, 201, 88, 14);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Bairro");
		lblNewLabel_1_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(269, 267, 46, 14);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("CEP");
		lblNewLabel_1_7.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(502, 74, 46, 14);
		panel_1.add(lblNewLabel_1_7);
		
		JComboBox pessoaComboBox = new JComboBox();
		pessoaComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(pessoaComboBox.getSelectedItem().equals("Pessoa Física")) {
					 CPF_text.enable(true);
					 lblNewLabel_8.setEnabled(true);
				
					 
					 CNPJ_text.enable(false);
					 CNPJ_label.enable(false);
					 
				 }else if (pessoaComboBox.getSelectedItem().equals("Pessoa jurídica")) {
					 CNPJ_text.enable(true);
					 CNPJ_label.enable(true);
					 
					 CPF_text.enable(false);
					 lblNewLabel_8.setEnabled(false);
					 
				 }else {
					 
					 CNPJ_text.enable(false);
					 CNPJ_label.enable(false);
					 
					 CPF_text.enable(false);
					 lblNewLabel_8.setEnabled(false);
					 
				 }
			}
		});
		pessoaComboBox.setForeground(Color.WHITE);
		pessoaComboBox.setBackground(Color.BLACK);
		pessoaComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Pessoa F\u00EDsica", "Pessoa jur\u00EDdica"}));
		pessoaComboBox.setBounds(502, 150, 104, 24);
		panel_1.add(pessoaComboBox);
		
		CPF_text=new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		CPF_text.setEnabled(false);
		CPF_text.setForeground(Color.BLACK);
		CPF_text.setColumns(10);
		CPF_text.setBackground(Color.WHITE);
		CPF_text.setBounds(427, 208, 104, 26);
		panel_1.add(CPF_text);
		
		CNPJ_text=new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		CNPJ_text.setEnabled(false);
		CNPJ_text.setForeground(Color.BLACK);
		CNPJ_text.setColumns(10);
		CNPJ_text.setBackground(Color.WHITE);
		CNPJ_text.setBounds(565, 208, 104, 26);
		panel_1.add(CNPJ_text);
		
		lblNewLabel_8 = new JLabel("CPF");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_8.setBounds(427, 191, 46, 14);
		panel_1.add(lblNewLabel_8);
		
		CNPJ_label = new JLabel("CNPJ");
		CNPJ_label.setEnabled(false);
		CNPJ_label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		CNPJ_label.setBounds(565, 191, 88, 14);
		panel_1.add(CNPJ_label);
		
		JButton Continuar = new JButton("Continuar");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = text_nome.getText();
				int codigo = Integer.parseInt(text_codigo.getText());
				String RG = text_RG.getText();
				String data_nasc = text_data.getText();
				String email = text_email.getText();
				String rua = text_rua.getText();
				int num = Integer.parseInt(text_num.getText());
				String bairro= text_bairro.getText();
				String CEP= text_cep.getText();
				String senha = text_senha.getText();
				//String CPF = CPF_text.getText();
				//String CPNJ = CNPJ_text.getText();
				
				Cliente c = new Cliente(nome,email,RG,codigo,data_nasc,CEP,rua,bairro,num,senha);
				ClienteDao adao = new ClienteDao();
				adao.inserir(c);
				if(pessoaComboBox.getSelectedItem().equals("Selecione")) {
					JOptionPane.showMessageDialog(null, "Escolha uma opção!!");
				
					
				}
				if(pessoaComboBox.getSelectedItem().equals("Pessoa Física")){
					String CPF = CPF_text.getText(); 
					Fisica f = new Fisica(CPF,codigo);
					FisicaDao adao10 = new FisicaDao();
					adao10.inserir(f);
					
				}else if (pessoaComboBox.getSelectedItem().equals("Pessoa jurídica")) {
					String CPNJ = CNPJ_text.getText();
				}
			}
		});
		Continuar.setContentAreaFilled(false);
		Continuar.setOpaque(true);
		Continuar.setBackground(new Color(30, 144, 255));
		Continuar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		Continuar.setBounds(527, 277, 115, 26);
		panel_1.add(Continuar);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/clientes.png")));
		lblNewLabel_6.setBounds(180, -17, 289, 96);
		panel_1.add(lblNewLabel_6);
		
		text_data=new JFormattedTextField(new MaskFormatter("##/##/####"));
		text_data.setForeground(Color.BLACK);
		text_data.setColumns(10);
		text_data.setBackground(Color.WHITE);
		text_data.setBounds(54, 285, 104, 26);
		panel_1.add(text_data);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 11, 30, 23);
		panel_1.add(btnNewButton_1);
		
		text_senha = new JTextField();
		text_senha.setForeground(Color.BLACK);
		text_senha.setColumns(10);
		text_senha.setBackground(Color.WHITE);
		text_senha.setBounds(388, 99, 104, 26);
		panel_1.add(text_senha);
		
		JLabel senha = new JLabel("Senha");
		senha.setFont(new Font("Century Gothic", Font.BOLD, 14));
		senha.setBounds(388, 76, 46, 14);
		panel_1.add(senha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(ClienteTela.class.getResource("/img/telefone.png")), panel_2, null);
		panel_2.setLayout(null);
		
		text_Codigotel = new JTextField();
		text_Codigotel.setBounds(36, 101, 154, 29);
		panel_2.add(text_Codigotel);
		text_Codigotel.setColumns(10);
		
		text_tel=new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		text_tel.setColumns(10);
		text_tel.setBounds(36, 181, 154, 29);
		panel_2.add(text_tel);
		
		lblNewLabel_3 = new JLabel("C\u00F3gido");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(36, 61, 99, 29);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(36, 141, 99, 29);
		panel_2.add(lblNewLabel_4);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoTel = Integer.parseInt(text_Codigotel.getText());
				String tel = text_tel.getText();
				Cliente cad = new Cliente(codigoTel,tel);
				ClienteDao adao3 = new ClienteDao();
				adao3.insert(cad);
			}
		});
		cadastrar.setContentAreaFilled(false);
		cadastrar.setOpaque(true);
		cadastrar.setBackground(new Color(30, 144, 255));
		cadastrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cadastrar.setBounds(36, 265, 118, 29);
		panel_2.add(cadastrar);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/clientes.png")));
		lblNewLabel_5.setBounds(203, 0, 259, 64);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(ClienteTela.class.getResource("/img/coala-pc.png")));
		lblNewLabel_7.setBounds(382, 61, 309, 261);
		panel_2.add(lblNewLabel_7);
	}
}
