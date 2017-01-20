package com.example.c4q.saturdaycodelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.c4q.saturdaycodelab.fibonacci.FibonacciFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new FibonacciFragment())
                .commit();
    }
}
