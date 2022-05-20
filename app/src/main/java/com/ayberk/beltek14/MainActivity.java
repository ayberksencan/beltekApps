package com.ayberk.beltek14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/*
* Öncelikle ana ekranda bir adet FragmentView oluşturuyoruz.
* Fragmentlerimizi bu FragmentView içerisinde göstereceğiz.
* Sonrasında bu FragmentView'in altında kalan boş kısma iki adet buton oluşturuyoruz.
* Şimdilik Fragment'lerimiz arasında bu şekilde geçiş yapacağız.
* Sonrasında App -> New -> Fragment -> Blank Fragment yolunu izleyerek iki adet Fragment oluşturuyoruz.
* Fragment'lerimizin isimlerini verdikten ve oluşturduktan sonra, içlerinde onCreateView fonksiyonu dışındaki her şeyi siliyoruz.
* Ama neden?
* Fragmet'lerimizin içerisine birbirinden ayırabilmek için iki adet arka plan rengi ve iki adet TextView ekliyoruz.
* Bunu iki fragment için de yaptıktan sonra bu Fragment'lerimizin Java kodlarını yazma kısmına geçebiliriz.
* Fragment sınıflarımızın içerisinde fonksiyon dışına bir view tanımladıktan sonra, return kısmının yanında yazan kısmı bu View'e atıyoruz.
* Ve sonrasında bu view'i return ediyoruz.
* Main Activity içerisinde Button'larımızı ve bu Buttonların onClickListener'larını yazıyoruz.
* içlerine de fragementDegistir(new fragment1()); ve  fragmentDegistir(new fragment2()); yazabiliriz.
* (fragmentDegistir fonksiyonunu birazdan oluşturacağız.)
* Bu fragmentDegistir fonksiyonu, FragmentView içerisinde fragmentler arası geçiş yapmamızı sağlayacak olan kodları içerecek.
* Bunun için ise Android'in FragmentManager yani Fragment Yöneticisi'nden yararlanacağız.
* fragmentDegistir fonksiyonunu oluşturduktan sonra, içerisine fragment yöneticisi için gerekli olan kodları yazıyoruz.
* <-------------------------------------------------------Fragment'ler Arası Geçiş Bölüm Sonu----------------------------------------------->
*/
























public class MainActivity extends AppCompatActivity {

    Button firstFragmentBtn, secondFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragmentBtn = findViewById(R.id.fragment1btn);
        secondFragmentBtn = findViewById(R.id.fragment2btn);

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentDegistir(new fragment1());

            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentDegistir(new fragment2());

            }
        });

        /*<------------------------Fragment Bölüm Sonu--------------------------------------------------->*/

        Button nextActivity = findViewById(R.id.activity2btn);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gecis = new Intent(MainActivity.this, FragmentTab.class);
                startActivity(gecis);
            }
        });

    }

    private void fragmentDegistir(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}