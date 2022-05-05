package com.ayberk.beltek11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ayniMi extends AppCompatActivity {

    //Button, EditText, TextView ve ImageView'lerimizi tanımlayalım.

    Button mainScreen = findViewById(R.id.backToMain);
    Button hesapla = findViewById(R.id.ayniMiBtn);
    ImageView anaEkran = findViewById(R.id.backToMainImg);
    EditText sayi1 = findViewById(R.id.ilkSayi);
    EditText sayi2 = findViewById(R.id.ikinciSayi);
    TextView sonuc = findViewById(R.id.ayniMiSonuc);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayni_mi);




        //Ana ekrana dön butonuna basılması halinde uygulamayı ana ekrana döndüren işlemler gerçekleştirilir.
        mainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecis = new Intent(ayniMi.this, MainActivity.class);
                startActivity(gecis);
            }
        });

        //Ana ekran logosuna dokunulması halinde uygulamayı ana ekrana döndüren işlemler gerçekleştirilir.
        anaEkran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecis = new Intent(ayniMi.this, MainActivity.class);
                startActivity(gecis);
            }
        });

        //Butona basılması halinde iki sayının aynı olma durumunu kontrol eden işlem gerçekleştirilir.
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String ilksayi = sayi1.getText().toString();
              String ikincisayi = sayi2.getText().toString();
              if(ilksayi.contentEquals(ikincisayi)){
                  Toast.makeText(ayniMi.this, "Verilen sayılar aynı!", Toast.LENGTH_SHORT);
                  //sonuc.setText("Verilen Sayılar Aynı!");
              }
              else if (!ilksayi.contentEquals(ikincisayi)){
                  Toast.makeText(ayniMi.this, "Verilen sayılar farklı!", Toast.LENGTH_SHORT);
                  //sonuc.setText("Verilen Sayılar Farklı!");
              }
              else{
                  Toast.makeText(ayniMi.this, "Hatalı giriş!", Toast.LENGTH_LONG);
                  //sonuc.setText("Hatalı Giriş!");
              }
            }
        });
    }
}