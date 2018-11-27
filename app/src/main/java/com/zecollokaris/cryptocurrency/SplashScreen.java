package com.zecollokaris.cryptocurrency;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    @BindView (R.id.imageView2) ImageView mLogo;
    LinearLayout titleimage,titletxt;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        titleimage = (LinearLayout) findViewById(R.id.titleimage);
        titletxt = (LinearLayout) findViewById(R.id.titletxt);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        titleimage.setAnimation(downtoup);
        titletxt.setAnimation(uptodown);



    RotateAnimation rotate = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotate.setDuration(3000);
    rotate.setInterpolator(new LinearInterpolator());
    mLogo.startAnimation(rotate);


    Thread myThread = new Thread(){
        @Override
        public void run(){
            try {
                sleep(4000);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
        myThread.start();

    }


}













