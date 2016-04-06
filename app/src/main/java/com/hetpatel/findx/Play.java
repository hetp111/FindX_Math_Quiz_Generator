package com.hetpatel.findx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Play extends Activity {

    private AdView adView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        adView = (AdView) findViewById(R.id.BannerAd1_4);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public void play_random_button(View view){
        Intent i = new Intent(this, PlayScreen.class);
        i.putExtra("type","random");
        startActivity(i);
    }

    public void play_arithmetic_button(View view){
        Intent i = new Intent(this, PlayScreen.class);
        i.putExtra("type","arithmetic");
        startActivity(i);
    }

    public void play_algebra_button(View view){
        Intent i = new Intent(this, PlayScreen.class);
        i.putExtra("type","algebra");
        startActivity(i);
    }

    public void play_geometry_button(View view){
        Intent i = new Intent(this, PlayScreen.class);
        i.putExtra("type","geometry");
        startActivity(i);
    }

}
