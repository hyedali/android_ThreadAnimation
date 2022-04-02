package com.example.threadanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler();
    ImageView imageView;

    ArrayList<Drawable> image = new ArrayList<Drawable>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        image.add(res.getDrawable(R.drawable.face1));
        image.add(res.getDrawable(R.drawable.face2));
        image.add(res.getDrawable(R.drawable.face3));
        image.add(res.getDrawable(R.drawable.face4));
        image.add(res.getDrawable(R.drawable.face5));

        imageView = findViewById(R.id.image);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animThread animThread = new animThread();
                animThread.start();
            }
        });

    }

    class animThread extends Thread{
        @Override
        public void run() {
            super.run();

            for(int i=0; i<100; i++){
                final Drawable drawable = image.get(i%5);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageDrawable(drawable);
                    }
                });
                try {
                    Thread.sleep(1000);

                }catch (Exception e){}
            }


        }
    }
}