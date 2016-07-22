package com.example.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CallusActivity extends AppCompatActivity {
    private WebView mywebView20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callus);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8320485184835390/5206768461");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mywebView20 =(WebView)findViewById(R.id.webView20);
        WebSettings webSettings=mywebView20.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView20.loadUrl("http://arabic.cnn.com/gallery");
        mywebView20.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (mywebView20.canGoBack()){
            mywebView20.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_callus, menu);
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
          //  return true;
      //  }

        return super.onOptionsItemSelected(item);
    }
}
