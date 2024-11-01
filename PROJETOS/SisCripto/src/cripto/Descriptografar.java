package cripto;

import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Descriptografar extends JFrame {

	// Objeto da classe Cesar
	private Cesar cript = new Cesar();

	private static final long serialVersionUID = 1L;

	private JPanel painel = new JPanel();
	private JButton jButtonArquivo = new JButton("Descriptografar senha");
	private JTextField jTextFieldTexto = new JTextField("Senha criptografada",
			35);
	private JTextField jTextFieldTexto2 = new JTextField(
			"Senha descriptografada", 35);

	public Descriptografar() {
		initActionEvents();
		this.setSize(500, 200);
		jTextFieldTexto.setEditable(false);
		jTextFieldTexto2.setEditable(false);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		painel.add(jTextFieldTexto);
		painel.add(jTextFieldTexto2);
		painel.add(jButtonArquivo);
		this.getContentPane().add(painel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Exemplos de Dialog
		// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
	}

	private void initActionEvents() {
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					jTextFieldTexto.setText("");
					jTextFieldTexto2.setText("");
				} else {
					try {
						File arquivo = file.getSelectedFile();
						Scanner fileIn = new Scanner(arquivo);
						String textoPuro = fileIn.nextLine();
						fileIn.close();

						// Adotaremos deslocamento 5
						String deslocamento = "5";
						int desloc = Integer.parseInt(deslocamento);

						if (cript.validarTexto(textoPuro, deslocamento)
								&& cript.validarDesloc(desloc)) {
							jTextFieldTexto.setText(textoPuro);
							String descriptografar = cript.descriptografar(
									textoPuro, desloc);
							jTextFieldTexto2.setText(descriptografar);

							// Grava no arquivo senhaDecriptada.txt - Valor (5,0
							// pts)
							Writer writer = new BufferedWriter(
									new OutputStreamWriter(
											new FileOutputStream(
													"senhaDecriptada.txt"),
											"utf-8"));
							writer.write(descriptografar);
							writer.close();

						} else {
							JOptionPane.showMessageDialog(null,
									"Erro, contate o administrador do sistema."
											+ " - Texto Inválido!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,
								"Erro, contate o administrador do sistema. "
										+ e.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};
		jButtonArquivo.addActionListener(actionListener);
	}

}
