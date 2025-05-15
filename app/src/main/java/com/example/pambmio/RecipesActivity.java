package com.example.pambmio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecipesActivity extends AppCompatActivity {

    TextView recipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipeView = findViewById(R.id.recipeView);

        int calories = getIntent().getIntExtra("calories", 0);
        String recipes = getRecipesForCalories(calories);
        recipeView.setText(recipes);
    }

    private String getRecipesForCalories(int kcal) {
        if (kcal <= 1800) {
            return "Dieta 1600–1800 kcal:\n\n" +
                    "🥗 Przepis 1: Sałatka z tuńczykiem i jajkiem\nSkładniki: sałata, tuńczyk, jajko, oliwa...\n\n" +
                    "🍲 Przepis 2: Zupa krem z dyni i soczewicy\nSkładniki: dynia, soczewica, cebula...";
        } else if (kcal <= 2000) {
            return "Dieta 1801–2000 kcal:\n\n" +
                    "🍗 Przepis 1: Kurczak z kaszą i warzywami\nSkładniki: filet z kurczaka, kasza, brokuły...\n\n" +
                    "🍝 Przepis 2: Makaron pełnoziarnisty z warzywami\nSkładniki: makaron, cukinia, papryka...";
        } else if (kcal <= 2200) {
            return "Dieta 2001–2200 kcal:\n\n" +
                    "🥩 Przepis 1: Wołowina z ryżem i fasolą\nSkładniki: wołowina, ryż, czerwona fasola...\n\n" +
                    "🍛 Przepis 2: Curry z tofu i mlekiem kokosowym\nSkładniki: tofu, mleko kokosowe, curry...";
        } else if (kcal <= 2500) {
            return "Dieta 2201–2500 kcal:\n\n" +
                    "🥙 Przepis 1: Quesadilla z indykiem i warzywami\nSkładniki: tortilla, indyk, papryka...\n\n" +
                    "🥔 Przepis 2: Pieczone bataty z ciecierzycą i jarmużem\nSkładniki: bataty, ciecierzyca, jarmuż...";
        } else {
            return "Brak dopasowanych przepisów do tej kaloryczności.";
        }
    }

    public void goToShoppingList(View view) {
        startActivity(new Intent(this, ShoppingListActivity.class));
    }

}


