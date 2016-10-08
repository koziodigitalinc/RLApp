package patrykpoborca.io.rlapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

/**
 * Created by patrykpoborca on 8/2/16.
 */
public class GetVerifyRequest {

    @Namespace(reference = "http://ef.CompanyWS/", prefix = "ef")
    @Element(name = "getVerify")
    private GetVerify getVerify;

    public GetVerifyRequest(String userName, String password) {
        this.getVerify = new GetVerify(userName, password);
    }


    public static final class GetVerify {
        @Element(name = "User")
        private String userName;

        @Element(name = "Pass")
        private String passWord;

        public GetVerify(String userName, String password) {
            this.userName = userName;
            this.passWord = password;
        }


        public String getUserName() {
            return userName;
        }

        public String getPassWord() {
            return passWord;
        }
    }
}
