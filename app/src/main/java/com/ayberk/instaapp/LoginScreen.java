package com.ayberk.instaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {


    //Eklenenler
    //*Button Backgrounds
    //*Drawables in EditTexts
    //*EditText Styles
    //*Splash Screen
    //Added Lottie
    //build.gradle
    //Lottie Animation
    //Adding Splash Screen
    //Waiting
    //Going to the LoginScreen


    Button signupScreenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        signupScreenBtn = findViewById(R.id.signUpBtn);

        //OnClickListeners

        signupScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, SignUpScreen.class);
                startActivity(intent);
            }
        });

    }
}