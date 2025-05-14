package com.example.pambmio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pambmio.utils.BMICalculator;


/**
 * Author: Uzarski Maciej
 * Simple BMI calculator app, implemented during PAMO class, PJATK 2025
 * Task1 - Create simple app with two input fields [weight(kg), height(cm)]
 * After input is provided, calculate BMI and show status to the user
 */

public class BMICalculatorActivity extends AppCompatActivity {

    EditText weightInput, heightInput;
    TextView bmiResult;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        bmiResult = findViewById(R.id.bmiResult);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(view -> {
            try {
                float weight = Float.parseFloat(weightInput.getText().toString());
                float height = Float.parseFloat(heightInput.getText().toString());

                float bmi = BMICalculator.calculateBMI(weight, height);
                String status = BMICalculator.interpretBMI(bmi);

                String resultText = String.format("BMI: %.2f\nStatus: %s", bmi, status);
                bmiResult.setText(resultText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Podaj poprawne liczby", Toast.LENGTH_SHORT).show();
            } catch (IllegalArgumentException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToCalories(View view) {
        Intent intent = new Intent(this, CaloriesCalculatorActivity.class);
        startActivity(intent);
    }

    public void goToRecipes(View view) {
        Intent intent = new Intent(this, RecipesActivity.class);
        intent.putExtra("calories", 2000); // Możesz zmienić na coś dynamicznego lub usunąć
        startActivity(intent);
    }
}
