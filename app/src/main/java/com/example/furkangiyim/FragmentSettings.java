package com.example.furkangiyim;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FragmentSettings extends Fragment {
    private FirebaseAuth mAuth;
    private View myFragment;
    private Button buttonNotifications;
    private Button buttonAboutUs;
    private Button buttonCommunication;
    private Button buttonChangePassword;
    private Button buttonEvaluateApp;
    private Button buttonSignOut;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        myFragment = inflater.inflate(R.layout.fragment_settings_layout,container,false);
        buttonNotifications = myFragment.findViewById(R.id.buttonNotifications);
        buttonAboutUs = myFragment.findViewById(R.id.buttonAboutUs);
        buttonCommunication = myFragment.findViewById(R.id.buttonCommunication);
        buttonChangePassword = myFragment.findViewById(R.id.buttonChangePassword);
        buttonEvaluateApp = myFragment.findViewById(R.id.buttonEvaluateApp);
        buttonSignOut = myFragment.findViewById(R.id.buttonSignOut);

        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        return myFragment;
    }
}
