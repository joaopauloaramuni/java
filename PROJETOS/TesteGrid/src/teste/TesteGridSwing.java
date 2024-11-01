package teste;

import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
 
public class TesteGridSwing {
 
        JFrame frame=new JFrame(); //creates frame
        JButton[][] grid; //names the grid of buttons
 
        public TesteGridSwing(int width, int length){ //constructor
                frame.setLayout(new GridLayout(width,length)); //set layout
                grid=new JButton[width][length]; //allocate the size of grid
                for(int y=0; y<length; y++){
                        for(int x=0; x<width; x++){
                                JButton jButton = new JButton("("+x+","+y+")");
								grid[x][y]=jButton; //creates new button     
                                frame.add(grid[x][y]); //adds button to grid
                               
                                java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {
                        			public void actionPerformed(java.awt.event.ActionEvent evt) {
                        				System.out.println("Cliquei no botão!!!" + jButton.getText());
                        			}
                        		};
                                
                                jButton.addActionListener(actionListener);
                        }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible
                frame.setSize(500, 500);
                
                
          
        		
                
        }
        public static void main(String[] args) {
                new TesteGridSwing(3,3);//makes new ButtonGrid with 2 parameters
        }
}