package teste;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TesteGridSwing2 extends JFrame {

	private static final long serialVersionUID = 1L;

	public TesteGridSwing2() {
		// headers for the table
		String[] columns = new String[] { "Id", "Nome", "Idade", "Telefone" };

		// actual data for the table in a 2d array
		Object[][] data = new Object[][] { { 1, "Ranger Vermelho", 16, "98888-8888" }, { 2, "Ranger Verde", 17, "98888-8888" },
				{ 3, "Ranger Preto", 18, "98888-8888"}, };
		// create table with data
		JTable table = new JTable(data, columns);

		// add the table to the frame
		this.add(new JScrollPane(table));

		this.setTitle("Exemplo de Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(500,150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
				new TesteGridSwing2();
	}
}