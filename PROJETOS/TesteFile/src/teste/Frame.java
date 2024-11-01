package teste;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel painel = new JPanel();
	private JButton jButtonArquivo = new JButton("Escolher Arquivo");
	private JTextField jTextFieldTexto = new JTextField("Caminho do arquivo", 35);

	public Frame() {
		initActionEvents();
		this.setTitle("Exemplo Arquivo");
		this.setSize(500, 150);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		painel.setBackground(new Color(255, 255, 255));
		painel.add(jTextFieldTexto);
		painel.add(jButtonArquivo);
		this.getContentPane().add(painel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initActionEvents() {
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					jTextFieldTexto.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					jTextFieldTexto.setText(arquivo.getPath());
				}
			}
		};
		jButtonArquivo.addActionListener(actionListener);
	}

}
