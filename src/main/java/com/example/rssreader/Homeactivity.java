package com.example.rssreader;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Homeactivity extends AppCompatActivity {
    private WebView mywebView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        mywebView4 =(WebView)findViewById(R.id.webView4);

        MobileAds.initialize(getApplicationContext(),"ca-app-pub-8320485184835390/5206768461");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        WebSettings webSettings=mywebView4.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView4.loadUrl("http://arabic.cnn.com/");
        mywebView4.setWebViewClient(new WebViewClient());


    }
    @Override
    public void onBackPressed() {
        if (mywebView4.canGoBack()){
            mywebView4.goBack();
        }
        else {
            super.onBackPressed();
        }
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homeactivity, menu);
        return true;
    }
public void gocallus(View view){
    Intent intent=new Intent(this,CallusActivity.class);
    startActivity(intent);
}


    public void gooffers(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            Intent intent=new Intent(this,Homeactivity.class);
            startActivity(intent);
        }
//else  if (id == R.id.theme) {
          //  AlertDialog.Builder builder=new AlertDialog.Builder(this);
          //  builder.setMessage("اختر شكل البرنامج")
              //      .setTitle("اختر شكل البرنامج")
              //      .setPositiveButton("ابيض", new DialogInterface.OnClickListener() {
               //         @Override
                //        public void onClick(DialogInterface dialogInterface, int id) {

                 //       }
                //    })
// .setNegativeButton("أسود", new DialogInterface.OnClickListener() {
   // @Override
   // public void onClick(DialogInterface dialogInterface, int id) {

  //  }
//}).show();

       // }
      else if (id == R.id.sprt) {
            Intent intent=new Intent(this,Aboutactivity.class);
            startActivity(intent);
        }
       else if (id == R.id.rate) {
           return true;
        }
        else if (id == R.id.copy) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(" 0.1")
                    .setTitle("اصدار البرنامج  ")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int id) {

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int id) {

                        }
                    }).show();
        }
        else if (id == R.id.exit) {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
