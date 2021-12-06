package br.com.rfaengines.timedeferro_app.activity;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class TutorialActivity extends AppCompatActivity {

    private Button btn_avancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().hide();
        iniciarComponente_btn_avancar();

        btn_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Toast.makeText(TutorialActivity.this, "Ainda não está pronto!", LENGTH_SHORT).show();
            }
        });

    }

    private void iniciarComponente_btn_avancar(){
        btn_avancar = findViewById(R.id.btn_avancar_id);
    }

}