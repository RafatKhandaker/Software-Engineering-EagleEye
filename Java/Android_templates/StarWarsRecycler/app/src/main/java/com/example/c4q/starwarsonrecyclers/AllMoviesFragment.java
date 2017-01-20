package com.example.c4q.starwarsonrecyclers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.starwarsonrecyclers.pojos.Result;
import com.example.c4q.starwarsonrecyclers.pojos.SwapiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by C4Q on 11/5/16.
 */

public class AllMoviesFragment extends Fragment {

    private static final String TAG = AllMoviesFragment.class.getSimpleName();
    SwapiService service;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = ServiceFactory.createService();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Call<SwapiResponse> movieCall = service.listPeople();
        movieCall.enqueue(new Callback<SwapiResponse>() {

            @Override
            public void onResponse(Call<SwapiResponse> call, Response<SwapiResponse> response) {
                SwapiResponse swapiResp = response.body();
                List<Result> results = swapiResp.getResults();
                Log.d(TAG, "There was a success" + response);
            }

            @Override
            public void onFailure(Call<SwapiResponse> call, Throwable t) {
                Log.d(TAG, "There was a failure" + t);
            }
        });

    }
}
