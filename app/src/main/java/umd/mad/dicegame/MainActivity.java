package umd.mad.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_DICE = 2;
    private GameDie[] dice = new GameDie[MAX_DICE];
    private int[] viewIDs = {
            R.id.score2,
            R.id.score1
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init() {
        for (int i = 0; i < MAX_DICE; i++) {
            dice[i] = new GameDie();
        }
    }

    public void quit(View view) {
        finish();
        System.exit(0);
    }

    public void play(View view) {
        setContentView(R.layout.activity_main2);
        init();
    }

    public void roll(View view) {
        roll();
    }

    private void preRoll(int number) {
        try {
            for (int i = 0; i < number; i++) {
                roll();
                Thread.sleep(200);
            }
        }
        catch (Exception e) {
            Log.e("EXCEPTION", e.getMessage());
        }
    }

    private void roll() {
        TextView textView;

        for (int i = 0; i < MAX_DICE; i++) {
            textView = findViewById(viewIDs[i]);
            textView.setText(dice[i].roll().toString());
        }
    }

    public void hold(View view) {

    }
}
