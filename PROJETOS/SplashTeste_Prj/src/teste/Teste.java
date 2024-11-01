package teste;

import java.awt.*;
import javax.swing.*;

// O JWindow é uma Janela sem barra de titulo, sem botões de minimizar, maximizar e fechar ... 
// O JFrame também é uma Janela mas ele possui borda, barra de título, botões de minimizar, fechar maximizar ...

public class Teste extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;

	public Teste(int d) {
		duration = d;
	}

	// Este é um método simples para mostrar uma tela de apresentção
	// no centro da tela durante a quantidade de tempo passada no construtor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		// Configura a posição e o tamanho da janela
		int width = 450;
		int height = 120;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Constrói o splash screen
		JLabel label = new JLabel(new ImageIcon("fumec.png"));
		JLabel copyrt = new JLabel("Copyright 2017, Universidade FUMEC", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
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

	public void showSplashAndExit() {
		showSplash();
		System.exit(0);
	}

	public static void main(String[] args) {
		// Mostra uma imagem com o título da aplicação
		Teste splash = new Teste(10000);
		splash.showSplashAndExit();
	}
}