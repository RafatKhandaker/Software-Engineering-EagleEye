package com.example.c4q.memester;

import android.app.Activity;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hostFragment(new ChooserFragment());
    }

    @Override
    public void onBackPressed() {
        hostFragment(new ChooserFragment());
    }

    public void hostFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment).commit();
    }


}
