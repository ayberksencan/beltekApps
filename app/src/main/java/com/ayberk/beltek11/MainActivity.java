//BELTEK 05/05/22
//Arş. Gör. Ömer Ayberk ŞENCAN

package com.ayberk.beltek11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//Bu sınıf uygulamamızın ana sayfasını temsil ediyor. Diğer ekranlara bu sayfa ile ulaşacağız.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttonlarımızı tanımlayalım.
        Button ayniMi = findViewById(R.id.ayniMi);
        Button hangisiBuyuk = findViewById(R.id.hangisiBuyuk);
        Button notGiris = findViewById(R.id.notDurumu);
        Button otopark = findViewById(R.id.otoparkUcret);

        //Butona basılması halinde ayniMi sınfına geçmek için bir onClickListener oluşturuyoruz.
        ayniMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Itent türünden bir nesne oluşturarak geçiş işleminin gerçekleştirilmesini sağlıyoruz.
                //Intent'in girdilerine dikkat.
                Intent gecis = new Intent(MainActivity.this, com.ayberk.beltek11.ayniMi.class);
                startActivity(gecis);
            }
        });

        //Butona basılması halinde hangisiBuyuk sınıfına geçmek için bir onClickListener oluşturuyoruz.
        hangisiBuyuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Itent türünden bir nesne oluşturarak geçiş işleminin gerçekleştirilmesini sağlıyoruz.
                //Intent'in girdilerine dikkat.
                Intent gecis = new Intent(MainActivity.this, com.ayberk.beltek11.hangisiBuyuk.class);
                startActivity(gecis);
            }
        });

        //Butona basılması halinde notGiris sınıfına geçmek için bir onClickListener oluşturuyoruz.
        notGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Itent türünden bir nesne oluşturarak geçiş işleminin gerçekleştirilmesini sağlıyoruz.
                //Intent'in girdilerine dikkat.
                Intent gecis = new Intent(MainActivity.this, com.ayberk.beltek11.notGiris.class);
                startActivity(gecis);
            }
        });

        //Butona basılması halinde otoparkUcret sınıfına geçmek için bir onClickListener oluşturuyoruz.
        otopark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Itent türünden bir nesne oluşturarak geçiş işleminin gerçekleştirilmesini sağlıyoruz.
                //Intent'in girdilerine vr öncekilerle farklarına dikkat.
                Intent gecis = new Intent(MainActivity.this, otoparkUcret.class);
                startActivity(gecis);
            }
        });
    }}