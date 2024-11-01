package robot;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("WebCrawler executando...");
		Spider spider = new Spider();
		spider.search("http://g1.com.br/", "G1");
	}
}