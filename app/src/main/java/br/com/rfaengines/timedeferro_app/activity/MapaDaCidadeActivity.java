package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class MapaDaCidadeActivity extends AppCompatActivity {

    private ImageView imgView_Lvl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_da_cidade);
        getSupportActionBar().hide();

        imgView_Lvl1 = findViewById(R.id.imgView_Lvl1);

        imgView_Lvl1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                Intent intent = new Intent(MapaDaCidadeActivity.this, ResumoDaTretaActivity.class);
                startActivity(intent);
         }
        });
    }

}