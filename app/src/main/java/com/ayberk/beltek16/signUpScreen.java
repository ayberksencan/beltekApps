package com.ayberk.beltek16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUpScreen extends AppCompatActivity {

    database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        EditText usernameEdt = findViewById(R.id.usernameEdt);
        EditText passwdEdt = findViewById(R.id.passwdEdt);
        Button signUpBtn = findViewById(R.id.signUpBtn);
        Button loginBtn = findViewById(R.id.signIn);
        DB = new database(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anaEkran = new Intent(signUpScreen.this, MainActivity.class);
                startActivity(anaEkran);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameEdt.getText().toString();
                String password = passwdEdt.getText().toString();
                if (user.equals("") || password.equals("")){
                    Toast.makeText(signUpScreen.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuser = DB.checkusername(user);
                    if (!checkuser){
                        Boolean insert = DB.insertData(user, password);
                        if (insert){
                            Toast.makeText(signUpScreen.this, "Kayıt Başarılı!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signUpScreen.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(signUpScreen.this, "Kayıt Başarısız!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signUpScreen.this, "Kullanıcı zaten mevcut!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}