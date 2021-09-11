package com.example.furkangiyim;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FragmentSignUp extends Fragment {
    private Button buttonSignUp;
    private View myFragment;
    private EditText signup_email;
    private EditText signup_password;
    private EditText signup_name;
    private EditText signup_surname;
    private FirebaseAuth mAuth;
    private ProgressDialog registerProcess;
    private DatabaseReference mDatabase;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_sign_up,container,false);
        buttonSignUp = myFragment.findViewById(R.id.buttonSignUp);
        signup_email = myFragment.findViewById(R.id.signup_email);
        signup_name = myFragment.findViewById(R.id.signup_name);
        signup_surname = myFragment.findViewById(R.id.signup_surname);
        signup_password = myFragment.findViewById(R.id.signup_password);

        mAuth = FirebaseAuth.getInstance();

        registerProcess = new ProgressDialog(this.getActivity());

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signup_name.getText().toString();
                String surname = signup_surname.getText().toString();
                String email = signup_email.getText().toString();
                String password = signup_password.getText().toString();
                if(!TextUtils.isEmpty(name) || !TextUtils.isEmpty(surname) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                    registerProcess.setTitle("Kaydediliyor");
                    registerProcess.setMessage("Hesabınız oluşturuluyor, lütfen bekleyiniz");
                    registerProcess.setCanceledOnTouchOutside(false);
                    registerProcess.show();
                    registerUser(name,surname,email,password);

                }
            }
        });
        return myFragment;
    }

    private void registerUser(String name, String surname, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String user_id = mAuth.getCurrentUser().getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);
                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("name", name);
                    userMap.put("surname", surname);
                    userMap.put("image", "default");
                    mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                registerProcess.dismiss();
                                Intent signUpIntent = new Intent(getActivity(), MainActivity.class);
                                startActivity(signUpIntent);
                            }
                            else {
                                registerProcess.dismiss();
                                Toast.makeText(getContext(), "Hata: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else {
                    registerProcess.dismiss();
                    Toast.makeText(getContext(), "Hata: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}
