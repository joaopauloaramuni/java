public class HelloWorldRunnable implements Runnable {
    public void run() {
    	for(int i = 0; i < 10; i++)
    		System.out.println("Hello World Runnable");
    }
    public static void main(String[] args) {
        HelloWorldRunnable r = new HelloWorldRunnable();
        Thread t = new Thread(r); t.start();
    	for(int i = 0; i < 10; i++)
    		System.out.println("Thread principal");
    }
}