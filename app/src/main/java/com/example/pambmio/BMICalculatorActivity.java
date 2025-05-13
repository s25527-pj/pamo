package com.example.pambmio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Author: Uzarski Maciej
 * Simple BMI calculator app, implemented during PAMO class, PJATK 2025
 * Task1 - Create simple app with two input fields [weight(kg), height(cm)]
 * After input is provided, calculate BMI and show status to the user
 */

public class BMICalculatorActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    Button calculateButton;
    TextView bmiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        bmiResult = findViewById(R.id.bmiResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            bmiResult.setText("Wprowadź poprawne dane.");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float heightCm = Float.parseFloat(heightStr);
        float heightM = heightCm / 100;

        float bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) {
            status = "Niedowaga";
        } else if (bmi < 24.9) {
            status = "Optimum";
        } else if (bmi < 29.9) {
            status = "Nadwaga";
        } else {
            status = "Otyłość";
        }

        bmiResult.setText(String.format("BMI: %.2f\nStatus: %s", bmi, status));
    }

    public void goToCalories(View view) {
        Intent intent = new Intent(this, CaloriesCalculatorActivity.class);
        startActivity(intent);
    }

    public void goToRecipes(View view) {
        Intent intent = new Intent(this, RecipesActivity.class);
        startActivity(intent);
    }

}
