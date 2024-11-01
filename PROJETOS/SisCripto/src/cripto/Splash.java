package cripto;

import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;

	public Splash(int d) {
		duration = d;
	}

	// Este é um método simples para mostrar uma tela de apresentção
	// no centro da tela durante a quantidade de tempo passada no construtor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		// Configura a posição e o tamanho da janela
		int width = 512;
		int height = 512;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Constrói o splash screen
		JLabel label = new JLabel(new ImageIcon("criptografia.png"));
		JLabel copyrt = new JLabel("Copyright 2017, SisCripto", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		Color cor = new Color(0, 0, 125, 255);
		content.setBorder(BorderFactory.createLineBorder(cor, 1));

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