package com.example.c4q.saturdaycodelab.fibonacci;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.c4q.saturdaycodelab.R;

import java.util.regex.Pattern;

/**
 * Created by C4Q on 11/4/16.
 */

public class FibonacciFragment extends Fragment {

    private TextView answerTV;
    private FibonacciCalculator calculator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new FibonacciCalculator();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fibonacci, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        answerTV = (TextView) view.findViewById(R.id.answer_textview);
        TextView definitionTV = (TextView) view.findViewById(R.id.def_textview);
        Pattern pattern = Pattern.compile("en.wikipedia.org/wiki/Fibonacci_number");
        Linkify.addLinks(definitionTV, pattern, "http://");
        NumberPicker picker = (NumberPicker) view.findViewById(R.id.number_picker);
        picker.setMaxValue(10000);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int answer = calculator.calculateNthFibNumber(newVal);
                answerTV.setText(String.valueOf(answer));
            }
        });
    }


}
