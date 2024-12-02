package com.merlita.examen291124_povill;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class FragmentoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    /*
    private FragmentoFechaViewModel mViewModel;

    public static FragmentoFecha newInstance() {
        return new FragmentoFecha();
    }*/

/*
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        //TODO: hs = (FragmentoHora.HoraSeleccionada)
    }
    public void onTimeSet(Time time, int i, int i1){

    }*/
    int id;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        assert bundle != null;
        id =bundle.getInt("id");

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);

    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        // Convert the date elements to strings.
        // Set the activity to the Main Activity.
        Mayor activity = (Mayor) getActivity();
        // Invoke Main Activity's processDatePickerResult() method.
        activity.processDatePickerResult(year, month, day, id);
    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentoFechaViewModel.class);
        // TODO: Use the ViewModel
    }*/
    }
}