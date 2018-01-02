package com.simplextechnology.byechat.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.simplextechnology.byechat.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        fillGenderSpinner();
    }


    private void fillGenderSpinner(){
        spinnerGender = findViewById(R.id.spinnerGender);
        List genders   = new ArrayList();
        genders.add("Seleccionar genero");
        genders.add("Femenino");
        genders.add("Masculino");
        genders.add("Otro");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,genders);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(arrayAdapter);

    }

}
