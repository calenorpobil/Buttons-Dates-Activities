package com.merlita.examen291124_povill;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Date;

public class Mayor extends AppCompatActivity {

    EditText et1, et2;
    TextView tv1, tv2;
    Button boton;
    Date d1, d2;
    String ganador;

    Intent upIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mayor);
        upIntent = getParentActivityIntent();


        et1 = findViewById(R.id.etNombre1);
        et2 = findViewById(R.id.etNombre2);
        tv1 = findViewById(R.id.tvFecha1);
        tv2 = findViewById(R.id.tvFecha2);
        boton = findViewById(R.id.button);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new FragmentoFecha();
                Bundle bundle = new Bundle();
                bundle.putInt("id", 1);
                newFragment.setArguments(bundle);
                newFragment.show(getSupportFragmentManager(), "FragmentoFecha");
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new FragmentoFecha();
                Bundle bundle = new Bundle();
                bundle.putInt("id", 2);
                newFragment.setArguments(bundle);
                newFragment.show(getSupportFragmentManager(), "FragmentoFecha");
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date d3 = new Date();
                if(d1!=null && d2!=null && d1.after(d2)){
                    ganador = et2.getText().toString();
                    d2 = d1;
                }else{
                    ganador = et1.getText().toString();
                }

                ganador += ", "+d3.compareTo(d2);


                Toast.makeText(getApplicationContext(),
                        ganador, Toast.LENGTH_LONG).show();
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        };
        //requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);




    }
    public void processDatePickerResult(int year, int month, int day, int id) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.

        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        if(id==1){
            tv1.setText(dateMessage);
            d1 = new Date(year, month, day);
        }else{
            tv2.setText(dateMessage);
            d2 = new Date(year, month, day);
        }
        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(upIntent);
        finish(); // Esto asegura que la actividad actual se cierre
    }

}