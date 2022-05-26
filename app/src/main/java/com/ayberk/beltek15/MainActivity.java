package com.ayberk.beltek15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    /*
    * Bu dersimizde ekranımızın sağ kısmına Navigation Drawer ekleme işlemini gerçekleştireceğiz.
    * Bunu yapabilmek için öncelikle build.gradle(Module) içerisine import etmemiz gereken
    * Kütüphaneler var.
    *
    * depencencies başlığının altına:
    *
    * implementation 'com.google.android.material:material:1.6.0'
    *
    * şeklinde bir ekleme yapmamız gerekiyor. Bu sayede, Google'ın Android için sağlamış olduğu
    * Material Design ögelerinden faydalanmamız mümkün.
    * Not: Son eklenen sürüm bu örnek hazırlandığı zaman 1.6.0'dı ancak sizin için böyle olmayabilir.
    * Bu durumda Android Studio sizi uyaracaktır.
    *
    *Ayrıca, daha sonra Navigation Drawer ögemizin üst tarafında bir kullanıcı resmi göstermek için
    *
    * implementation 'de.hdodenhof:circleimageview:3.1.0'
    *
    *ögesini de implement ediyoruz.
    *
    * Drawables olarak Navigation Drawer'da kullanacağımız Icon'ları ekleyeceğiz.
    * Daha önce yaptığımız gibi Drawables -> New -> Vector Asset şeklinde devam edeceğiz.
    *
    *
    *Res -> New -> Android Resource File sonrasında ise Resource Type -> Menu
    *
    * Altına her bir menü ögesini item etiketleri içerisinde ekliyoruz. Sonrasında da üsetteki
    * menü etiketinin içerisine
    *
    * tools:showIn="navigation_view" diyoruz. Voila!
    *
    *
    *
    * Şimdi Navigation View'in üst tarafında bulunması gereken header kısmını oluşturacağız.
    * Bunun için öncelikle header kısmını Navigaion View'den ayırmak için bir takım işlemler
    * yapmamız gerekiyor.
    *
    * Res -> Themes -> Themes.xml içerisinde yeni bir style tagi açtıktan sonra, gerekli ayarlamaları
    * yapıyoruz.
    *
    *
    * Sonrasında Layout -> New -> Layout Resource File -> nav_header diyerek navigation barımızın
    * üst kısmında kalacak olan bölgenin oluşturulmasını sağlıyoruz.
    *
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id){

                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Ana Ekran Seçildi.", Toast.LENGTH_SHORT).show();
                    case R.id.messages:
                        Toast.makeText(MainActivity.this, "Mesajlar Seçildi.", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });


    }
}