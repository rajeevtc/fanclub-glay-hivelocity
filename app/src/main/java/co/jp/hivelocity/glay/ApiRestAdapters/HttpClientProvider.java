package co.jp.hivelocity.glay.ApiRestAdapters;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class HttpClientProvider {

    private static OkHttpClient okHttpClient;
    private static CustomOKHttpInterceptor customOKHttpInterceptor;

    public static OkHttpClient provideOkHttpClient(HVCAPIAuth auth) {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.addInterceptor(provideCustomOkhttpInterceptor(auth));
        okHttpClient = builder.build();
        return okHttpClient;
    }

    private static CustomOKHttpInterceptor provideCustomOkhttpInterceptor(HVCAPIAuth auth) {
        customOKHttpInterceptor = new CustomOKHttpInterceptor(auth);
        return customOKHttpInterceptor;
    }
}