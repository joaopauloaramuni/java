package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Pet;

public class FrameListarPets extends JFrame{

	public FrameListarPets(ArrayList<Pet> pets) {

	    Vector<String> columnNames = new Vector<String>();
	    columnNames.addElement("Código");
	    columnNames.addElement("Nome do Pet");
	    columnNames.addElement("CPF do Dono");
	    columnNames.addElement("Telefone do Dono");
		
		Vector<Vector> rowData = new Vector<Vector>();
		
		for (Pet pet : pets) {
			Vector<String> rowDinamica = new Vector<String>();
			rowDinamica.addElement("" + pet.getCodigo());
			rowDinamica.addElement(pet.getNome());
			rowDinamica.addElement(pet.getCpfDono());
			rowDinamica.addElement(pet.getTelDono());
		    
		    rowData.addElement(rowDinamica);
		}
	

		JTable table = new JTable(rowData, columnNames);
		
		// add the table to the frame
		this.add(new JScrollPane(table));

		this.setTitle("Exemplo de Grid");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setSize(500,150);
		
		
	}

}
