package usuario;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	// Atributos
	private JTextField jTextFieldTexto = new JTextField(30);
	private JButton jButtonOK = new JButton("OK");
	private JMenuBar jMenuBarJanela = new JMenuBar();
	private JMenu jMenuArquivo = new JMenu("Arquivo");
	private JMenu jMenuAjuda = new JMenu("Ajuda");
	private JMenuItem jMenuItemFechar = new JMenuItem("Fechar");
	
	// Métodos
	public JanelaPrincipal() {
		setTitle("Janela Principal");
		setSize(400, 200);
		setLocationRelativeTo(null); // Centralizar
		//setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		configurarComponentes();
		setVisible(true);
	}

	private void configurarComponentes() {
		jMenuArquivo.setMnemonic('A');
		jMenuItemFechar.setMnemonic('F');
		jMenuArquivo.add(jMenuItemFechar);
		jMenuBarJanela.add(jMenuArquivo);
		jMenuBarJanela.add(jMenuAjuda);
		setJMenuBar(jMenuBarJanela);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
		getContentPane().add(jTextFieldTexto);
		jButtonOK.setToolTipText("teste OK");
		getContentPane().add(jButtonOK);
		jButtonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jButtonOK(e);
				
			}
		});
		jMenuItemFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fechar();
				
			}
		});
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				fechar();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	private void fechar() {
		if (JOptionPane.showConfirmDialog(
				this, 
				"Confirmar saída?", 
				"Exemplo", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
			dispose();
			System.exit(0);
		}
		
	}

	private void jButtonOK(ActionEvent e) {
		JOptionPane.showMessageDialog(
				this, 
				jTextFieldTexto.getText(), 
				"Exemplo", 
				JOptionPane.INFORMATION_MESSAGE);
		
	}
}
