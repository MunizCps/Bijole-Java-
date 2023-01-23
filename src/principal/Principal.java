package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setType(Type.UTILITY);
		setBackground(Color.BLACK);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton cerimonialista = new JButton("Cadastre-se ou Entre");
		cerimonialista.setBorderPainted(false); 
		cerimonialista.setContentAreaFilled(false); 
		cerimonialista.setFocusPainted(false);
		cerimonialista.setFont(new Font("Century Gothic", Font.BOLD, 11));
		cerimonialista.setContentAreaFilled(false);
		cerimonialista.setOpaque(true);
		cerimonialista.setBackground(Color.white);
		cerimonialista.setForeground(Color.BLACK);
		cerimonialista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CerimonialistaTela cerim = null;
				try {
					cerim = new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cerim= new CerimonialistaTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cerim.setVisible(true);

				dispose();
				
			}
		});
		cerimonialista.setBounds(486, 265, 147, 30);
		contentPane.add(cerimonialista);
		
		JButton salao = new JButton("Cadastre-se ou Entre");
		salao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalãoTela sal = null;
				try {
					sal = new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					sal= new SalãoTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sal.setVisible(true);

				dispose();
				
			}
		});
		salao.setFont(new Font("Century Gothic", Font.BOLD, 11));
		salao.setContentAreaFilled(false);
		salao.setOpaque(true);
		salao.setBackground(Color.white);
		salao.setForeground(Color.BLACK);
		salao.setBounds(268, 299, 147, 30);
		contentPane.add(salao);
		
		JButton Cliente = new JButton("Cadastre-se ou Entre");
		Cliente.setFont(new Font("Century Gothic", Font.BOLD, 11));
		Cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteTela cliente = null;
				try {
					cliente = new ClienteTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					cliente= new ClienteTela();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cliente.setVisible(true);

				dispose();
				
			}
		});
		Cliente.setOpaque(false);
		Cliente.setContentAreaFilled(false);
		Cliente.setOpaque(true);
		Cliente.setBackground(new Color(255, 255, 255));
		Cliente.setForeground(Color.BLACK);
		Cliente.setBounds(62, 265, 149, 30);
		contentPane.add(Cliente);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/alvo.png")));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(84, 232, 109, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblSalo = new JLabel("Sal\u00E3o");
		lblSalo.setIcon(new ImageIcon(Principal.class.getResource("/img/balao-de-ar.png")));
		lblSalo.setForeground(Color.WHITE);
		lblSalo.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblSalo.setBounds(300, 272, 89, 23);
		contentPane.add(lblSalo);
		
		JLabel lblCerimonialista = new JLabel("Cerimonialista");
		lblCerimonialista.setIcon(new ImageIcon(Principal.class.getResource("/img/mulher1.png")));
		lblCerimonialista.setForeground(Color.WHITE);
		lblCerimonialista.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblCerimonialista.setBounds(470, 216, 188, 63);
		contentPane.add(lblCerimonialista);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/img/pronto.png")));
		lblNewLabel_1.setBounds(49, 47, 463, 140);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 255));
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(10, 11, 1, 338);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(673, 11, 1, 338);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 11, 664, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 347, 664, 2);
		contentPane.add(separator_3);
	}
}
