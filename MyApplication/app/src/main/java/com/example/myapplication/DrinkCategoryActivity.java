package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        init();
    }

    public void init() {
        ListView listDrinks = findViewById(R.id.list_drinks);

        ArrayAdapter<Drink> drinkArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        listDrinks.setAdapter(drinkArrayAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listDrinkAdapterView, View view, int position, long id) {

                System.out.println("DrinkCategoryActivity-----------------" + listDrinkAdapterView.getItemAtPosition(position).toString());
                Toast.makeText(DrinkCategoryActivity.this, "postiton = " + position + " , id = " + id, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int)id);
                startActivity(intent);
            }
        };

        listDrinks.setOnItemClickListener(itemClickListener);


    }
}
