package com.ayberk.beltek16;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usernameEdt = findViewById(R.id.usernameEdt);
        EditText passwdEdt = findViewById(R.id.passwdEdt);
        Button loginBtn = findViewById(R.id.loginBtn);
        Button signUpBtn = findViewById(R.id.signUpBtn);
        db = new database(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainActivity.this, signUpScreen.class);
                startActivity(signup);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString();
                String passwd = passwdEdt.getText().toString();
                if (username.equals("") ||passwd.equals("")){
                    Toast.makeText(MainActivity.this, "Lütfen bütün alanları doldurun", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuser = db.checkall(username,passwd);
                    if (checkuser){
                        Toast.makeText(MainActivity.this, "Giriş yapılıyor...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, mainScreen.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Lütfen bilgilerinizi kontrol ediniz!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}