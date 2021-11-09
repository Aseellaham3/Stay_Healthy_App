package com.example.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiCalculater extends AppCompatActivity {

    EditText heightEdt;
    EditText weightEdt;
    TextView waterNededEDT;
    TextView resultTxt;
    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    public static final String mypreference = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculater);

    }

    public void Get(View view) {
        heightEdt = findViewById(R.id.heightEdt);
        weightEdt = findViewById(R.id.weightEdt);
        resultTxt = findViewById(R.id.resultTxt);
        waterNededEDT = findViewById(R.id.waterNededEDT);
        sharedPref = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedPref.contains("heightPref"))
            heightEdt.setText(sharedPref.getString("heightPref", ""));
        if (sharedPref.contains("weightPref"))
            weightEdt.setText(sharedPref.getString("weightPref", ""));
        if (sharedPref.contains("waterNeeded"))
            waterNededEDT.setText(sharedPref.getString("waterNeeded", ""));
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void water(View view){
        Intent intent = new Intent(this, water.class);
        startActivity(intent);


    }

    }




