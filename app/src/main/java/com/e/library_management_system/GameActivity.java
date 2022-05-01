package com.e.library_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tvScore = (TextView) findViewById(R.id.tvScore);
    }
    private TextView tvScore;

    private static GameActivity gameActivity = null;

    public static GameActivity getGameActivity() {
        return gameActivity;
    }

    public static void setGameActivity(GameActivity gameActivity) {
        GameActivity.gameActivity = gameActivity;
    }

    public GameActivity() {
        gameActivity = this;
    }
    public void clearScore() {
        score = 0;
        showScore();
    }
    public void addScore(int s) {
        score+=s;
        showScore();
    }
    public void showScore() {
        tvScore.setText(score + "");
    }
    private int score = 0;
}
