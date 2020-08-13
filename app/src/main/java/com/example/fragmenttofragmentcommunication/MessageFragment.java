package com.example.fragmenttofragmentcommunication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MessageFragment extends Fragment {

    //Instance of OnMessageSendListener
    OnMessageSendListener messageSendListener;
    private Button button;
    private EditText editText;

    public MessageFragment() {
        // Required empty public constructor
    }

    //Interface
    public interface OnMessageSendListener{
        public void onMessageSend(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        button=view.findViewById(R.id.bn);
        editText=view.findViewById(R.id.txt_message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString();
                messageSendListener.onMessageSend(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;
        try{
            messageSendListener=(OnMessageSendListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"Must Implemt OnMessageSend");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}