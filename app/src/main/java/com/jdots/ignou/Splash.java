package com.jdots.ignou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.Toast;

import com.victor.loading.book.BookLoading;
import com.victor.loading.newton.NewtonCradleLoading;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
try {
    BookLoading bookAnim = findViewById(R.id.bookAnimation);
    NewtonCradleLoading newtonCradleLoading = findViewById(R.id.newton_cradle_loading);
    newtonCradleLoading.setLoadingColor(Color.parseColor("#ff0000"));
    //newtonCradleLoading.setVisibility(View.GONE);
    bookAnim.start();
    newtonCradleLoading.start();

        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {

                jmp();
            }}.start();
}catch(Exception e){
    jmp();
    // Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
}
/*
        try {
            VideoView videoHolder = (VideoView) findViewById(R.id.videoView);

            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
            videoHolder.setVideoURI(video);
        videoHolder.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
               errorjump();
                return true;
            }
        });

            videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            videoHolder.start();
        } catch (Exception ex) {
            jump();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump();
        return true;
    }


    private void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, Main.class));
        finish();
    }
    */

    }
    public void jmp() {

        try {
            startActivity(new Intent(this, Main.class));
            finish();
        }catch(Exception e){
            Toast.makeText(this,"This application is not supported on this device", Toast.LENGTH_LONG).show();
        }
    }
}
