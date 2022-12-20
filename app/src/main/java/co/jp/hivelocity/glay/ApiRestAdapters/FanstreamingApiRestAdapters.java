package co.jp.hivelocity.glay.ApiRestAdapters;

import android.util.Log;

import co.jp.hivelocity.glay.Configs.APIConfigurations;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FanstreamingApiRestAdapters {
    static Retrofit retrofitInstance;
    static HVCAPIAuth apiAuth;

    public static Retrofit getRetrofit() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(APIConfigurations.FAN_STREAMING_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(HttpClientProvider.provideOkHttpClient(provideFanStreamingHeaders()));

            retrofitInstance = retrofitBuilder.build();
        }
        return retrofitInstance;
    }

    public static HVCAPIAuth provideFanStreamingHeaders() {
        if (apiAuth == null) {
            apiAuth = new HVCAPIAuth(
                    APIConfigurations.ApiKey,
                    APIConfigurations.ApiSecret,
                    APIConfigurations.HeaderNameFanApiKey,
                    APIConfigurations.HeaderNameFanTimestamp,
                    APIConfigurations.HeaderNameFanSignature
            );
            Log.e("Building", "FanStreamingHeaders");
        }
        return apiAuth;
    }
}
