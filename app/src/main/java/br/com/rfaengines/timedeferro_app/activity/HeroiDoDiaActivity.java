package br.com.rfaengines.timedeferro_app.activity;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class HeroiDoDiaActivity extends AppCompatActivity {

    private Button btn_heroiEsq;

    private Button btn_heroiDir;

    private Button btn_resolvendoAsCoisas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroi_do_dia);
        getSupportActionBar().hide();

        btn_heroiEsq = findViewById(R.id.btn_heroiEsq);
        btn_heroiDir = findViewById(R.id.btn_heroiDir);
        btn_resolvendoAsCoisas = findViewById(R.id.btn_resolvendoAsCoisas);

        btn_heroiEsq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HeroiDoDiaActivity.this, "Mostra o herói da esquerda na lista!", LENGTH_SHORT).show();
            }
        });

        btn_resolvendoAsCoisas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HeroiDoDiaActivity.this, "Avança para o combate!", LENGTH_SHORT).show();
            }
        });

        btn_heroiDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HeroiDoDiaActivity.this, "Mostra o herói da direita na lista!", LENGTH_SHORT).show();
            }
        });

    }
}