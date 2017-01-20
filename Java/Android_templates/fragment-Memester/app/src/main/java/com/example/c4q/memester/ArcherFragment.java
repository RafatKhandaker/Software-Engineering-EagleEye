package com.example.c4q.memester;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by C4Q on 10/5/16.
 */
public class ArcherFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_meme, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView = (ImageView) view.findViewById(R.id.meme_image_view);
        TextView textView = (TextView) view.findViewById(R.id.meme_caption);
        imageView.setImageResource(R.drawable.meme_archer);
        textView.setText("Archer Meme");
    }
}
