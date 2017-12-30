package com.simplextechnology.byechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillGenderSpinner();
    }


    private void fillGenderSpinner(){
        spinnerGender = findViewById(R.id.spinnerGender);
        List genders   = new ArrayList();
        genders.add("Seleccionar genero");
        genders.add("Femenino");
        genders.add("Masculino");
        genders.add("Otro");
        genders.add("Orlando es marica");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,genders);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(arrayAdapter);

    }

}
