package com.merlita.examen291124_povill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btColores, btMayor, btCapicua;
    TextView tv;

    ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>()
            {
                @Override
                public void onActivityResult(ActivityResult resultado)
                {
                    //Esto es un intent:
                    Intent i = resultado.getData();
                    assert i != null;
                    tv.setText(i.getStringExtra("NOMBRE"));

                }

            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btColores = findViewById(R.id.btColores);
        btMayor = findViewById(R.id.btMayor);
//        btCapicua = findViewById(R.id.btCapicua);

        btColores.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToColores();
            }
        });

        btMayor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToMayor();
            }
        });
    }

    private void goToMayor() {
        Intent i = new Intent(this, Mayor.class);
        lanzador.launch(i);

    }

    public void goToColores(){
        Intent i = new Intent(this, Colores.class);
        lanzador.launch(i);
    }

}