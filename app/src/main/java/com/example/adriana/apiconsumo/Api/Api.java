package com.example.adriana.apiconsumo.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adriana on 02-18-18.
 */

public class Api {
    private final static String URL = "https://apirest-adriana.herokuapp.com/api";

    public static String getBase() {
        return URL + "/";
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        System.out.println("MESSAGE API: "+ Api.getBase());
        return retrofit.create(ApiInterface.class);
    }
}
