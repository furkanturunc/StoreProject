package com.example.furkangiyim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginActivity extends AppCompatActivity {
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    //private RadioButton radioButton2;
    //private RadioButton radioButton3;
    private Button buttonSignUp;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Fragment tempFragment;
    private Button buttonGo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user_layout);

        radioGroup = findViewById(R.id.radioGroup);
        buttonSignUp = findViewById(R.id.buttonSignUp);


        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu2, new FragmentHesabim()).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();

                        // find the radiobutton by returned id
                        radioButton = (RadioButton) findViewById(selectedId);
                        if(radioButton.getText().equals("Üye Girişi")) {
                            tempFragment = new FragmentSignIn();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu2, tempFragment).commit();

                        }
                        else if(radioButton.getText().equals("Üye Olmak İstiyorum")) {
                            tempFragment = new FragmentSignUp();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu2, tempFragment).commit();

                        }
                        else {
                            tempFragment = new FragmentWithoutMembership();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu2, tempFragment).commit();
                        }
                        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu2, tempFragment).commit();

                    }
                });
    }


}
