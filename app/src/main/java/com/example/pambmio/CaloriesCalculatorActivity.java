package com.example.pambmio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    EditText weight, height, age;
    Spinner activityLevel;
    Button calculateBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        activityLevel = findViewById(R.id.activityLevel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityLevel.setAdapter(adapter);

        calculateBtn = findViewById(R.id.calculateButton);
        result = findViewById(R.id.result);

        calculateBtn.setOnClickListener(v -> calculateCalories());
    }

    private void calculateCalories() {
        float w = Float.parseFloat(weight.getText().toString());
        float h = Float.parseFloat(height.getText().toString());
        int a = Integer.parseInt(age.getText().toString());
        float bmr = 66.47f + (13.75f * w) + (5.003f * h) - (6.755f * a);

        float multiplier;
        switch (activityLevel.getSelectedItemPosition()) {
            case 0: multiplier = 1.2f; break;
            case 1: multiplier = 1.375f; break;
            case 2: multiplier = 1.55f; break;
            case 3: multiplier = 1.725f; break;
            default: multiplier = 1.9f;
        }

        float calories = bmr * multiplier;
        result.setText(String.format("Zapotrzebowanie: %.0f kcal/dzień", calories));

        Intent intent = new Intent(this, RecipesActivity.class);
        intent.putExtra("calories", (int) calories);
        startActivity(intent);
    }
}
