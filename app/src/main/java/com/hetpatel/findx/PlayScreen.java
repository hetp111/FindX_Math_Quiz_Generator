package com.hetpatel.findx;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Random;

public class PlayScreen extends Activity {

    private Random random = new Random();
    private Maths maths = new Maths();
    private TextView questionTxt;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private String gameType;
    private TextView highestScore;
    private TextView currentScore;
    private ArrayList<Integer> MCQs = new ArrayList<Integer>();
    private ProgressBar progressBar;
    private BgTask bgTask=null;
    private int points=0;
    private Context ctx=this;
    private AdView adView;
    private AdRequest adRequest;

    private boolean timerBoo=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);

        SharedPreferences TIMER = getSharedPreferences("timer", Context.MODE_PRIVATE);
        String timer = TIMER.getString("timer","");
        timerBoo = timer.equals("off");

        adView = (AdView) findViewById(R.id.BannerAd1_5);
        adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        questionTxt = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        highestScore = (TextView) findViewById(R.id.highestScore);
        currentScore = (TextView) findViewById(R.id.currentScore);

        checkifnullthensetto0();

        Intent intent = getIntent();
        gameType = intent.getStringExtra("type");

        if(timerBoo==true){
            progressBar.setVisibility(View.INVISIBLE);
            highestScore.setVisibility(View.INVISIBLE);
            currentScore.setVisibility(View.INVISIBLE);
        }

        Gotorandomortype();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(bgTask!=null){
                bgTask.cancel(true);
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        if(bgTask!=null){
            bgTask.cancel(true);
        }
        finish();
        super.onPause();
    }

    @Override
    protected void onStop() {
        if(bgTask!=null){
            bgTask.cancel(true);
        }
        finish();
        super.onStop();
    }

    //////////

    public void arithmetic(){
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        checkifnullthensetto0();
        currentScore.setText("Current Score: "+points);
        if(gameType.equals("random")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("randomScore",""));
        }else if(gameType.equals("arithmetic")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("arithmeticScore",""));
        }

        int r=random.nextInt(4)+1;
        if(r==1){
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(8);
            }

            ArrayList<Integer> arithmetic_1 = new ArrayList<Integer>();
            arithmetic_1 = maths.getArithmetic_1();
            MCQs = maths.getMCQs(arithmetic_1.get(2));
            questionTxt.setText(arithmetic_1.get(0)+" + "+arithmetic_1.get(1)+" = x");
            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==2){
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(8);
            }

            ArrayList<Integer> arithmetic_2 = new ArrayList<Integer>();
            arithmetic_2 = maths.getArithmetic_2();
            MCQs = maths.getMCQs(arithmetic_2.get(2));
            questionTxt.setText(arithmetic_2.get(0)+" - "+arithmetic_2.get(1)+" = x");
            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==3){
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(11);
            }

            ArrayList<Integer> arithmetic_3 = new ArrayList<Integer>();
            arithmetic_3 = maths.getArithmetic_3();
            MCQs = maths.getMCQs(arithmetic_3.get(2));
            questionTxt.setText(arithmetic_3.get(0)+" \u00D7 "+arithmetic_3.get(1)+" = x");
            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==4){
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(6);
            }

            ArrayList<Integer> arithmetic_4 = new ArrayList<Integer>();
            arithmetic_4 = maths.getArithmetic_4();
            MCQs = maths.getMCQs(arithmetic_4.get(2));
            questionTxt.setText(arithmetic_4.get(0)+" \u00F7 "+arithmetic_4.get(1)+" = x");
            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }
    }

    public void algebra(){
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        checkifnullthensetto0();
        currentScore.setText("Current Score: "+points);
        if(gameType.equals("random")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("randomScore",""));
        }else if(gameType.equals("algebra")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("algebraScore",""));
        }

        int r=random.nextInt(3)+1;
        if(r==1){//2x=8 ie algebra_1
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(5);
            }

            ArrayList<Integer> algebra_1 = new ArrayList<Integer>();
            algebra_1 = maths.getAlgebra_1();
            MCQs = maths.getMCQs(algebra_1.get(2));

            int xc=random.nextInt(2)+1;
            if(xc==1){
                questionTxt.setText(algebra_1.get(0)+"x = "+algebra_1.get(1));//0x=1
            }else if(xc==2){
                questionTxt.setText(algebra_1.get(0)+"x - "+algebra_1.get(1)+" = 0");//0x-1=0
            }

            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==2){//2x+2x=8
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(9);
            }

            ArrayList<Integer> algebra_2 = new ArrayList<Integer>();
            algebra_2 = maths.getAlgebra_2();
            MCQs = maths.getMCQs(algebra_2.get(3));

            int xc=random.nextInt(9)+1;
            if(xc==1){
                questionTxt.setText(algebra_2.get(0)+"x + "+algebra_2.get(1)+"x = "+algebra_2.get(2));//0x+1x=2 ok
            }else if(xc==2){
                questionTxt.setText(algebra_2.get(0)+"x = "+algebra_2.get(2)+" - "+algebra_2.get(1)+"x");//0x=2-1x ok
            }else if(xc==3){
                questionTxt.setText(algebra_2.get(0)+"x = - "+algebra_2.get(1)+"x + "+algebra_2.get(2));//0x=-1x+2 ok
            }else if(xc==4){
                questionTxt.setText(algebra_2.get(1)+"x = - "+algebra_2.get(0)+"x + "+algebra_2.get(2));//1x=-0x+2 ok
            }else if(xc==5){
                questionTxt.setText(algebra_2.get(1)+"x = "+algebra_2.get(2)+" - "+algebra_2.get(0)+"x");//1x=2-0x ok
            }else if(xc==6){
                questionTxt.setText(" - "+algebra_2.get(2)+" = - "+algebra_2.get(0)+"x - "+algebra_2.get(1)+"x");//-2=-0x-1x ok
            }else if(xc==7){
                questionTxt.setText(" - "+algebra_2.get(2)+" = - "+algebra_2.get(1)+"x - "+algebra_2.get(0)+"x");//-2=-1x-0x ok
            }else if(xc==8){
                questionTxt.setText(algebra_2.get(0)+"x + "+algebra_2.get(1)+"x - "+algebra_2.get(2)+" = 0");//0x+1x-2=0 ok
            }else if(xc==9){
                questionTxt.setText(algebra_2.get(0)+"x - "+algebra_2.get(2)+" + "+algebra_2.get(1)+"x = 0");//0x-2+1x=0 ok
            }

            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==3){//4x-2x=8
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(9);
            }

            ArrayList<Integer> algebra_3 = new ArrayList<Integer>();
            algebra_3 = maths.getAlgebra_3();
            MCQs = maths.getMCQs(algebra_3.get(3));

            int xc=random.nextInt(9)+1;
            if(xc==1){
                questionTxt.setText(algebra_3.get(0)+"x - "+algebra_3.get(1)+"x = "+algebra_3.get(2));//0x-1x=2 ok
            }else if(xc==2){
                questionTxt.setText(algebra_3.get(0)+"x = "+algebra_3.get(2)+" + "+algebra_3.get(1)+"x");//0x=2+1x ok
            }else if(xc==3){
                questionTxt.setText(algebra_3.get(0)+"x = "+algebra_3.get(1)+"x + "+algebra_3.get(2));//0x=1x+2 ok
            }else if(xc==4){
                questionTxt.setText(" - "+algebra_3.get(1)+"x = - "+algebra_3.get(0)+"x + "+algebra_3.get(2));//-1x=-0x+2 ok
            }else if(xc==5){
                questionTxt.setText(" - "+algebra_3.get(1)+"x = "+algebra_3.get(2)+" - "+algebra_3.get(0)+"x");//-1x=2-0x ok
            }else if(xc==6){
                questionTxt.setText(" - "+algebra_3.get(2)+" = - "+algebra_3.get(0)+"x + "+algebra_3.get(1)+"x");//-2=-0x+1x ok
            }else if(xc==7){
                questionTxt.setText(" - "+algebra_3.get(2)+" = "+algebra_3.get(1)+"x - "+algebra_3.get(0)+"x");//-2=1x-0x ok
            }else if(xc==8){
                questionTxt.setText(algebra_3.get(0)+"x - "+algebra_3.get(1)+"x - "+algebra_3.get(2)+" = 0");//0x-1x-2=0 ok
            }else if(xc==9){
                questionTxt.setText(algebra_3.get(0)+"x - "+algebra_3.get(2)+" - "+algebra_3.get(1)+"x = 0");//0x-2-1x=0 ok
            }

            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }
    }

    public void geometry(){
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        checkifnullthensetto0();
        currentScore.setText("Current Score: " + points);
        if(gameType.equals("random")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("randomScore",""));
        }else if(gameType.equals("geometry")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("geometryScore",""));
        }

        int r=random.nextInt(13)+1;
        if(r==1){//tri- find area with base and height
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(12);
            }
            ArrayList<Integer> geometry_1 = new ArrayList<Integer>();
            geometry_1 = maths.getGeometry_1();
            MCQs = maths.getMCQs(geometry_1.get(2));
            questionTxt.setText("Base and Height of a triangle is "+geometry_1.get(0)+" and "+geometry_1.get(1)+" then it's Area will be:");
            button.setText(MCQs.get(0).toString());
            button2.setText(MCQs.get(1).toString());
            button3.setText(MCQs.get(2).toString());
            button4.setText(MCQs.get(3).toString());
        }else if(r==2){//tri- find peri from b and h
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(40);
            }
            ArrayList<Integer> geometry_2 = new ArrayList<Integer>();
            geometry_2 = maths.getGeometry_1();
            MCQs = maths.getMCQs(geometry_2.get(3));
            questionTxt.setText("Base and Height of an isosceles triangle is "+geometry_2.get(0) + " and " + geometry_2.get(1)+" then it's Perimeter will be approximately:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==3){//tri - find height from area
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(20);
            }
            ArrayList<Integer> geometry_3 = new ArrayList<Integer>();
            geometry_3 = maths.getGeometry_1();
            MCQs = maths.getMCQs(geometry_3.get(1));
            questionTxt.setText("Area and the Base of a triangle is "+geometry_3.get(2)+" and "+geometry_3.get(0)+" then it's Height will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==4){//tri - find base from area
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(20);
            }
            ArrayList<Integer> geometry_4 = new ArrayList<Integer>();
            geometry_4 = maths.getGeometry_1();
            MCQs = maths.getMCQs(geometry_4.get(0));
            questionTxt.setText("Area and Height of a triangle is "+geometry_4.get(2)+" and "+geometry_4.get(1)+" then it's Base will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==5){
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_5 = new ArrayList<Integer>();
            geometry_5 = maths.getGeometry_1();
            MCQs = maths.getMCQs(geometry_5.get(4));
            questionTxt.setText("Height and Base of an isosceles triangle is "+geometry_5.get(1)+" and "+geometry_5.get(0)+" then one of it's side will be approximately:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==6){/////////area of rect
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(10);
            }
            ArrayList<Integer> geometry_6 = new ArrayList<Integer>();
            geometry_6 = maths.getGeometry_2();
            MCQs = maths.getMCQs(geometry_6.get(2));
            questionTxt.setText("Length and Breadth of a rectangle is "+geometry_6.get(1)+" and "+geometry_6.get(0)+" then it's area will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==7){/////////area of rect is x b is l find b
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(12);
            }
            ArrayList<Integer> geometry_7 = new ArrayList<Integer>();
            geometry_7 = maths.getGeometry_2();
            MCQs = maths.getMCQs(geometry_7.get(0));
            questionTxt.setText("Area and a side of a rectangle is "+geometry_7.get(2)+" and "+geometry_7.get(1)+" then it's other side will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==8){//circ area
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_8 = new ArrayList<Integer>();
            geometry_8 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_8.get(0));
            questionTxt.setText("Radius of a circle is "+geometry_8.get(2)+" then it's approximate area will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==9){//circ area r2
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_9 = new ArrayList<Integer>();
            geometry_9 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_9.get(0));
            questionTxt.setText("Diameter of a circle is "+geometry_9.get(2)*2+" then it's approximate area will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==10){//circ circ
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_10 = new ArrayList<Integer>();
            geometry_10 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_10.get(1));
            questionTxt.setText("Radius of a circle is "+geometry_10.get(2)+" then it's approximate circumference will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==11){//circ circ r2
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_11 = new ArrayList<Integer>();
            geometry_11 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_11.get(1));
            questionTxt.setText("Diameter of a circle is "+geometry_11.get(2)*2+" then it's approximate circumference will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==12){//radii circ r2
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_12 = new ArrayList<Integer>();
            geometry_12 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_12.get(2));
            questionTxt.setText("Area of a circle is "+geometry_12.get(0)+" then it's approximate radius will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }else if(r==13){//radii circ r2
            if(!timerBoo){
                bgTask = new BgTask();
                bgTask.execute(24);
            }
            ArrayList<Integer> geometry_13 = new ArrayList<Integer>();
            geometry_13 = maths.getGeometry_3();
            MCQs = maths.getMCQs(geometry_13.get(2));
            questionTxt.setText("Circumference of a circle is "+geometry_13.get(1)+" then it's approximate radius will be:");
            button.setText(""+MCQs.get(0).toString());
            button2.setText(""+MCQs.get(1).toString());
            button3.setText(""+MCQs.get(2).toString());
            button4.setText(""+MCQs.get(3).toString());
        }
    }

    //////////

    public void button(View view){
        checkifnullthensetto0();
        if(button.getText().toString().equals(MCQs.get(4).toString())){
            progressBar.setProgress(0);
            if(bgTask!=null){
                bgTask.cancel(true);
            }
            points(true);
            Log.d("FINDX", "Points++" + points);
            Gotorandomortype();
        }else if(!button.getText().toString().equals(MCQs.get(4).toString())){
            //gameover/showhighscore
            points(false);
            Log.d("FINDX", "points--" + points);
            if(points<0){
                Log.d("FINDX", "Gameover" + points);
                Intent i = new Intent(this, Gameover.class);
                startActivity(i);
            }
            saveDataPrefs();
        }
    }

    public void button2(View view){
        checkifnullthensetto0();
        if(button2.getText().toString().equals(MCQs.get(4).toString())){
            progressBar.setProgress(0);
            if(bgTask!=null){
                bgTask.cancel(true);
            }
            points(true);
            Log.d("FINDX", "Points++" + points);
            Gotorandomortype();
        }else if(!button2.getText().toString().equals(MCQs.get(4).toString())){
            //gameover/showhighscore
            points(false);
            Log.d("FINDX", "points--" + points);
            if(points<0){
                Log.d("FINDX", "Gameover" + points);
                Intent i = new Intent(this, Gameover.class);
                startActivity(i);
            }
            saveDataPrefs();
        }
    }

    public void button3(View view){
        checkifnullthensetto0();
        if(button3.getText().toString().equals(MCQs.get(4).toString())){
            progressBar.setProgress(0);
            if(bgTask!=null){
                bgTask.cancel(true);
            }
            points(true);
            Log.d("FINDX", "Points++" + points);
            Gotorandomortype();
        }else if(!button3.getText().toString().equals(MCQs.get(4).toString())){
            //gameover/showhighscore
            points(false);
            Log.d("FINDX", "points--" + points);
            if(points<0){
                Log.d("FINDX", "Gameover" + points);
                Intent i = new Intent(this, Gameover.class);
                startActivity(i);
            }
            saveDataPrefs();
        }
    }

    public void button4(View view){
        checkifnullthensetto0();
        if (button4.getText().toString().equals(MCQs.get(4).toString())){
            progressBar.setProgress(0);
            if(bgTask!=null){
                bgTask.cancel(true);
            }
            points(true);
            Log.d("FINDX", "Points++" + points);
            Gotorandomortype();
        }else if(!button4.getText().toString().equals(MCQs.get(4).toString())){
            //gameover/showhighscore
            points(false);
            Log.d("FINDX", "points--" + points);
            if(points<0){
                Log.d("FINDX", "Gameover" + points);
                Intent i = new Intent(this, Gameover.class);
                startActivity(i);
            }
            saveDataPrefs();
        }
    }

    public void checkifnullthensetto0(){
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getString("randomScore", "").equals("")){
            editor.putString("randomScore", 0 + "");
            editor.commit();
        }else if(sharedPreferences.getString("arithmeticScore","").equals("")){
            editor.putString("arithmeticScore",0+"");
            editor.commit();
        }else if(sharedPreferences.getString("algebraScore","").equals("")){
            editor.putString("algebraScore",0+"");
            editor.commit();
        }else if(sharedPreferences.getString("geometryScore","").equals("")){
            editor.putString("geometryScore",0+"");
            editor.commit();
        }
    }

    public void points(Boolean plusplus){
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getString("randomScore","").equals("")){
            editor.putString("randomScore",0+"");
            editor.commit();
        }else if(sharedPreferences.getString("arithmeticScore","").equals("")){
            editor.putString("arithmeticScore",0+"");
            editor.commit();
        }else if(sharedPreferences.getString("algebraScore","").equals("")){
            editor.putString("algebraScore",0+"");
            editor.commit();
        }else if(sharedPreferences.getString("geometryScore","").equals("")){
            editor.putString("geometryScore",0+"");
            editor.commit();
        }

        if(plusplus==true && !timerBoo) {
            points++;
            int randomX=Integer.parseInt(sharedPreferences.getString("randomScore",""));
            int arithmeticX=Integer.parseInt(sharedPreferences.getString("arithmeticScore",""));
            int algebraX=Integer.parseInt(sharedPreferences.getString("algebraScore",""));
            int geometryX=Integer.parseInt(sharedPreferences.getString("geometryScore",""));
            if(gameType.equals("random") && randomX<=points){
                editor.putString("randomScore", points+"");
                editor.commit();
            }else if(gameType.equals("arithmetic") && arithmeticX<=points){
                editor.putString("arithmeticScore", points+"");
                editor.commit();
            }else if(gameType.equals("algebra") && algebraX<=points){
                editor.putString("algebraScore", points+"");
                editor.commit();
            }else if(gameType.equals("geometry") && geometryX<=points) {
                editor.putString("geometryScore", points+"");
                editor.commit();
            }
        }else if(plusplus==false && !timerBoo){
            points--;
            int randomX=Integer.parseInt(sharedPreferences.getString("randomScore",""));
            int arithmeticX=Integer.parseInt(sharedPreferences.getString("arithmeticScore",""));
            int algebraX=Integer.parseInt(sharedPreferences.getString("algebraScore",""));
            int geometryX=Integer.parseInt(sharedPreferences.getString("geometryScore",""));
            if(gameType.equals("random") && randomX<=points){
                editor.putString("randomScore", points+"");
                editor.commit();
            }else if(gameType.equals("arithmetic") && arithmeticX<=points){
                editor.putString("arithmeticScore", points+"");
                editor.commit();
            }else if(gameType.equals("algebra") && algebraX<=points){
                editor.putString("algebraScore", points+"");
                editor.commit();
            }else if(gameType.equals("geometry") && geometryX<=points) {
                editor.putString("geometryScore", points+"");
                editor.commit();
            }
        }
    }

    public class BgTask extends AsyncTask<Integer, Integer, Integer>{

        @Override
        protected Integer doInBackground(Integer... params) {
            int time=params[0];

            for(int a=1; a<=time; a++){
                publishProgress(time);
                try {
                    if(isCancelled()){
                        break;
                    }else{
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setMax(values[0]);
            progressBar.incrementProgressBy(1);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            points--;
            Log.d("FINDX", "points--" + points);
            if(points<0){
                Log.d("FINDX", "Gameover" + points);
                Intent i = new Intent(ctx, Gameover.class);
                startActivity(i);
            }else{
                saveDataPrefs();
                progressBar.setProgress(0);
                //goto random/arithmetic/algebra/geo

                Gotorandomortype();
            }
        }
    }

    public void saveDataPrefs(){
        currentScore.setText("Current Score: "+points);
        SharedPreferences sharedPreferences = getSharedPreferences("scores",Context.MODE_PRIVATE);
        if(gameType.equals("random")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("randomScore",""));
        }else if(gameType.equals("arithmetic")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("arithmeticScore",""));
        }else if(gameType.equals("algebra")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("algebraScore",""));
        }else if(gameType.equals("geometry")){
            highestScore.setText("Highest Score: "+sharedPreferences.getString("geometryScore",""));
        }
    }

    public void Gotorandomortype(){
        if(gameType.equals("random")){
            int r=random.nextInt(3)+1;
            if(r==1){
                arithmetic();
            }else if(r==2){
                algebra();
            }else if(r==3){
                geometry();
            }
        }else if(gameType.equals("arithmetic")){
            arithmetic();
        }else if(gameType.equals("algebra")){
            algebra();
        }else if(gameType.equals("geometry")) {
            geometry();
        }
    }

}