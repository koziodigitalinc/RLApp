package patrykpoborca.io.rlapp;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by patrykpoborca on 8/2/16.
 */

@Root
public class GetVerifyResponse {

    @Namespace(reference = "http://ef.CompanyWS/", prefix = "ns2")
    @Element(name = "getVerifyResponse")
    private CompanyProfile profile;

    public GetVerifyResponse(CompanyProfile profile) {
        this.profile = profile;
    }

    public GetVerifyResponse() {
    }


    public CompanyProfile getProfile() {
        return profile;
    }

    public static final class CompanyProfile {
        @Element(name = "CompanyProfileReturn")
        private int companyProfileReturn;

        public int getCompanyProfileReturn() {
            return companyProfileReturn;
        }

        public CompanyProfile() {
        }

        public CompanyProfile(int companyProfileReturn) {
            this.companyProfileReturn = companyProfileReturn;
        }
    }
}
