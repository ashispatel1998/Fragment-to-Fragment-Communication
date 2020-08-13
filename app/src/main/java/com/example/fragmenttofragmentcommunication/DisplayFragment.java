package com.example.fragmenttofragmentcommunication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayFragment extends Fragment {

    TextView textView;


    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_display, container, false);
        textView=view.findViewById(R.id.txt_display_message);

        Bundle bundle=getArguments();
        String message=bundle.getString("message");
        textView.setText(message);
        return view;
    }
}