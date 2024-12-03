package com.merlita.examen291124_povill;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import java.util.ArrayList;

public class Colores extends AppCompatActivity {

    Point p;
    Button b1, b2, b3, b4;
    int anchoPantalla, altoPantalla;
    GridLayout gridLayout;
    TextView tv;

    final int FILAS = 2, COLUMNAS = 2;
    ArrayList<Integer> colores = new ArrayList<>();
    private int[] ids = new int[4];
    private int giro=0;
    Intent upIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colores);
        upIntent = getParentActivityIntent();


        p = new Point();
        Display pantallaDisplay = getWindowManager().getDefaultDisplay();
        pantallaDisplay.getSize(p);
        anchoPantalla = p.x;
        altoPantalla = p.y;
        gridLayout = findViewById(R.id.grilla_layout);
        tv = findViewById(R.id.textView);


        añadirBotones();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(upIntent);
        finish(); // Esto asegura que la actividad actual se cierre
    }
    private void añadirBotones() {
        ViewGroup.LayoutParams lp =
                new ViewGroup.LayoutParams(
                        anchoPantalla / COLUMNAS-30, altoPantalla / FILAS-400);
        gridLayout.setRowCount(2);
        gridLayout.setColumnCount(2);

        for (int i = 0; i < FILAS * COLUMNAS; i++) {
            Button b = new Button(this);

            b.setLayoutParams(lp);
            b.setTextSize(60);
            colores.add(Color.rgb(
                    5 * i + (int) (Math.random() * 150 + 100),
                    5 * i + (int) (Math.random() * 150 + 120),
                    5 * i + (int) (Math.random() * 150 + 80)));
            b.setBackgroundColor(colores.get(i));
            ids[i] = ViewGroup.generateViewId();
            b.setId(ids[i]);
            b.setText(i+"");
            b.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(b.getId()==ids[2]){
                        giraAntiHorario();
                    }
                    if(b.getId()==ids[3]){
                        giraHorario();
                    }
                    if(b.getId()==ids[1]){
                        startActivity(upIntent);
                        finish();
                    }

                }
            });
            gridLayout.setUseDefaultMargins(false);
            gridLayout.addView(b);
        }

    }

    private void giraAntiHorario() {
        Button btAux;
        ArrayList<Integer> coloresAnt = new ArrayList<>();
        for (int i=0; i<colores.size(); i++){
            coloresAnt.add(colores.get(i));
        }
        colores.set(0, coloresAnt.get(1));
        colores.set(2, coloresAnt.get(0));
        colores.set(3, coloresAnt.get(2));
        colores.set(1, coloresAnt.get(3));
        String text = coloresAnt.toString()+colores.toString()+"";
        tv.setText(text);


        for (int i=0; i<colores.size(); i++){
            btAux = findViewById(ids[i]);
            /*int txt = i+giro;
            while(txt>3){
                txt=txt-4;
            }*/
            btAux.setBackgroundColor(colores.get(i));
        }
        giro++;
    }
    private void giraHorario() {
        Button btAux;
        ArrayList<Integer> coloresAnt = new ArrayList<>();
        for (int i=0; i<colores.size(); i++){
            coloresAnt.add(colores.get(i));
        }
        colores.set(1, coloresAnt.get(0));
        colores.set(0, coloresAnt.get(2));
        colores.set(2, coloresAnt.get(3));
        colores.set(3, coloresAnt.get(1));
        String text = coloresAnt.toString()+colores.toString()+"";
        tv.setText(text);


        for (int i=0; i<colores.size(); i++){
            btAux = findViewById(ids[i]);
            /*int txt = i+giro;
            while(txt>3){
                txt=txt-4;
            }*/
            btAux.setBackgroundColor(colores.get(i));
        }
        giro++;
    }
}
