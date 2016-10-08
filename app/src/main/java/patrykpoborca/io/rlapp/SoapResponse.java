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
public class SoapResponse {
    @Element(name = "Body", required = false)
    private GetVerifyResponse body;

    @Element(name = "Header", required = false)
    private Object header;

    public SoapResponse(GetVerifyResponse body, Object header) {
        this.body = body;
        this.header = header;
    }

    public SoapResponse() {
    }

    public GetVerifyResponse getBody() {
        return body;
    }

    public Object getHeader() {
        return header;
    }
}
