package teste;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class Main {
	public static JMenuBar createMenuBar() {

		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rdmi;
		JCheckBoxMenuItem cbmi;

		// Criando a barra de menu
		menuBar = new JMenuBar();

		// Construindo o menu de arquivo
		menu = new JMenu("Arquivo");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("Arquivo Menu");
		menuBar.add(menu);

		// Grupo de JMenuItems
		menuItem = new JMenuItem("Novo Projeto...", new ImageIcon("1.png"));
		menuItem.setMnemonic(KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext()
				.setAccessibleDescription("Novo Projeto");
		
        java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//System.out.println("Cliquei no menuItem Novo Projeto!");
				JFrame novaJanela = new JFrame("Minha nova Janela");
				novaJanela.setLocationRelativeTo(null);
				novaJanela.setVisible(true);
				novaJanela.setSize(300,300);
			}
		};
		
		menuItem.addActionListener(actionListener);
		
		menu.add(menuItem);

		menuItem = new JMenuItem("Novo Arquivo...", new ImageIcon("2.png"));
		menuItem.setMnemonic(KeyEvent.VK_F);
		menu.add(menuItem);

		// Submenu
		menu.addSeparator();
		submenu = new JMenu("Submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Menu item dentro do submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Outro menu item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Construindo o menu de edição na barra de menu.
		menu = new JMenu("Edição");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription("Edição Menu");
		menuBar.add(menu);

		// Grupo de check box menu items
		menu.addSeparator();
		cbmi = new JCheckBoxMenuItem("Check box menu item");
		cbmi.setMnemonic(KeyEvent.VK_C);
		menu.add(cbmi);

		cbmi = new JCheckBoxMenuItem("Outro check box");
		cbmi.setMnemonic(KeyEvent.VK_H);
		menu.add(cbmi);

		// Grupo de radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rdmi = new JRadioButtonMenuItem("Radio button menu item");
		rdmi.setSelected(true);
		rdmi.setMnemonic(KeyEvent.VK_R);
		group.add(rdmi);
		menu.add(rdmi);

		rdmi = new JRadioButtonMenuItem("Outro radio button");
		rdmi.setMnemonic(KeyEvent.VK_O);
		group.add(rdmi);
		menu.add(rdmi);

		return menuBar;

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Menu");
		frame.setJMenuBar(createMenuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
