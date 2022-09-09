package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.HandlerChain;

@WebService
@HandlerChain(file="./handler/handlers.xml")
@SOAPBinding(style = Style.DOCUMENT)
public interface Validador {
	 @WebMethod String validaCPF(String name);
}
