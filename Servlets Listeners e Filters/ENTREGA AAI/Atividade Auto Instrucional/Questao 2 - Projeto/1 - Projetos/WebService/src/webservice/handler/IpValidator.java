package webservice.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import javax.naming.Context;
import javax.naming.InitialContext;

public class IpValidator implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		System.out.println("Server::handleMessage() : ");

		Boolean isRequest = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// inbound message from client
		if (!isRequest) {

			try {

				SOAPMessage soapMsg = context.getMessage();
				SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnv.getHeader();

				// if no header, add one
				if (soapHeader == null) {
					soapHeader = soapEnv.addHeader();
					// throw exception
					attacheErrorMessage(soapMsg, "No SOAP header.");
				}

				// Get client ip address from SOAP header
				Iterator<?> it = soapHeader
						.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

				// if no header block for next actor found? throw exception
				if (it == null || !it.hasNext()) {
					attacheErrorMessage(soapMsg,
							"No header block for next actor.");
				}

				// if no ip address found? throw exception
				Node ipNode = (Node) it.next();
				String ipAddress = (ipNode == null) ? null : ipNode.getValue();

				if (ipAddress == null) {
					attacheErrorMessage(soapMsg,
							"No ip address in header block.");
				}

				// Comparar o IP local do cliente "ipadress"
				// com os IP's válidos listados no web.xml

				String IP_Casa_1 = "";
				String IP_Casa_2 = "";
				String IP_Fumec = "";

				int cont = 1;

				try {

					ArrayList<String> listaIps = new ArrayList<String>();
					listaIps = ListaIPsValidos();
					Iterator<?> i = listaIps.iterator();

					while (i.hasNext()) {

						if (cont == 1)
							IP_Casa_1 = i.next().toString();
						if (cont == 2)
							IP_Casa_2 = i.next().toString();
						if (cont == 3)
							IP_Fumec = i.next().toString();

						cont++;
					}

				} catch (Exception e) {
					e.getMessage();
				}

				System.out.println("IP Válido: " + IP_Casa_1);
				System.out.println("IP Válido: " + IP_Casa_2);
				System.out.println("IP Válido: " + IP_Fumec);
				System.out.println("IP Cliente: " + ipAddress);

				if (!ipAddress.equals(IP_Casa_1)
						&& !ipAddress.equals(IP_Casa_2)
						&& !ipAddress.equals(IP_Fumec)) {
					attacheErrorMessage(soapMsg,
							"Endereço IP inválido, acesso negado.");
				}

				// tracking
				soapMsg.writeTo(System.out);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}

		}

		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {

		System.out.println("Server::handleFault() : ");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Server::close() : ");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server : getHeaders() : ");
		return null;
	}

	private void attacheErrorMessage(SOAPMessage errorMessage, String cause) {
		try {
			SOAPBody soapBody = errorMessage.getSOAPPart().getEnvelope()
					.getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(cause);
			throw new SOAPFaultException(soapFault);
		} catch (SOAPException e) {
		}
	}

	// Método para obter lista de IPs válidos listados no web.xml
	private ArrayList<String> ListaIPsValidos() throws Exception {

		Context env = (Context) new InitialContext().lookup("java:comp/env");
		String IP_Casa_1 = (String) env.lookup("IP_Casa_1");
		String IP_Casa_2 = (String) env.lookup("IP_Casa_2");
		String IP_Fumec = (String) env.lookup("IP_Fumec");

		ArrayList<String> lista = new ArrayList<String>();

		lista.add(IP_Casa_1);
		lista.add(IP_Casa_2);
		lista.add(IP_Fumec);

		return lista;
	}
}