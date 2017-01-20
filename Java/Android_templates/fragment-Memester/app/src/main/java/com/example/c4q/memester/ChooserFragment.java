package com.example.c4q.memester;

import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentManager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by C4Q on 10/5/16.
 */
public class ChooserFragment extends Fragment {
    public static String TAG = "ChooseMemes";

    Button meme1, meme2, meme3, meme4;

    public ChooserFragment(){
        //default constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chooser, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        meme1 = (Button) view.findViewById(R.id.meme_archer);
        meme2 = (Button) view.findViewById(R.id.meme_purr);
        meme3 = (Button) view.findViewById(R.id.meme_leo);
        meme4 = (Button) view.findViewById(R.id.meme_putin);


        meme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigates to Meme 1
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_container, new ArcherFragment(), "Archer").commit();
            }
        });

        meme2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_container, new PurrFragment() ,"Purr").commit();

            }
        });

        meme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_container, new LeoFragment(), "Leo").commit();

            }
        });

        meme4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                FragmentManager fragmentManager = activity.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_container, new PutinFragment(), "Putin").commit()
                ;
            }
        });
    }
}
