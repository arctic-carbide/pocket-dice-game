package umd.mad.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quit(View view) {
        finish();
        System.exit(0);
    }

    public void play(View view) {
        setContentView(R.layout.activity_main2);
    }

    public void roll(View view) {
        GameDie[] dice = new GameDie[2];

        for (GameDie d : dice) {
            Log.i("ROLL", d.roll().toString());
        }
    }

    public void hold(View view) {

    }
}
