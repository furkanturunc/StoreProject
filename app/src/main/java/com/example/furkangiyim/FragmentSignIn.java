package com.example.furkangiyim;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentSignIn extends Fragment {
    private View myFragment;
    private Button buttonSignIn;
    private EditText signin_email;
    private EditText signin_password;
    private ProgressDialog loginProgress;
    private FirebaseAuth mAuth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_signin_layout,container,false);
        buttonSignIn = myFragment.findViewById(R.id.buttonSignIn);
        signin_email = myFragment.findViewById(R.id.signin_email);
        signin_password = myFragment.findViewById(R.id.signin_password);
        loginProgress = new ProgressDialog(this.getActivity());
        mAuth = FirebaseAuth.getInstance();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signin_email.getText().toString();
                String password = signin_password.getText().toString();
                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                    loginProgress.setTitle("Oturum açılıyor");
                    loginProgress.setMessage("Hesabınıza giriş yapılıyor, lütfen bekleyiniz");
                    loginProgress.setCanceledOnTouchOutside(false);
                    loginProgress.show();
                    loginUser(email,password);
                }
                else {
                    Toast.makeText(getContext(), "Lütfen ilgili alanları doldurduğunuzdan emin olun", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return myFragment;
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    loginProgress.dismiss();
                    Intent loginIntent = new Intent(getActivity(), MainActivity.class);
                    startActivity(loginIntent);
                }
                else {
                    loginProgress.dismiss();
                    Toast.makeText(getContext(), "Hata: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
