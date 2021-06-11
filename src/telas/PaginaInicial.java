package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PaginaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PaginaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema Escolar");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btCadastro = new JButton("Aluno");
		btCadastro.setIcon(new ImageIcon(PaginaInicial.class.getResource("/imagens/alunonow.png")));
		btCadastro.setFocusable(false);
		btCadastro.setRequestFocusEnabled(false);
		btCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btCadastro.setForeground(Color.DARK_GRAY);
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroAluno cadastro = new CadastroAluno();
				cadastro.setVisible(true);
			}
		});
		JLabel lblNewLabel_3 = new JLabel("Por Lucas Cruz");
		lblNewLabel_3.setBounds(10, 200, 80, 79);
		contentPane.add(lblNewLabel_3);
		JButton btBoletim = new JButton("Boletim");
		btBoletim.setIcon(new ImageIcon(PaginaInicial.class.getResource("/imagens/2_atualizar_aluno_x32.png")));
		btBoletim.setFocusable(false);
		btBoletim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btBoletim.setForeground(Color.DARK_GRAY);
		btBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boletim boletim = new Boletim();
				boletim.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(btBoletim, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btCadastro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(63))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btBoletim, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btCadastro, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
					.addGap(121))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
