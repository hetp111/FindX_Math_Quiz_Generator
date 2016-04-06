package com.hetpatel.findx;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class About extends Activity {

    private AdView adView;
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        adView = (AdView) findViewById(R.id.BannerAd1_1);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
