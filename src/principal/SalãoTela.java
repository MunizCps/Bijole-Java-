package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bean.Salao;
import dao.SalaoDao;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class SalãoTela extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JTextField text_nomeL;
	private JLabel lblSenha_1;
	private JTextField textField_3;
	private JButton entrar;
	private JTextField text_nome;
	private JTextField text_numcad;
	private JTextField text_quant;
	private JTextField text_rua;
	private JTextField text_preco;
	private JTextField text_bairro;
	private JTextField text_cep;
	private JTextField text_num;
	private JTextField text_numtel;
	private JTextField text_tel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton cadastrar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalãoTela frame = new SalãoTela();
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
	public SalãoTela() throws ParseException {
		setType(Type.UTILITY);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		tabbedPane.addTab("", new ImageIcon(SalãoTela.class.getResource("/img/selecionado.png")), panel, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(237, 122, 85, 20);
		panel.add(lblNewLabel_2);
		
		text_nomeL = new JTextField();
		text_nomeL.setForeground(Color.BLACK);
		text_nomeL.setColumns(10);
		text_nomeL.setBackground(Color.WHITE);
		text_nomeL.setBounds(237, 144, 180, 31);
		panel.add(text_nomeL);
		
		lblSenha_1 = new JLabel("num_cadastro ");
		lblSenha_1.setForeground(Color.BLACK);
		lblSenha_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSenha_1.setBounds(237, 188, 160, 20);
		panel.add(lblSenha_1);
		
		JPasswordField text_numL = new JPasswordField();
		text_numL.setForeground(Color.BLACK);
		text_numL.setColumns(10);
		text_numL.setBackground(Color.WHITE);
		text_numL.setBounds(237, 208, 180, 31);
		panel.add(text_numL);
		
		entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeL = text_nomeL.getText();
				int numL = Integer.parseInt(text_numL.getText());
				SalaoDao adao2 = new SalaoDao();
				Salao a = adao2.login(numL, nomeL);
				if(a == null) {
					JOptionPane.showMessageDialog(null,"Este Salão não está cadastrado!!!");
				}else {
					Tela_principal_Salao TPC = null;
					try {
						TPC = new Tela_principal_Salao();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						TPC= new Tela_principal_Salao();
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
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/salao.png")));
		lblNewLabel_7.setBounds(161, 11, 377, 71);
		panel.add(lblNewLabel_7);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 11, 30, 23);
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(SalãoTela.class.getResource("/img/grupo.png")), panel_1, null);
		panel_1.setLayout(null);
		
		text_nome = new JTextField();
		text_nome.setForeground(Color.BLACK);
		text_nome.setBackground(Color.WHITE);
		text_nome.setBounds(54, 116, 104, 26);
		panel_1.add(text_nome);
		text_nome.setColumns(10);
		
		text_numcad = new JTextField();
		text_numcad.setForeground(Color.BLACK);
		text_numcad.setColumns(10);
		text_numcad.setBackground(Color.WHITE);
		text_numcad.setBounds(220, 116, 104, 26);
		panel_1.add(text_numcad);
		
		text_quant = new JTextField();
		text_quant.setForeground(Color.BLACK);
		text_quant.setColumns(10);
		text_quant.setBackground(Color.WHITE);
		text_quant.setBounds(388, 116, 104, 26);
		panel_1.add(text_quant);
		
		text_rua = new JTextField();
		text_rua.setForeground(Color.BLACK);
		text_rua.setColumns(10);
		text_rua.setBackground(Color.WHITE);
		text_rua.setBounds(54, 218, 104, 26);
		panel_1.add(text_rua);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(54, 91, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u00FAmero Cadastro");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(220, 85, 154, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quant. Pessoas");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(387, 85, 141, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(538, 85, 125, 26);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		text_preco = new JTextField();
		text_preco.setForeground(Color.BLACK);
		text_preco.setColumns(10);
		text_preco.setBackground(Color.WHITE);
		text_preco.setBounds(538, 116, 104, 26);
		panel_1.add(text_preco);
		
		text_bairro = new JTextField();
		text_bairro.setForeground(Color.BLACK);
		text_bairro.setColumns(10);
		text_bairro.setBackground(Color.WHITE);
		text_bairro.setBounds(220, 218, 104, 26);
		panel_1.add(text_bairro);
		
		text_cep = new JTextField();
		text_cep.setForeground(Color.BLACK);
		text_cep.setColumns(10);
		text_cep.setBackground(Color.WHITE);
		text_cep.setBounds(538, 218, 104, 26);
		panel_1.add(text_cep);
		
		text_num = new JTextField();
		text_num.setForeground(Color.BLACK);
		text_num.setColumns(10);
		text_num.setBackground(Color.WHITE);
		text_num.setBounds(388, 218, 104, 26);
		panel_1.add(text_num);
		
		JLabel lblNewLabel_1_2 = new JLabel("Rua");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(56, 193, 46, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Bairro");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(220, 193, 70, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("N\u00FAmero");
		lblNewLabel_1_5.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(388, 193, 88, 14);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("CEP");
		lblNewLabel_1_6.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(538, 193, 46, 14);
		panel_1.add(lblNewLabel_1_6);
		
		JButton Continuar = new JButton("Continuar");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = text_nome.getText();
				String rua = text_rua.getText();
				int Num_cad = Integer.parseInt(text_numcad.getText());
				String bairro = text_bairro.getText();
				int quant =Integer.parseInt(text_quant.getText());
				int num = Integer.parseInt(text_num.getText());
				double preço =  Double.valueOf(text_preco.getText()).doubleValue();
				String cep = text_cep.getText();	
				
				Salao s = new Salao(nome,preço,quant,Num_cad,bairro,cep,rua,num);
				SalaoDao adao = new SalaoDao();
				adao.inserir(s);
			}
		});
		Continuar.setContentAreaFilled(false);
		Continuar.setOpaque(true);
		Continuar.setBackground(new Color(30, 144, 255));
		Continuar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		Continuar.setBounds(527, 277, 115, 26);
		panel_1.add(Continuar);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/salao.png")));
		lblNewLabel_6.setBounds(149, 0, 393, 96);
		panel_1.add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);

				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 11, 30, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(SalãoTela.class.getResource("/img/telefone.png")), panel_2, null);
		panel_2.setLayout(null);
		
		text_numtel = new JTextField();
		text_numtel.setBounds(36, 101, 154, 29);
		panel_2.add(text_numtel);
		text_numtel.setColumns(10);
		
		text_tel=new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		text_tel.setColumns(10);
		text_tel.setBounds(36, 181, 154, 29);
		panel_2.add(text_tel);
		
		lblNewLabel_3 = new JLabel("N\u00FAmero Cadastro");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(36, 61, 173, 29);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(36, 141, 99, 29);
		panel_2.add(lblNewLabel_4);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num_cadtel = Integer.parseInt(text_numtel.getText());
				String tel = text_tel.getText();
				Salao sa = new Salao(num_cadtel,tel);
				SalaoDao adao1 = new SalaoDao();
				adao1.insert(sa);
			}
		});
		cadastrar.setContentAreaFilled(false);
		cadastrar.setOpaque(true);
		cadastrar.setBackground(new Color(30, 144, 255));
		cadastrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cadastrar.setBounds(36, 265, 118, 29);
		panel_2.add(cadastrar);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/salao.png")));
		lblNewLabel_5.setBounds(168, 0, 365, 72);
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SalãoTela.class.getResource("/img/coala-pc.png")));
		lblNewLabel.setBounds(355, 72, 314, 250);
		panel_2.add(lblNewLabel);
	}
}
