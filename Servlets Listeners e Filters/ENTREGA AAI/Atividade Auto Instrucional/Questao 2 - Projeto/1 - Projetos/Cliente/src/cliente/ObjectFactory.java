package cliente;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cliente package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidaCPF_QNAME = new QName("http://webservice/", "validaCPF");
    private final static QName _ValidaCPFResponse_QNAME = new QName("http://webservice/", "validaCPFResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cliente
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidaCPFResponse }
     * 
     */
    public ValidaCPFResponse createValidaCPFResponse() {
        return new ValidaCPFResponse();
    }

    /**
     * Create an instance of {@link ValidaCPF }
     * 
     */
    public ValidaCPF createValidaCPF() {
        return new ValidaCPF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCPF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "validaCPF")
    public JAXBElement<ValidaCPF> createValidaCPF(ValidaCPF value) {
        return new JAXBElement<ValidaCPF>(_ValidaCPF_QNAME, ValidaCPF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaCPFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "validaCPFResponse")
    public JAXBElement<ValidaCPFResponse> createValidaCPFResponse(ValidaCPFResponse value) {
        return new JAXBElement<ValidaCPFResponse>(_ValidaCPFResponse_QNAME, ValidaCPFResponse.class, null, value);
    }

}
