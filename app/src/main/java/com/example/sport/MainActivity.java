package com.example.sport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText nameEdt;
     EditText heightEdt;
     EditText weightEdt;
     EditText targetweightEdt;
     TextView resultTxt;
     TextView waterNededEDT;
     Spinner gender;
     Button save;
     Context context;
     SharedPreferences sharedPref;
     SharedPreferences.Editor editor;

    public static final String mypreference = "mypref";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdt = findViewById(R.id.nameEdt);
        heightEdt = findViewById(R.id.heightEdt);
        weightEdt = findViewById(R.id.weightEdt);
        targetweightEdt = findViewById(R.id.targetweightEdt);
        resultTxt = findViewById(R.id.resultTxt);
        save = findViewById(R.id.save);
        waterNededEDT = findViewById(R.id.waterNededEDT);
        gender = findViewById(R.id.spinner);

    }




    public void save(View view) {
        try {

            sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            editor = sharedPref.edit();

            float heightValue = Float.parseFloat(heightEdt.getText().toString());
            float weightValue = Float.parseFloat(weightEdt.getText().toString());
            float targetweightValue = Float.parseFloat(targetweightEdt.getText().toString());

            editor.putString("userNamePref" , String.valueOf(nameEdt));
            editor.putFloat("heightPref" , heightValue);
            editor.putFloat("weightPref" , weightValue);
            editor.putFloat("targetweightValuePref" , targetweightValue);
            editor.putString("genderPref" , String.valueOf(gender));

            editor.commit();


            Toast.makeText(this, "Data Saved:\n",
                    Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Fill the empty fields please\n",
                    Toast.LENGTH_SHORT).show();
        }

    }



     public void calculateBMI(View view){

        double heightNum = new Double(String.valueOf(heightEdt.getText()));
        double weightNum = new Double(String.valueOf(weightEdt.getText()));

        double res = (weightNum / (heightNum * heightNum)) * 10000;


        if ( res <= 18.4) {
            resultTxt.setText("The result is (UnderWeight)");
        } else if (res >= 18.5 && res <= 24.9) {
            resultTxt.setText("The result is (Normal)");
        } else if (res >= 25.0 ) {
            resultTxt.setText("The result is (OverWeight)");
        }

    }

    public void waterNeeded(View view) {
        double weightNum = new Double(String.valueOf(weightEdt.getText()));
        double need = weightNum * 30 * 0.001;
        waterNededEDT.setText("For your weight you need " + need + "(Liter)");
        editor.putString("waterNeeded" , String.valueOf(waterNededEDT));
        editor.commit();


    }

    public void bmi(View view){
        Intent intent = new Intent(this, bmiCalculater.class);
        startActivity(intent);

    }
    public void water(View view){
        Intent intent = new Intent(this, water.class);
        startActivity(intent);


    }
}



