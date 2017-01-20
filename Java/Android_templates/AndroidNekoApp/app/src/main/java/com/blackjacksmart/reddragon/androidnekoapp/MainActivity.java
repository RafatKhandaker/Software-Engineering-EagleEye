package com.blackjacksmart.reddragon.androidnekoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/** PUZZLE APP THAT WILL UPDATE A MODIFIABLE GRID VIEW AFTER COLLECTING PIECES EVERY 30 MIN
 * SQL DATABASE WITH RECYCLER **/

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateRecyclerView();
    }

    public void initiateRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
