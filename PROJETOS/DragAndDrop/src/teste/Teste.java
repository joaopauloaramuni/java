package teste;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JTextField text1, text2, text3;

	public Teste() {
		super("Drag and Drop Text");
		
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		
		text1.setBounds(20, 30, 100, 20);
		text2.setBounds(300, 30, 100, 20);
		text3.setBounds(160, 30, 100, 20);

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JComponent jc = (JComponent) e.getSource();
				TransferHandler th = jc.getTransferHandler();
				th.exportAsDrag(jc, e, TransferHandler.COPY);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		};

		text1.addMouseListener(ml);
		text2.addMouseListener(ml);
		text3.addMouseListener(ml);

		text1.setTransferHandler(new TransferHandler("text"));
		text2.setTransferHandler(new TransferHandler("text"));
		text3.setTransferHandler(new TransferHandler("text"));

		add(text1);
		add(text2);
		add(text3);

		setLayout(null);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Teste();
	}
}
