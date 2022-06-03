package com.ayberk.instaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    TextView welcomeTxt;
    LottieAnimationView anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        welcomeTxt = findViewById(R.id.loginTxt);
        anim = findViewById(R.id.animation);

        welcomeTxt.animate().translationY(-1600).setDuration(1000).setStartDelay(3000);
        anim.animate().translationY(1400).setDuration(1000).setStartDelay(3000);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(login);
            }
        }, 4000);

    }
}