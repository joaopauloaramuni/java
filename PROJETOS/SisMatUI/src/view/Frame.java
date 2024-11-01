package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Frame extends JFrame {

	private JPanel painel = new JPanel();
	private JLabel jLabelMensagem = new JLabel("Cadastro de Aluno");
	private final JPanel panel = new JPanel();
	private final JSplitPane splitPane = new JSplitPane();
	private final JLabel lblCdigo = new JLabel("C\u00F3digo:");
	private final JTextField textFieldCodigo = new JTextField();
	private final JButton btnNewButton = new JButton("Cadastrar");
	private final JSplitPane splitPane_1 = new JSplitPane();
	private final JLabel lblNewLabel = new JLabel("Nome:");
	private final JTextField textFieldNome = new JTextField();
	private final JSplitPane splitPane_2 = new JSplitPane();
	private final JSplitPane splitPane_3 = new JSplitPane();
	private final JSplitPane splitPane_4 = new JSplitPane();
	private final JTextField textFieldCPF = new JTextField();
	private final JTextField textFieldTelefone = new JTextField();
	private final JTextField textFieldData = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("CPF:");
	private final JLabel lblNewLabel_2 = new JLabel("Telefone:");
	private final JLabel lblNewLabel_3 = new JLabel("Data:");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();

	public Frame() {
		
		ImageIcon imagem = new ImageIcon("water.bmp");
		initActionEvents();
		this.setTitle("Texto da Barra de Título");
		this.setSize(287, 402);
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		painel.setBackground(new Color(255, 255, 255));

		painel.add(panel);
		panel.add(jLabelMensagem);
		this.getContentPane().add(painel);
		panel_1.setForeground(Color.BLACK);
		panel_1.setPreferredSize(new Dimension(200, 30));
		panel_1.setSize(new Dimension(200, 0));

		painel.add(panel_1);
		textFieldCodigo.setSize(new Dimension(100, 0));
		textFieldCodigo.setColumns(10);
		panel_1.add(splitPane);
		lblCdigo.setPreferredSize(new Dimension(50, 14));

		splitPane.setLeftComponent(lblCdigo);

		splitPane.setRightComponent(textFieldCodigo);
		panel_2.setPreferredSize(new Dimension(200, 30));
		panel_2.setSize(new Dimension(200, 0));

		painel.add(panel_2);
		textFieldNome.setColumns(10);
		panel_2.add(splitPane_1);
		lblNewLabel.setPreferredSize(new Dimension(50, 14));

		splitPane_1.setLeftComponent(lblNewLabel);

		splitPane_1.setRightComponent(textFieldNome);
		panel_3.setPreferredSize(new Dimension(200, 30));
		panel_3.setSize(new Dimension(200, 0));

		painel.add(panel_3);
		textFieldCPF.setColumns(10);
		panel_3.add(splitPane_2);

		splitPane_2.setRightComponent(textFieldCPF);
		lblNewLabel_1.setPreferredSize(new Dimension(50, 14));

		splitPane_2.setLeftComponent(lblNewLabel_1);
		panel_4.setPreferredSize(new Dimension(200, 30));
		panel_4.setSize(new Dimension(200, 0));

		painel.add(panel_4);
		textFieldTelefone.setColumns(10);
		panel_4.add(splitPane_3);

		splitPane_3.setRightComponent(textFieldTelefone);
		lblNewLabel_2.setPreferredSize(new Dimension(50, 14));

		splitPane_3.setLeftComponent(lblNewLabel_2);
		panel_5.setPreferredSize(new Dimension(200, 30));
		panel_5.setSize(new Dimension(200, 0));

		painel.add(panel_5);
		textFieldData.setColumns(10);
		panel_5.add(splitPane_4);

		splitPane_4.setRightComponent(textFieldData);
		lblNewLabel_3.setPreferredSize(new Dimension(50, 14));

		splitPane_4.setLeftComponent(lblNewLabel_3);

		painel.add(btnNewButton);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	


	private void initActionEvents() {
		java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			
				InterfaceUsuario.cadastrarAluno(textFieldCodigo.getText(), textFieldNome.getText(),
						textFieldCPF.getText(), textFieldTelefone.getText(), textFieldData.getText());
			
				setVisible(false);
			}
		};

		btnNewButton.addActionListener(actionListener);
	}

}
