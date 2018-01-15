package com.smarthec.movieapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smarthec.movieapp.constants.Provider;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Jorge Henao on 14/01/2018.
 */

public class Util {

    private static Retrofit retrofit = null;

    /**
     * Retorna la instancia de retrofit
     *
     * @return
     */
    public static Retrofit getClient() {

        if (retrofit == null) {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Provider.URL_MAIN)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(buildClient())
                    .build();
        }

        return retrofit;
    }

    /**
     * Metodo utilizado para construir un objeto OkHttpClient
     *
     * @return
     */
    public static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}
