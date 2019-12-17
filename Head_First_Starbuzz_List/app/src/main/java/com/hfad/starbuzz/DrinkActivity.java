package com.hfad.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.starbuzz.model.Drink;

public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINKID = "drinkId";

    ImageView photo;
    TextView name, description;
    Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        initialize();
        getMyIntent();
        populateData(drink);
    }

    private void initialize() {
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        photo = findViewById(R.id.photo);
    }

    private void getMyIntent() {

        // 1- Get the drink from the intent
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);

        drink = Drink.drinks[drinkId];
    }

    private void populateData(Drink drink) {

        // 2- Populate the drink name
        name.setText(drink.getName());

        // 3- Populate the drink description
        description.setText(drink.getDescription());

        // 4- Populate the drink image
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}