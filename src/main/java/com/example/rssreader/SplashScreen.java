package com.example.rssreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.example.rssreader.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        ImageView image = new ImageView(this); // انشاء صورة جديدة
        image.setImageResource(R.drawable.splshscrn); // مسار الصورة التي يتم عرضها في بداية تشغيل التطبيق
        setContentView(image); // اعرض الصورة
        /****** انشاء ثريد لجعل التطبيق ينام لمدة 5 ثواني  *************/
        Thread background = new Thread() {
            public void run() {

                try {

                    sleep(5 * 1000); // غير في الرقم 5 لتغيير عدد الثواني .. ثواني الانتظار قبل الدخول للتطبيق

                    // بعد 5 ثواني نفذ التالي وهو الانتقال بنا الى الشاشة الرئيسية
                    Intent i = new Intent(getBaseContext(), Homeactivity.class);
                    startActivity(i);

                    // اغلاق شاشة السبلاش بشكل كلشي بعد الانتقال
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // تشغيل الثريد السابق
        background.start();
    }
}
