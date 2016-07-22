package com.example.rssreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    eldeeb eldeeb=new eldeeb(this);
    int x=0;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8320485184835390/5206768461");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
           //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          //              .setAction("Action", null).show();
        //  }
      // });

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        ReadRss readRss=new ReadRss(this,recyclerView);
        readRss.execute();
        new eldeeb(this).new notify(1, "عاجل", "", R.drawable.cnnicon, R.drawable.cnnicon, x).big("", " لديك تنبيهات اخبار عاجلة اخرى")
                .onclick(eldeeb.browser("http://arabic.cnn.com/"))
                .action(R.drawable.share, "مشاركة", eldeeb.share("مشاركة الخبر"))
               // .action(R.drawable.reply, "ارسال رسالة", eldeeb.sms("123456", "ارسال رسالة"))
                .show();
        ;
        x++;

    }
public void Home(View view){
    Intent intent=new Intent(this,Homeactivity.class);
    startActivity(intent);

}
    public void fresh(View view){
        Intent intent=new Intent(this,Freesh.class);
        startActivity(intent);
    }
    public void Items(View view){
        Intent intent1=new Intent(this,Freesh.class);
startActivity(intent1);
    }
    public void About(View view){
        Intent intent2=new Intent(this,Aboutactivity.class);
        startActivity(intent2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

        return super.onOptionsItemSelected(item);
    }
}
