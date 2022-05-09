package com.ayberk.beltek11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class notGiris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_giris);

        //TextView, Button ve EdiText'leri tanımlayalım.
        EditText vize = findViewById(R.id.ilkNot);
        EditText finalNot = findViewById(R.id.ikinciNot);
        Button harfNotu = findViewById(R.id.notHesapla);

        harfNotu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText'lerimize girilmiş olan girdileri alalım ve String formatına dönüştürelim.
                String v = vize.getText().toString();
                String f = finalNot.getText().toString();
                if (!v.contentEquals("")&&!f.contentEquals("")){
                    //Buradaki integer tanımlamasını neden içeride yaptık?
                    int v1 = Integer.parseInt(v);
                    int f1 = Integer.parseInt(f);
                    int ort = ((v1*40)+(f1*60))/100;
                    if (ort > 80){
                        Toast.makeText(getApplicationContext(), "Harf Notu: AA", Toast.LENGTH_SHORT).show();
                    }
                    else if(ort > 60){
                        Toast.makeText(notGiris.this, "Harf Notu:BB", Toast.LENGTH_SHORT).show();
                    }
                    else if(ort > 40){
                        Toast.makeText(getApplicationContext(), "Harf Notu:CC", Toast.LENGTH_SHORT).show();
                    }
                    else if(ort > 20){
                        Toast.makeText(getApplicationContext(), "Harf Notu:DD", Toast.LENGTH_SHORT).show();
                    }
                    else if(ort <= 20){
                        Toast.makeText(notGiris.this, "Harf Notu:FF", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(notGiris.this, "Lütfen girilen değerleri kontrol ediniz!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(notGiris.this, "Lütfen not kısımlarını boş bırakmayınız!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}