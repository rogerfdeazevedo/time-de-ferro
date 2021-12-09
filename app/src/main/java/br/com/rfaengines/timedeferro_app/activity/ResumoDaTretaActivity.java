package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class ResumoDaTretaActivity extends AppCompatActivity {

    private Button btn_heroiDoDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_da_treta);
        getSupportActionBar().hide();

        btn_heroiDoDia = findViewById(R.id.btn_heroiDoDia);

        btn_heroiDoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResumoDaTretaActivity.this, HeroiDoDiaActivity.class);
                startActivity(intent);
            }
        });

    }
}