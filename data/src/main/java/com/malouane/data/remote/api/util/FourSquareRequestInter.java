package com.malouane.data.remote.api.util;

import com.malouane.data.BuildConfig;
import io.reactivex.exceptions.Exceptions;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class FourSquareRequestInter implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request currentRequest = chain.request();

      HttpUrl url = currentRequest.url()
          .newBuilder()
          .addQueryParameter("client_id", BuildConfig.API_ID)
          .addQueryParameter("v", BuildConfig.API_V)
          .addQueryParameter("client_secret", BuildConfig.API_SECRET)
          .build();
        currentRequest = currentRequest.newBuilder().url(url).build();
        try {
            return chain.proceed(currentRequest);
        } catch (IOException e) {
            // Transform checked Exception in Unchecked Exception
            throw Exceptions.propagate(e);
        }

    }
}
