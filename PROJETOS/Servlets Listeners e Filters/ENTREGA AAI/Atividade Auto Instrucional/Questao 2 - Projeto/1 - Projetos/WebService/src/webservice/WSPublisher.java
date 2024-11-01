package webservice;

import javax.xml.ws.Endpoint;

public class WSPublisher {
	public static void main(String[] args) {
		Endpoint.publish("https://localhost/WebService/cpf",
				new ValidadorImpl());
	}
}
