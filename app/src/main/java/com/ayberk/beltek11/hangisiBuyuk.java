package com.ayberk.beltek11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class hangisiBuyuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangisi_buyuk);

        //Button, EditText ve ImageView'lerimizi tanımlayalım.
        Button Bul = findViewById(R.id.hangisiBuyukBtn);
        Button anaEkran = findViewById(R.id.backToMainImg);
        EditText sayi1 = findViewById(R.id.ilkSayi);
        EditText sayi2 = findViewById(R.id.ikinciSayi);


        //Ana ekran butonuna basılması halinde kullanıcıyı ana ekrana döndüren onClickListener'ı oluşturalım.
        anaEkran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecis = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gecis);
            }
        });

        //Hesapla butonuna basılması halinde sayıları karşılaştıran onClickListener'ı oluşturalım.
        Bul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1 = sayi1.getText().toString();
                String t2 = sayi2.getText().toString();
                if (!t1.equals("")&&!t2.equals("")){
                    int n1 = Integer.parseInt(t1);
                    int n2 = Integer.parseInt(t2);
                    if (n1 > n2){
                        Toast.makeText(getApplicationContext(), "Birinci sayı daha büyüktür.", Toast.LENGTH_LONG).show();
                    }
                    else if (n2 > n1){
                        Toast.makeText(getApplicationContext(), "İkinci sayı daha büyüktür.", Toast.LENGTH_LONG).show();
                    }
                    else if (n1==n2){
                        Toast.makeText(getApplicationContext(), "Sayılar birbirine eşittir.", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Lütfen girdileri kontrol ediniz.", Toast.LENGTH_LONG);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Lütfen girdileri kontrol ediniz.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}