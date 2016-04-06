package com.hetpatel.findx;

import android.util.Log;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.lang.Math;

//algebra1//eg- 12x=24         //algebra1.2//eg- 24=12x
//algebra2//eg- 12x+14x=96     //algebra2.2//eg- 14x=96-12x     //algebra2.3//eg- 96=12x+14x     //algebra2.4//eg- 12x+14x-96=0
//algebra3//eg- 248x-124x=96   //algebra3.2//eg- 248x=96+124x   //algebra3.3//eg- 96=248x-124x   //algebra3.4//eg- 248x-124x-96=0

//algebra4//eg- 2(2x+4)=96
//algebra5//eg- 2(6x-4)=96
//algebra6//eg- 2x^2-4x+2=0
//algebra7//eg- 2x^2+4x+2=0
//algebra8//eg- 2(2x+3x)=120
//algebra9//eg- 2(4x-2x)=8

public class Maths {//all answers must be 2 or greater

    private Random random = new Random();

    public ArrayList<Integer> getGeometry_1(){//que: find height/base/area/sides/perimeter (NOTE: its an iscoscelus triangle)
        ArrayList<Integer> geometry = new ArrayList<Integer>();
        geometry.add(0);//b
        geometry.add(1);//h
        geometry.add(2);//area
        geometry.add(3);//peri //////<<<<<<<<<
        geometry.add(4);//side
        int base=random.nextInt(20)+2;
        int height=random.nextInt(20)+2;
        while(base%2!=0){
            base=random.nextInt(20)+2;
        }
        while(height%2!=0){
            height=random.nextInt(20)+2;
        }
        int area=(base*height)/2;
        int peri = (int)(base+((Math.sqrt((height*height)+((base/2)*(base/2)))*2)));
        int side = (int) Math.sqrt((height * height) + ((base / 2) * (base / 2)));
        geometry.set(0,base);
        geometry.set(1,height);
        geometry.set(2,area);
        geometry.set(3,peri);
        geometry.set(4,side);
        return geometry;
    }

    public ArrayList<Integer> getGeometry_2(){//que: find area/sides/perimeter  //rectangle
        ArrayList<Integer> geometry = new ArrayList<Integer>();
        geometry.add(0);//b
        geometry.add(1);//h
        geometry.add(2);//area
        geometry.add(3);//perimeter
        geometry.add(4);//diagonal
        int base=random.nextInt(20)+2;
        int height=random.nextInt(20)+2;
        int area=base*height;
        int peri=base+base+height+height;
        int diag= (int) Math.sqrt(base*base+height*height);
        geometry.set(0,base);
        geometry.set(1,height);
        geometry.set(2,area);
        geometry.set(3,peri);
        geometry.set(4,diag);
        return geometry;
    }

    public ArrayList<Integer> getGeometry_3(){//PI 1 - circle
        ArrayList<Integer> geometry = new ArrayList<Integer>();
        geometry.add(0);//area
        geometry.add(1);//circ
        geometry.add(2);//raddi
        int raddi=random.nextInt(20)+2;
        int area = (int) (3.14*raddi*raddi);
        int circ = (int) (2*3.14*raddi);
        geometry.set(0,area);
        geometry.set(1,circ);
        geometry.set(2,raddi);
        return geometry;
    }

    ///////////////

    public ArrayList<Integer> getArithmetic_1(){//a+b=c
        ArrayList<Integer> arithmetic = new ArrayList<Integer>();
        arithmetic.add(0);
        arithmetic.add(1);
        arithmetic.add(2);
        int a=random.nextInt(256)+2;
        int b=random.nextInt(256)+2;
        arithmetic.set(0,a);
        arithmetic.set(1,b);
        arithmetic.set(2,a+b);
        return arithmetic;
    }

    public ArrayList<Integer> getArithmetic_2(){//a-b=c
        ArrayList<Integer> arithmetic = new ArrayList<Integer>();
        arithmetic.add(0);
        arithmetic.add(1);
        arithmetic.add(2);
        int a=random.nextInt(256)+2;
        int b=random.nextInt(256)+2;
        while(a<=b){
            a=random.nextInt(256)+2;
            b=random.nextInt(256)+2;
        }
        arithmetic.set(0,a);
        arithmetic.set(1,b);
        arithmetic.set(2,a-b);
        return arithmetic;
    }

    public ArrayList<Integer> getArithmetic_3(){//a*b=c
        ArrayList<Integer> arithmetic = new ArrayList<Integer>();
        arithmetic.add(0);
        arithmetic.add(1);
        arithmetic.add(2);
        int a=random.nextInt(20)+2;
        int b=random.nextInt(20)+2;
        arithmetic.set(0,a);
        arithmetic.set(1,b);
        arithmetic.set(2,a*b);
        return arithmetic;
    }

    public ArrayList<Integer> getArithmetic_4(){//a/b=c
        ArrayList<Integer> arithmetic = new ArrayList<Integer>();
        arithmetic.add(0);
        arithmetic.add(1);
        arithmetic.add(2);
        int a=random.nextInt(128)+2;
        int b=random.nextInt(128)+2;
        while(a%b!=0){
            a=random.nextInt(128)+2;
            b=random.nextInt(128)+2;
        }
        arithmetic.set(0,a);
        arithmetic.set(1,b);
        arithmetic.set(2,a/b);
        return arithmetic;
    }

    public ArrayList<Integer> getArithmetic_5(){//a/b+q/p=c
        ArrayList<Integer> arithmetic = new ArrayList<Integer>();
        arithmetic.add(0);
        arithmetic.add(1);
        arithmetic.add(2);
        arithmetic.add(3);
        arithmetic.add(4);
        int a=random.nextInt(128)+2;
        int b=random.nextInt(128)+2;
        int q=random.nextInt(128)+2;
        int p=random.nextInt(128)+2;
        while(a%b!=0){
            a=random.nextInt(128)+2;
            b=random.nextInt(128)+2;
        }
        while(p%q!=0){
            p=random.nextInt(128)+2;
            q=random.nextInt(128)+2;
        }
        arithmetic.set(0,a);
        arithmetic.set(1,b);
        arithmetic.set(2,p);
        arithmetic.set(3,q);
        arithmetic.set(4,a/b+p/q);
        return arithmetic;
    }

    public ArrayList<Integer> getArithmetic_6(){//a/b-q/p=c
        return null;
    }

    public ArrayList<Integer> getAlgebra_1(){//2x=8
        ArrayList<Integer> algebra = new ArrayList<Integer>();
        algebra.add(0);//2
        algebra.add(1);//8
        algebra.add(2);//x=4

        int a=random.nextInt(128)+2;//2-64
        int b=random.nextInt(128)+2;//2-64

        while(b%a!=0){
            a=random.nextInt(128)+2;//2-64
            b=random.nextInt(128)+2;//2-64
            while(b<=a){
                a=random.nextInt(128)+2;//2-64
                b=random.nextInt(128)+2;//2-64
            }
        }

        algebra.set(0, a);
        algebra.set(1, b);
        algebra.set(2, b/a);

        return algebra;
    }

    public ArrayList<Integer> getAlgebra_2(){//2x+3x=15
        ArrayList<Integer> algebra = new ArrayList<Integer>();
        algebra.add(0);//2
        algebra.add(1);//3
        algebra.add(2);//15
        algebra.add(3);//x=3

        int a=random.nextInt(64)+2;//2-64
        int b=random.nextInt(64)+2;//2-64
        int c=random.nextInt(128)+2;//2-128

        while(c%(a+b)!=0){
            a=random.nextInt(64)+2;//2-64
            b=random.nextInt(64)+2;//2-64
            c=random.nextInt(128)+2;//2-128
            while(c<=(a+b)){
                a=random.nextInt(64)+2;//2-64
                b=random.nextInt(64)+2;//2-64
                c=random.nextInt(128)+2;//2-128
            }
        }

        algebra.set(0, a);
        algebra.set(1, b);
        algebra.set(2, c);
        algebra.set(3, c/(a+b));

        return algebra;
    }

    public ArrayList<Integer> getAlgebra_3(){//8x-3x=15
        ArrayList<Integer> algebra = new ArrayList<Integer>();
        algebra.add(0);//8
        algebra.add(1);//3
        algebra.add(2);//15
        algebra.add(3);//x=3

        int a=random.nextInt(64)+2;//2-64
        int b=random.nextInt(64)+2;//2-64
        int c=random.nextInt(128)+2;//2-128

        try{
            while(c%(a-b)!=0){
                a=random.nextInt(64)+2;//2-64
                b=random.nextInt(64)+2;//2-64
                c=random.nextInt(128)+2;//2-128
                while(c<=(a-b)){
                    a=random.nextInt(64)+2;//2-64
                    b=random.nextInt(64)+2;//2-64
                    c=random.nextInt(128)+2;//2-128
                }
            }
        }catch (ArithmeticException ae){
            Log.d("ERROR", ae.getMessage());
            int zx = random.nextInt(10);
            switch(zx){
                case 0:
                    a=20;
                    b=15;
                    c=115;
                    break;
                case 1:
                    a=10;
                    b=8;
                    c=124;
                    break;
                case 2:
                    a=56;
                    b=49;
                    c=21;
                    break;
                case 3:
                    a=57;
                    b=43;
                    c=126;
                    break;
                case 4:
                    a=25;
                    b=18;
                    c=119;
                    break;
                case 5:
                    a=19;
                    b=13;
                    c=114;
                    break;
                case 6:
                    a=26;
                    b=23;
                    c=72;
                    break;
                case 7:
                    a=25;
                    b=20;
                    c=40;
                    break;
                case 8:
                    a=58;
                    b=51;
                    c=63;
                    break;
                case 9:
                    a=47;
                    b=36;
                    c=22;
                    break;
            }
        }

        if(a-b<0){
            int as=a;
            a=b;
            b=as;
        }

        algebra.set(0, a);
        algebra.set(1, b);
        algebra.set(2, c);
        algebra.set(3, c/(a-b));

        return algebra;
    }

    public ArrayList<Integer> getMCQs(int ans){//this provides with both mcqs(show) and the answer(dont show)
        ArrayList<Integer> MCQs = new ArrayList<Integer>();
        MCQs.add(0);//mcq 1
        MCQs.add(1);//mcq 2
        MCQs.add(2);//mcq 3
        MCQs.add(3);//mcq 4
        MCQs.add(4);//answer

        int xrand = random.nextInt(4);
        MCQs.set(xrand, ans);
        for(int i=0; i<=3; i++){
            if(i!=xrand){
                int x = random.nextInt(2)+1;
                if(x==1){
                    int n = random.nextInt(10)+1;//1-10
                    int m = ans+n;
                    while(m==ans){
                        int asd = random.nextInt(10)+1;//1-10
                        m = ans+asd;
                    }
                    MCQs.set(i, m);
                }else if(x==2){
                    int n = random.nextInt(10)+1;//1-10
                    int m = ans-n;
                    if(m<1 && m!=0){
                        m=-m;
                        while(m==ans){
                            int asdf = random.nextInt(5)+2;
                            m=asdf;
                        }
                    }
                    if(m==0 || m==1){
                        int asd = random.nextInt(5)+2;
                        m=asd;
                        while(m==ans){
                            int asdf = random.nextInt(5)+2;
                            m=asdf;
                        }
                    }
                    MCQs.set(i, m);
                }
            }
        }
        MCQs.set(4,ans);
        return MCQs;
    }

}
