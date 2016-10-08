package patrykpoborca.io.rlapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by patrykpoborca on 7/29/16.
 */

public interface RetrofitClient {

    @POST("ef")
    @Headers({"SOAPAction : getVerify", "Content-Type : text/xml; charset=\"utf-8\""})
    Call<SoapResponse> getVerify(@Body SoapEnvelopeRequest request);

}
