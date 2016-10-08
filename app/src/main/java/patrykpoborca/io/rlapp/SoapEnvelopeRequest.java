package patrykpoborca.io.rlapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by patrykpoborca on 8/2/16.
 */
@Root(name = "S:Envelope", strict = false)
@NamespaceList({
        @Namespace(prefix = "S", reference = "http://schemas.xmlsoap.org/soap/envelope/")
})
public class SoapEnvelopeRequest {

    @Element(name = "S:Body", required = true)
    private Object SBody;

    @Element(name = "S:Header", required = false)
    private Object SHeader;

    public SoapEnvelopeRequest(Object SBody, Object SHeader) {
        this.SBody = SBody;
        this.SHeader = SHeader;
    }
}
