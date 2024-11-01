package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.HangarBiz;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal(HangarBiz objBiz) {
		//Tamanho da tela largura x altura
		this.setSize(400,400);
		//Tela no centro
		this.setLocationRelativeTo(null);
		
		//Minha barra de menu
		JMenuBar menuBar = new JMenuBar();
		//Adicionar o menu cadastrar aeronave
		JMenu mnCadastrar = new JMenu("CADASTRAR AERONAVE");
		menuBar.add(mnCadastrar);
		
		//Sub-menu aviao
		JMenuItem mntmAviao = new JMenuItem("AVIAO");
		
		//CLICK - Abrir nova janela de cadastro de AVIAO
		mntmAviao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAviao novaJanelaCadastroAviao = new TelaCadastroAviao(objBiz);
			}
		});
		
		mnCadastrar.add(mntmAviao);
		//Sub-menu jato
		JMenuItem mntmJato = new JMenuItem("JATO");
		mnCadastrar.add(mntmJato);
		//Sub-menu jato
		JMenuItem mntmHelicoptero = new JMenuItem("HELICOPTERO");
		mnCadastrar.add(mntmHelicoptero);
		
		//Adicionar o menu na tela
		this.setJMenuBar(menuBar);
		//Visibilidade da tela
		this.setVisible(true);
	}
	
}
