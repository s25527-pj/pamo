package com.example.pambmio;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ShoppingListAdapter adapter;
    ArrayList<ShoppingItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        recyclerView = findViewById(R.id.shoppingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();
        items.add(new ShoppingItem("Filet z kurczaka"));
        items.add(new ShoppingItem("Kasza gryczana"));
        items.add(new ShoppingItem("Brokuły"));
        items.add(new ShoppingItem("Oliwa z oliwek"));
        items.add(new ShoppingItem("Czosnek"));

        adapter = new ShoppingListAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
