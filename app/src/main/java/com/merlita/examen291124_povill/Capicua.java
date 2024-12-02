package com.merlita.examen291124_povill;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Date;

public class Capicua extends AppCompatActivity {

    EditText et1;
    Button button;
    String ganador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mayor);

        et1 = findViewById(R.id.etNombre1);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getApplicationContext(),
                        ganador, Toast.LENGTH_LONG).show();
            }
        });





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
        }else{
        }
        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show();
    }

}