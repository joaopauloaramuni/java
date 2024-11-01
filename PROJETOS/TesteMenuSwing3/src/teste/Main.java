package teste;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static void main(String[] args) {
		JFrame novaJanela = new JFrame("Minha nova Janela");

		JFrame janela = new JFrame("Janela");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300, 300);

		JMenuBar barra = new JMenuBar();
		JMenu arquivo = new JMenu("Arquivo");

		JMenuItem novaJ = new JMenuItem("Nova Janela");
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// System.out.println("Cliquei no menuItem Novo Projeto!");
				novaJanela.setLocationRelativeTo(null);
				novaJanela.setSize(300, 300);
				novaJanela.setVisible(true);

			}
		};

		novaJ.addActionListener(actionListener);
		arquivo.add(novaJ);

		JMenuItem sair = new JMenuItem("Sair");
		arquivo.add(sair);

		barra.add(arquivo);

		janela.setJMenuBar(barra);
		janela.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		janela.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblCursos = new JLabel("Cursos:");
		lblCursos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCursos.setBounds(10, 8, 83, 14);
		panel.add(lblCursos);

		JComboBox cbxCursos = new JComboBox();

		// Populando o comboBox de cursos
		cbxCursos.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", "Ciência da Computação", "ADM", "Estética" }));

		cbxCursos.setBounds(103, 5, 171, 20);

		JComboBox cbxDisciplinas = new JComboBox();
		cbxDisciplinas.setBounds(103, 30, 171, 20);
		cbxDisciplinas.setEnabled(false);
		
		cbxCursos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Carregar as disciplinas dos cursos de acordo com o
				// curso selecionado

				if (cbxCursos.getSelectedItem().equals("Ciência da Computação")) {
					cbxDisciplinas.setModel(new DefaultComboBoxModel(new String[] { "LTP3", "FTC", "COMPILADORES" }));
					cbxDisciplinas.setEnabled(true);
				} else if (cbxCursos.getSelectedItem().equals("ADM")) {
					cbxDisciplinas.setModel(new DefaultComboBoxModel(new String[] { "Teoria da ADM", "Estatística" }));
					cbxDisciplinas.setEnabled(true);
				} else if (cbxCursos.getSelectedItem().equals("Estética")) {
					cbxDisciplinas.setModel(new DefaultComboBoxModel(new String[] { "Maquiagem 1", "Maquiagem 2" }));
					cbxDisciplinas.setEnabled(true);
				}else if (cbxCursos.getSelectedItem().equals("Selecione")) {
					cbxDisciplinas.setModel(new DefaultComboBoxModel(new String[] { ""}));
					cbxDisciplinas.setEnabled(false);
				}

			}
		});

		panel.add(cbxCursos);

		JLabel lblDisciplinas = new JLabel("Disciplinas:");
		lblDisciplinas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisciplinas.setBounds(10, 33, 83, 14);
		panel.add(lblDisciplinas);

		panel.add(cbxDisciplinas);

		janela.setVisible(true);
	}
}