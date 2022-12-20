package co.jp.hivelocity.glay.ApiRestAdapters;

import android.util.Log;
import co.jp.hivelocity.glay.Configs.APIConfigurations;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistreamingApiRestAdapters {

    static Retrofit retrofitInstance;
    static HVCAPIAuth apiAuth;

    public static Retrofit getRetrofit() {
        if (retrofitInstance == null) {
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(APIConfigurations.HI_STREAMING_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(HttpClientProvider.provideOkHttpClient(provideHiStreamingHeaders()));

            retrofitInstance = retrofitBuilder.build();
        }
        return retrofitInstance;
    }

    public static HVCAPIAuth provideHiStreamingHeaders() {
        if (apiAuth == null) {
            apiAuth = new HVCAPIAuth(
                    APIConfigurations.ApiKey,
                    APIConfigurations.ApiSecret,
                    APIConfigurations.HeaderNameHiApiKey,
                    APIConfigurations.HeaderNameHiTimestamp,
                    APIConfigurations.HeaderNameHiSignature
            );
            Log.e("Building", "FanStreamingHeaders");
        }
        return apiAuth;
    }
}
