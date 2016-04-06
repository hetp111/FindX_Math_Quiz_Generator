package com.hetpatel.findx;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Gameover extends Activity {

    TextView textView1, textView2, textView3, textView4;
    private AdView adView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        adView = (AdView) findViewById(R.id.BannerAd1_2);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        textView1 = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView4);
        textView3 = (TextView) findViewById(R.id.textView5);
        textView4 = (TextView) findViewById(R.id.textView6);


        SharedPreferences sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);
        String randomScore = sharedPreferences.getString("randomScore", "");
        String arithmeticScore = sharedPreferences.getString("arithmeticScore","");
        String algebraScore = sharedPreferences.getString("algebraScore","");
        String geometryScore = sharedPreferences.getString("geometryScore","");

        textView1.setText("Random Score: "+randomScore);
        textView2.setText("Arithmetic Score: "+arithmeticScore);
        textView3.setText("Algebra Score: "+algebraScore);
        textView4.setText("Geometry Score: "+geometryScore);
    }
}
