package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.Conexao;

public class CadastroAluno extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// variaveis para a persistência no BD
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfEmail;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	});			
	}
	


	public CadastroAluno() {
	
		//adiciona a conexão no banco de dados
		conexao = Conexao.conector();
		setResizable(false);
		setTitle("Sistema Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aluno");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(470, 78, 67, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(10, 133, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("E- mail");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(10, 198, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CPF");
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btVoltar = new JButton("");
		btVoltar.setFocusPainted(false);
		btVoltar.setFocusTraversalKeysEnabled(false);
		btVoltar.setFocusable(false);
		btVoltar.setHorizontalTextPosition(SwingConstants.LEFT);
		btVoltar.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/arrow_blue_x18.png")));
		btVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btVoltar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PaginaInicial paginaInicial = new PaginaInicial();
				paginaInicial.setVisible(true);
				//fechar a janela anterior
				dispose();
			}
		});
		btVoltar.setForeground(Color.DARK_GRAY);
		btVoltar.setBounds(10, 19, 46, 27);
		contentPane.add(btVoltar);
		
		JButton btCadastrar = new JButton("");
		btCadastrar.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/3_add_x32.png")));
		btCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {				
			cadastrar();	
			}
		});
		btCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btCadastrar.setForeground(Color.DARK_GRAY);
		btCadastrar.setBounds(223, 275, 67, 41);
		contentPane.add(btCadastrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/student.png")));
		lblNewLabel_2.setBounds(460, 7, 80, 79);
		contentPane.add(lblNewLabel_2);
		
		JButton btConsultar = new JButton("");
		btConsultar.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/1_consultar_aluno_x32.png")));
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		btConsultar.setHorizontalAlignment(SwingConstants.LEFT);
		btConsultar.setForeground(Color.DARK_GRAY);
		btConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btConsultar.setBounds(69, 275, 67, 41);
		contentPane.add(btConsultar);
		
		JButton btAlterar = new JButton("");
		btAlterar.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/2_atualizar_aluno_x32.png")));
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterar();
			}
		});
		btAlterar.setHorizontalAlignment(SwingConstants.LEFT);
		btAlterar.setForeground(Color.DARK_GRAY);
		btAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btAlterar.setBounds(146, 275, 67, 41);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("");
		btExcluir.setIcon(new ImageIcon(CadastroAluno.class.getResource("/imagens/4_excluir_aluno_x32.png")));
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btExcluir.setHorizontalAlignment(SwingConstants.LEFT);
		btExcluir.setForeground(Color.DARK_GRAY);
		btExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btExcluir.setBounds(300, 275, 67, 41);
		contentPane.add(btExcluir);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(10, 102, 123, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 158, 426, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(10, 223, 426, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
	}
	
	private void cadastrar() {
		String sql = "insert into tbalunos (cpfaluno, nomealu, emailalu) values (?,?,?)";
		
		try {
			
			pst = conexao.prepareStatement(sql);
			System.out.println("Pegou sql");
			pst.setString(1, tfCpf.getText());
			
			pst.setString(2, tfNome.getText());
			pst.setString(3, tfEmail.getText());
			
			int adicionado = pst.executeUpdate();
			
			if (adicionado > 0) {
				JOptionPane.showMessageDialog(null, "Aluno cadastrado");
				tfCpf.setText(null);
				tfNome.setText(null);
				tfEmail.setText(null);
			} 
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e);
		}

	}


	private void consultar() {
		String sql = "select * from tbalunos where cpfaluno=?";
		try {
			pst = conexao.prepareStatement(sql);
			pst.setString(1,tfCpf.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				tfNome.setText(rs.getString(2));
				tfEmail.setText(rs.getString(3));
			
			
			} else {
				JOptionPane.showMessageDialog(null,"Aluno não cadastrado!");
				tfCpf.setText(null);
				tfNome.setText(null);
				tfEmail.setText(null);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	private void alterar() {
		String sql = ("update tbalunos set nomealu=?, emailalu=? WHERE cpfaluno=?");
		try {
			pst = conexao.prepareStatement(sql);
			//pst.setString(1,tfCpf.getText());
			pst.setString(1,tfNome.getText());
			pst.setString(2,tfEmail.getText());	
			pst.setString(3,tfCpf.getText());
			int adicionado =  pst.executeUpdate();
			if (adicionado > 0) {
				JOptionPane.showMessageDialog(null, "Dados do aluno atualizados.");
				tfNome.setText(null);
				tfEmail.setText(null);
				tfCpf.setText(null);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	private void excluir() {
		int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja remover o aluno?", "Atenção", JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from tbalunos where cpfaluno=?";
			try {
				pst = conexao.prepareStatement(sql);
				pst.setString(1,tfCpf.getText());
				int apagado = pst.executeUpdate();
				if(apagado >0) {
					JOptionPane.showMessageDialog(null, "Dados removidos com sucesso!");
					tfNome.setText(null);
					tfEmail.setText(null);
					tfCpf.setText(null);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null,e);
			}
		}
	}
}


	


