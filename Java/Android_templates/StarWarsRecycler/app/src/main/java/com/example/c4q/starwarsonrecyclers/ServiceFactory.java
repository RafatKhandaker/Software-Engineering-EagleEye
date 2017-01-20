package com.example.c4q.starwarsonrecyclers;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C4Q on 11/5/16.
 */

public class ServiceFactory {
    private static final String swapiUrl = "http://swapi.co/api/";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder; //builder.build() will retrun our retrofit instance.

    public static SwapiService createService(){
        if(retrofit == null){
            builder = new Retrofit.Builder()
                    .baseUrl(swapiUrl)
                    .addConverterFactory(GsonConverterFactory.create());

        }
        retrofit = builder.build();
        return retrofit.create(SwapiService.class);
    }
}

