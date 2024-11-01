package test;

import java.awt.*;
import javax.swing.*;

// O JWindow é uma Janela sem barra de titulo, sem botões de minimizar, maximizar e fechar ... 
// O JFrame também é uma Janela mas ele possui borda, barra de título, botões de minimizar, fechar maximizar ...

public class Splash extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;

	public Splash(int d) {
		duration = d;
		showSplash();
	}

	// Este é um método simples para mostrar uma tela de apresentção
	// no centro da tela durante a quantidade de tempo passada no construtor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		// Configura a posição e o tamanho da janela
		int width = 400;
		int height = 300;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Constrói o splash screen
		JLabel label = new JLabel(new ImageIcon("books.gif"));
		JLabel copyrt = new JLabel("Copyright, Hoang Nguyen", JLabel.CENTER);
		JLabel copyrtProgram = new JLabel("Library Organizer 2019 | Daniel Chaussê");
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		copyrtProgram.setFont(new Font("Times New Roman", Font.BOLD, 9));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		content.add(copyrtProgram, BorderLayout.NORTH);
		Color cor = new Color(0, 0, 125, 255);
		content.setBorder(BorderFactory.createLineBorder(cor, 5));

		// Torna visível
		setVisible(true);

		// Espera ate que os recursos estejam carregados
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}
		setVisible(false);
	}
}