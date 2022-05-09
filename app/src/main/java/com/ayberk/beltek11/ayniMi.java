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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayni_mi);

        //Button, EditText, TextView ve ImageView'lerimizi tanımlayalım.
        Button hesapla = (Button) findViewById(R.id.ayniMiBtn);
        Button anaEkran = findViewById(R.id.backToMainImg);
        EditText sayi1 = findViewById(R.id.ilkSayi);
        EditText sayi2 = findViewById(R.id.ikinciSayi);


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

              if(ilksayi.contentEquals("")||ikincisayi.contentEquals("")){
                  Toast.makeText(ayniMi.this, "Lütfen girdileri kontrol ediniz!", Toast.LENGTH_SHORT).show();
              }
              else if(ilksayi.contentEquals(ikincisayi)){
                  Toast.makeText(ayniMi.this, "Verilen sayılar aynı!", Toast.LENGTH_SHORT).show();
                  //sonuc.setText("Verilen Sayılar Aynı!");
              }
              else if (!ilksayi.contentEquals(ikincisayi)){
                  Toast.makeText(ayniMi.this, "Verilen sayılar farklı!", Toast.LENGTH_SHORT).show();
                  //sonuc.setText("Verilen Sayılar Farklı!");
              }
            }
        });
    }
}