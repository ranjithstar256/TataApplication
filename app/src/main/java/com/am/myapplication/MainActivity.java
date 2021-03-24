package com.am.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;

import java.util.Timer;
import java.util.TimerTask;

// this is from Github site

// this is from Android Studio!

public class MainActivity extends AppCompatActivity implements OnProgressBarListener {
    private NumberProgressBar bnp;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnp = (NumberProgressBar)findViewById(R.id.number_progress_bar);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bnp.incrementProgressBy(1);
                    }
                });
            }
        }, 1000, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void es(MenuItem item) {
        Toast.makeText(this,    "hi", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onProgressChange(int current, int max) {
        if(current == max) {
            Toast.makeText(getApplicationContext(), "finish", Toast.LENGTH_SHORT).show();
            bnp.setProgress(0);
        }
    }
}
