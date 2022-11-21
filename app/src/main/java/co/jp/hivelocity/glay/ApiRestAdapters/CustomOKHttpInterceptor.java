package co.jp.hivelocity.glay.ApiRestAdapters;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CustomOKHttpInterceptor implements Interceptor {

    private HVCAPIAuth auth;

    public CustomOKHttpInterceptor(HVCAPIAuth auth) {
        this.auth = auth;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (auth != null) {
            HashMap<String, String> headers = auth.headers();

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
                Log.d(entry.getKey(), entry.getValue());
            }
        }

        builder.addHeader("User-Agent", "Android-User");
        Request request = builder.build();
        return chain.proceed(request);
    }
}