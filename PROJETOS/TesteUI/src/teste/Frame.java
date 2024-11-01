package teste;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Frame extends JFrame {

	private JPanel painel = new JPanel();
	private JButton jButtonLimpar = new JButton("Limpar");
	private JTextField jTextFieldTexto = new JTextField("Teste", 20);
	private JLabel jLabelMensagem = new JLabel("Exemplo Simples de Janela");
	private final JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");

	public Frame() {
		initActionEvents();
		this.setTitle("Texto da Barra de Título");
		this.setSize(300, 225);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		painel.setBackground(new Color(255, 255, 255));
		jTextFieldTexto.setBackground(Color.GREEN);
		painel.add(jTextFieldTexto);
		jButtonLimpar.setBackground(Color.RED);
		painel.add(jButtonLimpar);
		
		painel.add(chckbxNewCheckBox);
		rdbtnNewRadioButton.setSelected(true);
		
		painel.add(rdbtnNewRadioButton);
		painel.add(jLabelMensagem);
		this.getContentPane().add(painel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initActionEvents() {
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextFieldTexto.setText("");
			}
		};
		jButtonLimpar.addActionListener(actionListener);
		
		jButtonLimpar.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				
			}
			@Override
			public void focusGained(FocusEvent arg0) {
				jTextFieldTexto.setText("");
			}
		});
	}

}
