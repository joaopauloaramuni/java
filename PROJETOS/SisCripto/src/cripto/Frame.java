package cripto;

import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static SecretKey secretKey;

	public Frame() {
		this.setJMenuBar(createMenuBar());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550, 300);
		this.setLocationRelativeTo(null);
		setImagemBackground();
		this.setVisible(true);
	}

	private void setImagemBackground() {
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					"criptografia2.jpg")))));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro, contate o administrador do sistema."
							+ " - Imagem Inválida!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static JMenuBar createMenuBar() {

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		// Criando a barra de menu
		menuBar = new JMenuBar();

		// Construindo o menu de arquivo
		menu = new JMenu("Arquivo");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("Arquivo Menu");
		menuBar.add(menu);

		// Grupo de JMenuItems
		menuItem = new JMenuItem("Criptografar...", new ImageIcon("1.png"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Criptografar...");

		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Criptografar criptografar = new Criptografar();
				criptografar.setTitle("Criptografar");
			}
		};

		menuItem.addActionListener(actionListener);

		menu.add(menuItem);

		menuItem = new JMenuItem("Descriptografar...", new ImageIcon("2.png"));
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Descriptografar...");

		java.awt.event.ActionListener actionListener2 = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Descriptografar descriptografar = new Descriptografar();
				descriptografar.setTitle("Descriptografar");
			}
		};

		menuItem.addActionListener(actionListener2);

		menu.add(menuItem);

		// Construindo o menu de edição na barra de menu.
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_D);
		menu.getAccessibleContext().setAccessibleDescription("Help Menu");
		menuBar.add(menu);

		menuItem = new JMenuItem("Ajuda...", new ImageIcon("3.png"));
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Ajuda...");

		java.awt.event.ActionListener actionListener3 = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane
						.showMessageDialog(
								null,
								"SisCripto - Sistema para encriptar e decriptar senhas através da Cifra de César.\nData de criação: 05/12/2017\nAutor:  João Paulo Aramuni");
			}
		};

		menuItem.addActionListener(actionListener3);

		menu.add(menuItem);

		return menuBar;

	}
}
