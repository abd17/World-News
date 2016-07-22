package com.example.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyFacebook extends AppCompatActivity {
    private WebView mywebView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_facebook);
        mywebView2 =(WebView)findViewById(R.id.webView2);
        WebSettings webSettings=mywebView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView2.loadUrl("https://www.facebook.com/abdu.alfadel");
        mywebView2.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed() {
        if (mywebView2.canGoBack()){
            mywebView2.goBack();
        }
        else {
            super.onBackPressed();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_facebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     //   if (id == R.id.action_settings) {
       //     return true;
       // }

        return super.onOptionsItemSelected(item);
    }
}
