package cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.jws.HandlerChain;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ValidadorImplService", targetNamespace = "http://webservice/", wsdlLocation = "https://localhost/WebService/cpf?wsdl")
@HandlerChain(file="./handler/handlers.xml")
public class ValidadorCPFImplService
    extends Service
{

    private final static URL VALIDADORIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(cliente.ValidadorCPFImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = cliente.ValidadorCPFImplService.class.getResource(".");
            url = new URL(baseUrl, "https://localhost/WebService/cpf?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://localhost/WebService/cpf?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        VALIDADORIMPLSERVICE_WSDL_LOCATION = url;
    }

    public ValidadorCPFImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ValidadorCPFImplService() {
        super(VALIDADORIMPLSERVICE_WSDL_LOCATION, new QName("http://webservice/", "ValidadorImplService"));
    }

    /**
     * 
     * @return
     *     returns ValidadorCPF
     */
    @WebEndpoint(name = "ValidadorImplPort")
    public ValidadorCPF getValidadorCPFImplPort() {
        return super.getPort(new QName("http://webservice/", "ValidadorImplPort"), ValidadorCPF.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ValidadorCPF
     */
    @WebEndpoint(name = "ValidadorImplPort")
    public ValidadorCPF getValidadorCPFImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice/", "ValidadorImplPort"), ValidadorCPF.class, features);
    }

}