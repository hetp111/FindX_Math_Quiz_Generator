package com.hetpatel.findx;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Settings extends Activity {

    private AdView adView;
    private AdRequest adRequest;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        adView = (AdView) findViewById(R.id.BannerAd1_6);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        button = (Button) findViewById(R.id.settings_timer);

        SharedPreferences sharedPreferences = getSharedPreferences("timer", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String s = sharedPreferences.getString("timer","");
        if(s.equals("on")){
            button.setText("Relax Mode is OFF");
        }else if(s.equals("off")){
            button.setText("Relax Mode is ON");
        }else if(s.equals("")){
            editor.putString("timer","on");
            editor.commit();
            button.setText("Relax Mode is OFF");
        }

    }

    public void onoff(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("timer", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.getString("timer","").equals("on")){
            editor.putString("timer","off");
            editor.commit();
            button.setText("Relax Mode is ON");
        }else if(sharedPreferences.getString("timer","").equals("off")){
            editor.putString("timer","on");
            editor.commit();
            button.setText("Relax Mode is OFF");
        }
    }

}
