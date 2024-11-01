package teste;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JLabel pic1, pic2, pic3;

	public Teste() {
		super("Drag and Drop Images");
		
		pic1 = new JLabel();
		pic2 = new JLabel();
		pic3 = new JLabel();
		
		pic1.setBounds(20, 30, 100, 100);
		pic2.setBounds(250, 30, 100, 100);
		pic3.setBounds(20, 140, 100, 100);
		
		pic1.setIcon(new ImageIcon("U:\\WorkspaceJava\\DragAndDrop2\\teste.jpg"));

		pic2.setIcon(new ImageIcon("U:\\WorkspaceJava\\DragAndDrop2\\teste2.jpg"));

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

		pic1.addMouseListener(ml);
		pic2.addMouseListener(ml);
		pic3.addMouseListener(ml);

		pic1.setTransferHandler(new TransferHandler("icon"));
		pic2.setTransferHandler(new TransferHandler("icon"));
		pic3.setTransferHandler(new TransferHandler("icon"));

		add(pic1);
		add(pic2);
		add(pic3);

		setLayout(null);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Teste();
	}
}
