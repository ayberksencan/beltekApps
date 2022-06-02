package com.ayberk.chboxrdbtn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int fiyat;
    String secim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fiyat = 15;
        TextView fiyatTxt = findViewById(R.id.fiyat);
        CheckBox mBuyutme = findViewById(R.id.menuBuyutme);
        RadioGroup group = findViewById(R.id.radioGroup);
        RadioButton ayran = findViewById(R.id.ayran);
        RadioButton kola = findViewById(R.id.kola);
        secim = "";


        mBuyutme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    fiyat = fiyat + 3;
                    //fiyatTxt.setText("Fiyat: 18₺");
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺");
                    mBuyutme.setText("3₺ farkla menü büyütüldü!");
                }
                else{
                    fiyat = fiyat - 3;
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺" );
                    mBuyutme.setText("3₺ farkla menünüzü büyütmek ister misin?");
                }
            }
        });

        ayran.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(secim.equals("kola")){
                    fiyat = fiyat - 2;
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺");
                    secim = "ayran";
                }
                else{
                    fiyat = fiyat + 5;
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺");
                    secim = "ayran";
                }
            }
        });

        kola.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(secim.equals("ayran")){
                    fiyat = fiyat + 2;
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺");
                    secim = "kola";
                }
                else{
                    fiyat = fiyat + 7;
                    fiyatTxt.setText("Fiyat: " + fiyat + " ₺");
                    secim = "kola";
                }
            }
        });
    }
}