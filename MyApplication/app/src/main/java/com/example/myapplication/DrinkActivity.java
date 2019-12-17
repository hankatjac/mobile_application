package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKID = "drinkId";

    ImageView ivPhoto;
    TextView tvName, tvDescription;
    Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        init();
        getMyIntent();
        populateData(drink);

    }

    public void init(){
        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        ivPhoto = findViewById(R.id.ivPhoto);
    }

    private void getMyIntent(){
        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINKID);
        drink = Drink.drinks[drinkId];
    }

    private void populateData(Drink drink){
        tvName.setText(drink.getName());
        tvDescription.setText(drink.getDescription());
        ivPhoto.setImageResource(drink.getImageResourceId());
        ivPhoto.setContentDescription(drink.getName());
    }


}
