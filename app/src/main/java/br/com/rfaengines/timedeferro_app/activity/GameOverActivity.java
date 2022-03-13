package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                proximaTela();
            }
        }, 10000);

    }

    private void proximaTela() {

        GamePlay gamePlay = GamePlayManager.getGamePlay();

        if(gamePlay.getJogador().isGameOver()){
            Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(GameOverActivity.this, MapaDaCidadeActivity.class);
            startActivity(intent);
        }
        finish();
    }
}