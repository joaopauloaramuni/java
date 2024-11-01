package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import controller.HangarBiz;
import model.Aviao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAviao extends JFrame {
	private JTextField textField;
	
	public TelaCadastroAviao(HangarBiz objBiz) {
		this.setSize(400,400);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(80, 31, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Marca:");
		lblNome.setBounds(22, 34, 46, 14);
		panel.add(lblNome);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				 
			 JOptionPane.showMessageDialog(null, "TESTE");
					
				Aviao meuAviao = new Aviao();
				meuAviao.setMarca(textField.getText());
				try {
				objBiz.cadastrarAeronave(meuAviao);
				}catch(Exception ex) {
				}
			}
		});
		btnSalvar.setBounds(148, 208, 89, 23);
		panel.add(btnSalvar);
		this.setVisible(true);
		
		
	}
}
