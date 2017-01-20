package com.example.c4q.starwarsonrecyclers;

import com.example.c4q.starwarsonrecyclers.pojos.SwapiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by C4Q on 11/5/16.
 */

public interface SwapiService {

    @GET("films/")
    Call<SwapiResponse> listMovies();

    @GET("people/")
    Call<SwapiResponse> listPeople();
}
