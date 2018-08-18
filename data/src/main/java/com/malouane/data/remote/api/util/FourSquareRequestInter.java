package com.malouane.data.remote.api.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import io.reactivex.exceptions.Exceptions;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class FourSquareRequestInter implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request currentRequest = chain.request();

        HttpUrl url = currentRequest.url().newBuilder().addQueryParameter("name","value").build();
        currentRequest = currentRequest.newBuilder().url(url).build();
        try {
            return chain.proceed(currentRequest);
        } catch (IOException e) {
            // Transform checked Exception in Unchecked Exception
            throw Exceptions.propagate(e);
        }

    }
}
