import javax.swing.*;
import java.awt.*;
import java.util.*;
  
public class Main extends JFrame
{
   public Main() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      getContentPane().setLayout(new FlowLayout());
        
      Vector v = new Vector();
      v.add("Europe");
      v.add(new JCheckBox("Brussels", false));
      v.add(new JCheckBox("Paris", false));
      v.add(new JCheckBox("London", false));
      v.add("United States");
      v.add(new JCheckBox("New York", false));
      v.add(new JCheckBox("Detroit", false));
      v.add(new JCheckBox("San Francisco", false));
  
      getContentPane().add(new JComboCheckBox(v));
   }
     
   public static void main(String []args) {
      Main main = new Main();
      main.setSize(300, 300);
      main.setVisible(true);
   }
}