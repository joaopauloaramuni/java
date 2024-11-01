public class HelloWorldThread extends Thread {
    public void run() {
    	for(int i = 0; i < 10; i++)
    		System.out.println("Hello World Thread");
    }
    public static void main(String[] args) {
        HelloWorldThread t = new HelloWorldThread();
        t.start();
    	for(int i = 0; i < 10; i++)
    		System.out.println("Thread principal");
    }
}