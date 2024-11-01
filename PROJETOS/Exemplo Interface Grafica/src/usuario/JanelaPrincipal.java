package usuario;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {
	

	public JanelaPrincipal() {
		setTitle("Janela Principal");
		setSize(300, 200);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("recursos/kfm_home.png")).getImage());
		getContentPane().setBackground(new Color(255, 255, 255));
		configurarComponentes();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void configurarComponentes() {
		// TODO Auto-generated method stub
		
	}
}
