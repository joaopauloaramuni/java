package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "validaCPF", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validaCPF", namespace = "http://webservice/")
public class ValidaCPF {

    @XmlElement(name = "arg0", namespace = "")
    private String arg0;

    public String getArg0() {
        return this.arg0;
    }
    
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

}
