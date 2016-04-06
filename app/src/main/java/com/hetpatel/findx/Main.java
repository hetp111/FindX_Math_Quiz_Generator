package com.hetpatel.findx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main extends Activity {

    private AdView adView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        adView = (AdView) findViewById(R.id.BannerAd1_3);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void main_play_button(View view){
        Intent play = new Intent(this, Play.class);
        startActivity(play);
    }

    public void main_settings_button(View view){
        Intent settings = new Intent(this, Settings.class);
        startActivity(settings);
    }

    public void main_about_button(View view){
        Intent about = new Intent(this, About.class);
        startActivity(about);
    }

    public void main_score_button(View view){
        Intent score = new Intent(this, Gameover.class);
        startActivity(score);
    }
}
