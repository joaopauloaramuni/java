package teste;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// O JWindow � uma Janela sem barra de titulo, sem bot�es de minimizar, maximizar e fechar ... 
// O JFrame tamb�m � uma Janela mas ele possui borda, barra de t�tulo, bot�es de minimizar, fechar maximizar ...

public class Splash extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;
	private int porcentagem = 0;
	private Timer timer;
	
	public Splash(int d) {
		duration = d;
		showSplash();
	}

	// Este � um m�todo simples para mostrar uma tela de apresent��o
	// no centro da tela durante a quantidade de tempo passada no construtor
	public void showSplash() {
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);

		// Configura a posi��o e o tamanho da janela
		int width = 450;
		int height = 160;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		// Constr�i o splash screen
		JLabel label = new JLabel(new ImageIcon("U:\\WorkspaceJava\\SplashTeste_Prj\\src\\teste\\img\\fumec.png"));
		JLabel copyrt = new JLabel("Copyright 2017, Universidade FUMEC", JLabel.CENTER);
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		progressBar.setSize(new Dimension(100, 23));
		getContentPane().add(progressBar, BorderLayout.NORTH);
		Color cor = new Color(0, 0, 125, 255);
		content.setBorder(BorderFactory.createLineBorder(cor, 5));

		// Torna vis�vel
		setVisible(true);

		// Espera ate que os recursos estejam carregados
		try {

		     timer = new Timer(30, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					porcentagem++;
					progressBar.setValue(porcentagem);
					if (porcentagem >= 100) {
						timer.stop();
					}

				}
			});
			timer.start();

			Thread.sleep(duration);

		} catch (Exception e) {
		}
		setVisible(false);
	}
}