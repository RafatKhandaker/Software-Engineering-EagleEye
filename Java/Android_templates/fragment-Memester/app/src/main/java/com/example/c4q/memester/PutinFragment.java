package com.example.c4q.memester;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RedDragon on 10/5/16.
 */

public class PutinFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_meme, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
       // super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.meme_image_view);
        TextView textView = (TextView) view.findViewById ((R.id.meme_caption));
        imageView.setImageResource(R.drawable.meme_putin);
        textView.setText("meme putin");
    }

}
