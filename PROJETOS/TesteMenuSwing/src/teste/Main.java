package teste;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {

		JFrame janela = new JFrame("Janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300, 300);

		JMenuBar barra = new JMenuBar();
		JMenu arquivo = new JMenu("Arquivo");
		
		JMenuItem novaJ = new JMenuItem("Nova Janela");
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//System.out.println("Cliquei no menuItem Novo Projeto!");
				JFrame novaJanela = new JFrame("Minha nova Janela");
				novaJanela.setLocationRelativeTo(null);
				novaJanela.setVisible(true);
				novaJanela.setSize(300,300);
			}
		};
		
		novaJ.addActionListener(actionListener);
		arquivo.add(novaJ);
		
		JMenuItem sair = new JMenuItem("Sair");
		arquivo.add(sair);
		
		barra.add(arquivo);

		janela.setJMenuBar(barra);
		janela.setLocationRelativeTo(null);
		 
		janela.setVisible(true);
	}
}