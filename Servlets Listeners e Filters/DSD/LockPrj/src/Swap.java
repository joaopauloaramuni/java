public class Swap{
    public static synchronized void swap(boolean m1, boolean m2){
        boolean temp = m1; 
        m1 = m2; 
        m2 = temp;
     }
}

