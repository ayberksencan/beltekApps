package com.ayberk.beltek13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.ayberk.beltek13.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    //İlk olarak XML dosyamıza bir FrameLayout ve bir BottomNavigationView ekliyoruz.
    //Bottom Navigation Bar'ı bu view üzerinde göstereceğiz.
    //Sonrasında BottomNavigationView'ün Constraintlerini oluşturuyoruz.
    //Start ve Bottom Constraintleri Parent olacak şekilde ayarlıyoruz.
    //Genişlik match_parent, yükseklik ise wrap_content olmalı.
    //Sizce neden?
    //FrameLayout için ise, yatay eksendeki constraintlerimiz ve Top constrainti
    //parent olacak, Bottom constrainti ise BottomNavView'in üstüne tutturuyoruz.
    //Sonrasında, frameLayout için genişlik ve yükseklik değerlerini 0dp olarak giriyoruz.
    //BottomNavBar'daki görseller için Drawable içerisinde New -> VectorAsset -> ClipArt (Her biri için)
    //Right Click on res -> new Android Resource Directory -> Menu (Seçilecek) -> oluşan menu klasörüne
    //sağ tıklanarak new new -> Menu Resource File -> isim (bottomNavMenu) -> XML'de palette'ten
    //Kaç tane istiyorsak menu altına o sayıda menu item ekliyoruz.
    //Bu Item'lara id ve icon (android:icon="@drawable/..."veriyoruz.
    //MainActivity XML'e gidip, BottomNavView içerisinde, "app:menu="@menu/bottomNavMenu" " diyerek
    //Oluşturduğumuz menü ögesini ana ekranımızın XML'ine ekliyoruz.
    //app -> new -> fragment(Menüdeki öge sayısı kadar) -> Her fragment için gerekli XML tasarımını
    //yapıyoruz. Şimdilik sadece farklı arka plan rengi ya da farklı yazılar olan TextView verebiliriz.
    //build.gradle(module) içerisinde
    /*
    * buildFeatures{
    * viewBinding true
    * }
    * */
    //yapıyoruz.
    //FrameLayout ve BottomNavView için id vermiş olduğumuzu kontrol ediyoruz.

    //Öncelikle import ediyoruz.
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Bunu yazmaksak uygulama ilk açıldığında düz MainActivity gelir.
        replaceFragment(new homeFragment());

        //Selection kontrolü yapıyoruz.
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            //Seçili olan ekranın fragment'ının ekranda gösterilmesini sağlıyoruz.
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new homeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new profileFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new settingsFragment());
                    break;
            }
            return true;
        } );
    }

    //Fragment'lar arası geçiş yapabilmek için kullandığımız fonksiyon.
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}