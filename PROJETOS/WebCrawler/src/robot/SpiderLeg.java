package robot;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private List<String> links = new LinkedList<String>();
	private Document htmlDocument;

	public boolean crawl(String url) {
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument = connection.get();
			this.htmlDocument = htmlDocument;
			if (connection.response().statusCode() == 200){
				System.out.println("\n**Visitando** " + url);
			}
			if (!connection.response().contentType().contains("text/html")) {
				System.out.println("**Falha**");
				return false;
			}
			
			Elements linksOnPage = htmlDocument.select("a[href]");
			Elements jpgs = htmlDocument.select("img[src$=.jpg]");
			
			System.out.println("\n**Links do feed**");
			int cont = 0;
			for (Element link : linksOnPage) {
				if(link.className().contains("feed")) {
					System.out.println("Texto do link: " + link.text());
					System.out.println("Link: " + link.absUrl("href"));
					cont++;
				}
				//Todos os links
				//System.out.println("Texto do link: " + link.text());
				//System.out.println("Link: " + link.absUrl("href"));
				this.links.add(link.absUrl("href"));
			}
			System.out.println("\nEncontrado: " + linksOnPage.size() + " links, dos quais " + cont + " são referentes ao feed.");
			System.out.println("\nEncontrado: " + jpgs.size() + " imagens jpg");
			
			for (Element imagem : jpgs) {
				System.out.println("Link da imagem: " + imagem.absUrl("srcset"));
			}
			
			return true;
		} catch (IOException ioe) {
			return false;
		}
	}

	public boolean searchForWord(String searchWord) {
		if (this.htmlDocument == null) {
			System.out.println("\nErro.");
			return false;
		}
		System.out.println("\nProcurando a palavra: " + searchWord + "...");
		String bodyText = this.htmlDocument.body().text();
		return bodyText.toLowerCase().contains(searchWord.toLowerCase());
	}

	public List<String> getLinks() {
		return this.links;
	}

}
