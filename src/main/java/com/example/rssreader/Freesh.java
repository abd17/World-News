package com.example.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Freesh extends AppCompatActivity {
    private WebView mywebView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freesh);
        mywebView3 =(WebView)findViewById(R.id.webView3);
        WebSettings webSettings=mywebView3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView3.loadUrl("http://www.livenewsbox.com/american/cnn-news-usa.html");
        mywebView3.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed() {
        if (mywebView3.canGoBack()){
            mywebView3.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_freesh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      //  if (id == R.id.action_settings) {
       //     return true;
      //  }

        return super.onOptionsItemSelected(item);
    }
}
