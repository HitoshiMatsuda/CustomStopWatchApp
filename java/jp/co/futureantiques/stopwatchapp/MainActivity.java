package jp.co.futureantiques.stopwatchapp;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean timeRun;
    private long pauseTime;


    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void startTime(View view) {
        if (!timeRun) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseTime);
            chronometer.start();
            timeRun = true;
        }
    }

    public void pauseTime(View view) {
        if (timeRun) {
            chronometer.stop();
            pauseTime = SystemClock.elapsedRealtime() - chronometer.getBase();
            timeRun = false;
        }
    }

    public void resetTime(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseTime = 0;
    }
}
