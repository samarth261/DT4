package com.samarth261.dt4;

import android.animation.ObjectAnimator;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {
    int a[];
    int asd;
    Typeface tt;
    TypedArray audioAlpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        tt=Typeface.createFromAsset(getAssets(),"Bevan.ttf");
        audioAlpha=(getResources()).obtainTypedArray(R.array.alpha_aud);
    }

    public void thismeth(View view) {
        String str=(((EditText)findViewById(R.id.tv)).getText()).toString();
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        ll.removeAllViews();
        int i;
        a=new int[str.length()];
        for(i=0;i<str.length();i++)
        {
            TextView txt=new TextView(this);
            txt.setTypeface(tt);
            txt.setText(Character.toString(str.charAt(i)));
            txt.setTextSize(25);
            txt.setTextColor(0xff000000);
            txt.setId(View.generateViewId());
            a[i]=txt.getId();
            ViewGroup.LayoutParams params1=new ViewGroup.LayoutParams(-2,-2);
            //LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(-2,-2);
            //params2.
            ll.addView(txt);
        }

        animationmeth(str.length(),0);
    }

    public void animationmeth(final int n,int start)
    {
        final int i=start;
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView txt=(TextView)findViewById(a[i]);
                //txt.setTextSize(25);
                int temp;
                char temptemp;
                temp=((txt.getText()).charAt(0));
                //temptemp=(char)temp;
                int tempn=temp;
                //Toast.makeText(getApplicationContext(),Integer.toString(temp),Toast.LENGTH_LONG).show();
                temp=audioAlpha.getResourceId(temp-65,-1);
                //Toast.makeText(getApplicationContext(),Integer.toString(temp),Toast.LENGTH_LONG).show();
                //temp=R.raw.auda;
                //if (temp==-1)
                //    temp=R.raw.audb;
                if(tempn>=65&&tempn<=90) {
                    final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), temp);
                    Handler nh = new Handler();
                    //if(temp>=0&&temp<=25)
                    nh.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mp.start();
                        }
                    }, 300);
                }
                //mp.start();
                ObjectAnimator obj1=ObjectAnimator.ofFloat(txt,"textSize",200);
                obj1.setDuration(1500);
                obj1.setInterpolator(new myanim());
                obj1.start();
                if(i<n-1)
                animationmeth(n,i+1);
            }
        },(i==0)?0:1700);
    }
}
