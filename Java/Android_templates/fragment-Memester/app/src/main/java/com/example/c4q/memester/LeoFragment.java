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
 * Created by C4Q on 10/5/16.
 */

public class LeoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meme, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView leoImageView = (ImageView) view.findViewById(R.id.meme_image_view);
        leoImageView.setImageResource(R.drawable.meme_leo);
        TextView textView = (TextView) view.findViewById(R.id.meme_caption);
        textView.setText("Leo Meme!");
    }
}
