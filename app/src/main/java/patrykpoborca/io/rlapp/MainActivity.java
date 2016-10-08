package patrykpoborca.io.rlapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Strategy strategy = new AnnotationStrategy();
        final Serializer serializer = new Persister(strategy);
        OkHttpClient client = createClient();
        RetrofitClient retrofit = new Retrofit.Builder()
                .baseUrl("http://interdom.dyndns.org:83/Tracking_WS/")
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(serializer))
                .client(client)
                .build()
                .create(RetrofitClient.class);

        final Handler handler = new Handler();
        retrofit.getVerify(new SoapEnvelopeRequest(new GetVerifyRequest("TKEELER", "1PASSWORD2"), null))
                .enqueue(new Callback<SoapResponse>() {
                    @Override
                    public void onResponse(Call<SoapResponse> call, final Response<SoapResponse> response) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView)findViewById(R.id.result))
                                        .setText("Result = " + response.body().getBody().getProfile().getCompanyProfileReturn());
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<SoapResponse> call, Throwable t) {

                    }
                });
    }

    private OkHttpClient createClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }
}
