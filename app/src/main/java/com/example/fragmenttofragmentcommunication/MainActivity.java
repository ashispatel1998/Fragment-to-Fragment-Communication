package com.example.fragmenttofragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import static com.example.fragmenttofragmentcommunication.R.id.fragment_container;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }

            MessageFragment messageFragment=new MessageFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction()
                    .add(fragment_container,messageFragment,null);
            fragmentTransaction.commit();

        }
    }

    @Override
    public void onMessageSend(String message) {
        DisplayFragment displayFragment=new DisplayFragment();

        //Binding the data to bundle object to send to the DisplayFragment
        Bundle bundle=new Bundle();
        // Assigning message (key) = message (value)
        bundle.putString("message",message);
        //setting the argumengts to DisplayFragment object
        displayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction=getSupportFragmentManager()
                .beginTransaction().replace(fragment_container,displayFragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}