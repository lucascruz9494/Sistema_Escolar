package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Boletim extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAv1;
	private JTextField tfAv2;
	
	
	
	public String calcularMedia(float av1, float av2) {
		float media;
		av1 = Float.parseFloat(tfAv1.getText());
		av2 = Float.parseFloat(tfAv2.getText());
		media = (av1+av2)/2;
		String message = "A média das notas é: "+media;
		return message;
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boletim frame = new Boletim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Boletim() {
		setTitle("Sistema Escolar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de média de notas");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(242, 143, 191, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("AV1:");
		lblNewLabel_1.setBounds(10, 97, 28, 24);
		contentPane.add(lblNewLabel_1);
		
		tfAv1 = new JTextField();
		tfAv1.setBounds(48, 99, 86, 20);
		contentPane.add(tfAv1);
		tfAv1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("AV2:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setBounds(10, 145, 28, 24);
		contentPane.add(lblNewLabel_1_1);
		
		tfAv2 = new JTextField();
		tfAv2.setColumns(10);
		tfAv2.setBounds(48, 147, 86, 20);
		contentPane.add(tfAv2);
		
		JButton btCalcular = new JButton("M\u00E9dia");
		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float av1 = Float.parseFloat(tfAv1.getText());
				float av2 = Float.parseFloat(tfAv2.getText());
				JOptionPane.showMessageDialog(null, calcularMedia(av1, av2));
				tfAv1.setText("");
				tfAv2.setText("");
			}
		});
		btCalcular.setForeground(Color.DARK_GRAY);
		btCalcular.setFont(new Font("Tahoma", Font.BOLD, 12));
		btCalcular.setBounds(48, 210, 86, 24);
		contentPane.add(btCalcular);
		
		JButton btVoltar = new JButton("");
		btVoltar.setFocusable(false);
		btVoltar.setHorizontalTextPosition(SwingConstants.LEFT);
		btVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btVoltar.setIcon(new ImageIcon(Boletim.class.getResource("/imagens/arrow_blue_x18.png")));
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial paginaInicial = new PaginaInicial();
				paginaInicial.setVisible(true);
				//fechar a janela anterior
				dispose();
			}
		});
		btVoltar.setForeground(Color.DARK_GRAY);
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btVoltar.setBounds(10, 11, 46, 27);
		contentPane.add(btVoltar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Boletim.class.getResource("/imagens/4091408.png")));
		lblNewLabel_2.setBounds(276, 11, 128, 128);
		contentPane.add(lblNewLabel_2);
	}
	
	
	
}
