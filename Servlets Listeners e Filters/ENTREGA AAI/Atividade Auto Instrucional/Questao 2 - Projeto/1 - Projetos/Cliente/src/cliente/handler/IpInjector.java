package cliente.handler;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class IpInjector implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {

		System.out.println("Client::handleMessage()");

		Boolean isRequest = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		// outbound message to server
		if (isRequest) {

			try {
				SOAPMessage soapMessagg = context.getMessage();
				SOAPEnvelope soapEnvelope = soapMessagg.getSOAPPart()
						.getEnvelope();
				SOAPHeader soapHeader = soapEnvelope.getHeader();

				// add a header to the SOAP message
				if (soapHeader == null) {
					soapHeader = soapEnvelope.addHeader();
				}

				// find out client's ip address
				InetAddress inAdd = InetAddress.getLocalHost();
				String ip = inAdd.getHostAddress();

				System.out.println("Client's ip address :" + ip);

				// add a soap header, name as "ipAddress"
				QName qname = new QName("http://webservice/", "ipAddress");
				SOAPHeaderElement soapHeaderElement = soapHeader
						.addHeaderElement(qname);

				soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);

				// Adicionar IP local do cliente no cabeçalho SOAP
				soapHeaderElement.addTextNode(ip);
				soapMessagg.saveChanges();

				// tracking
				soapMessagg.writeTo(System.out);

			} catch (SOAPException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}

		}

		// continue other handler chain
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Client::handleFault() : ");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Client::close() : ");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Client::getHeaders() : ");
		return null;
	}

}
