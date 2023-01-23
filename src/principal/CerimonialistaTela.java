package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import bean.Cerimonialista;
import dao.CerimonialistaDao;

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
import javax.swing.JSeparator;

public class CerimonialistaTela extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel cadastro;
	private JLabel lblNewLabel_2;
	private JTextField text_ProtocoloL;
	private JLabel lblSenha_1;
	private JTextField textField_3;
	private JButton entrar;
	private JLabel lblNewLabel;
	private JTextField text_cpf;
	private JTextField text_protocolotel;
	private JTextField text_tel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton cadastrar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_5;
	private JTextField text_protocolo;
	private JTextField text_nome;
	private JTextField text_email;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField text_senhaC;
	private JLabel lblNewLabel_1_4;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CerimonialistaTela frame = new CerimonialistaTela();
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
	public CerimonialistaTela() throws ParseException {
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
		tabbedPane.addTab("", new ImageIcon(CerimonialistaTela.class.getResource("/img/selecionado.png")), panel, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Protocolo");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(237, 122, 85, 20);
		panel.add(lblNewLabel_2);
		
		text_ProtocoloL = new JTextField();
		text_ProtocoloL.setForeground(Color.BLACK);
		text_ProtocoloL.setColumns(10);
		text_ProtocoloL.setBackground(Color.WHITE);
		text_ProtocoloL.setBounds(237, 144, 180, 31);
		panel.add(text_ProtocoloL);
		
		lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setForeground(Color.BLACK);
		lblSenha_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSenha_1.setBounds(237, 188, 85, 20);
		panel.add(lblSenha_1);
		
		JPasswordField text_senhaL = new JPasswordField();
		text_senhaL.setEchoChar('*');
		text_senhaL.setForeground(Color.BLACK);
		text_senhaL.setColumns(10);
		text_senhaL.setBackground(Color.WHITE);
		text_senhaL.setBounds(237, 208, 180, 31);
		panel.add(text_senhaL);
		
		entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocoloL = Integer.parseInt(text_ProtocoloL.getText());
				String senhaL = text_senhaL.getText();
				CerimonialistaDao adao4 = new CerimonialistaDao();
				Cerimonialista a = adao4.login(protocoloL, senhaL);
				if(a == null) {
					JOptionPane.showMessageDialog(null,"Este usuario não está cadastrado!!!");
				}else {
				Tela_principal_Cerimonialista TPCE = null;
				try {
					TPCE = new Tela_principal_Cerimonialista();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					TPCE= new Tela_principal_Cerimonialista();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TPCE.setVisible(true);

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
		lblNewLabel.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/cerimonialista.png")));
		lblNewLabel.setBounds(185, 29, 289, 58);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);

				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 11, 30, 23);
		panel.add(btnNewButton);
		
		cadastro = new JPanel();
		cadastro.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(CerimonialistaTela.class.getResource("/img/grupo.png")), cadastro, null);
		cadastro.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(130, 83, 46, 14);
		cadastro.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Protocolo");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(130, 145, 70, 26);
		cadastro.add(lblNewLabel_1_1);
		
		text_cpf=new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		text_cpf.setForeground(Color.BLACK);
		text_cpf.setColumns(10);
		text_cpf.setBackground(Color.WHITE);
		text_cpf.setBounds(395, 182, 141, 34);
		cadastro.add(text_cpf);
		
		JLabel lblNewLabel_1_2 = new JLabel("E-mail");
		lblNewLabel_1_2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(395, 83, 46, 14);
		cadastro.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CPF");
		lblNewLabel_1_3.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(399, 151, 70, 14);
		cadastro.add(lblNewLabel_1_3);
		
		JButton Continuar = new JButton("Continuar");
		Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = text_nome.getText();
				int protocolo = Integer.parseInt(text_protocolo.getText());
				String email = text_email.getText();
				String cpf = text_cpf.getText();
				String senha = text_senhaC.getText();
				
				Cerimonialista c = new Cerimonialista(protocolo,email,cpf,nome,senha);
				CerimonialistaDao adao = new CerimonialistaDao();
				adao.inserirC(c);
			}
		});
		Continuar.setContentAreaFilled(false);
		Continuar.setOpaque(true);
		Continuar.setBackground(new Color(30, 144, 255));
		Continuar.setFont(new Font("Century Gothic", Font.BOLD, 13));
		Continuar.setBounds(527, 277, 115, 26);
		cadastro.add(Continuar);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/cerimonialista.png")));
		lblNewLabel_6.setBounds(180, -17, 289, 96);
		cadastro.add(lblNewLabel_6);
		
		text_protocolo = new JTextField();
		text_protocolo.setForeground(Color.BLACK);
		text_protocolo.setColumns(10);
		text_protocolo.setBackground(Color.WHITE);
		text_protocolo.setBounds(130, 182, 141, 34);
		cadastro.add(text_protocolo);
		
		text_nome = new JTextField();
		text_nome.setForeground(Color.BLACK);
		text_nome.setColumns(10);
		text_nome.setBackground(Color.WHITE);
		text_nome.setBounds(130, 108, 141, 34);
		cadastro.add(text_nome);
		
		text_email = new JTextField();
		text_email.setForeground(Color.BLACK);
		text_email.setColumns(10);
		text_email.setBackground(Color.WHITE);
		text_email.setBounds(395, 108, 141, 34);
		cadastro.add(text_email);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal = new Principal();	
				principal.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/seta-para-a-esquerda.png")));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 11, 30, 23);
		cadastro.add(btnNewButton_1);
		
		text_senhaC = new JTextField();
		text_senhaC.setForeground(Color.BLACK);
		text_senhaC.setColumns(10);
		text_senhaC.setBackground(Color.WHITE);
		text_senhaC.setBounds(130, 254, 141, 34);
		cadastro.add(text_senhaC);
		
		lblNewLabel_1_4 = new JLabel("Senha");
		lblNewLabel_1_4.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(130, 228, 70, 26);
		cadastro.add(lblNewLabel_1_4);
		
		JPanel telefone = new JPanel();
		telefone.setBackground(Color.WHITE);
		tabbedPane.addTab("", new ImageIcon(CerimonialistaTela.class.getResource("/img/telefone.png")), telefone, null);
		telefone.setLayout(null);
		
		text_protocolotel = new JTextField();
		text_protocolotel.setBounds(36, 101, 154, 29);
		telefone.add(text_protocolotel);
		text_protocolotel.setColumns(10);
		
		text_tel=new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		text_tel.setColumns(10);
		text_tel.setBounds(36, 181, 154, 29);
		telefone.add(text_tel);
		
		lblNewLabel_3 = new JLabel("Protocolo");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_3.setBounds(36, 61, 99, 29);
		telefone.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Telefone");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(36, 141, 99, 29);
		telefone.add(lblNewLabel_4);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int protocoloTel = Integer.parseInt(text_protocolotel.getText());
				String tel = text_tel.getText();
				Cerimonialista ca = new Cerimonialista(protocoloTel,tel);
				CerimonialistaDao adao1 = new CerimonialistaDao();
				adao1.insert(ca);
			}
		});
		cadastrar.setContentAreaFilled(false);
		cadastrar.setOpaque(true);
		cadastrar.setBackground(new Color(30, 144, 255));
		cadastrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		cadastrar.setBounds(36, 265, 118, 29);
		telefone.add(cadastrar);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/cerimonialista.png")));
		lblNewLabel_5.setBounds(202, -2, 252, 62);
		telefone.add(lblNewLabel_5);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(CerimonialistaTela.class.getResource("/img/coala-pc.png")));
		lblNewLabel_7.setBounds(365, 61, 314, 250);
		telefone.add(lblNewLabel_7);
	}
}
