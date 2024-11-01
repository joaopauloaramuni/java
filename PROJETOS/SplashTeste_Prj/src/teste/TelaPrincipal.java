package teste;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {	
		setSize(650,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Janela Principal");
		ImageIcon icone = new ImageIcon("U:\\WorkspaceJava\\SplashTeste_Prj\\src\\teste\\img\\fumec.png");
        setIconImage(icone.getImage());
        
		setVisible(true);
        //JOptionPane.showMessageDialog(null, null,"Teste",JOptionPane.WARNING_MESSAGE);  
	}
}
