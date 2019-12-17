package ca.hank.mealrating;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinnerMeal;
    ImageView imageViewMeal;
    RatingBar ratingBarMeal;
    Button btnAdd, btnShowAll, btnMeal, btnSalad;
    TextView tvTitle;
    String listMeal[] = {"Salmon", "Poutine", "Sushi", "Tacos"};
    int mealPicture[] = {R.drawable.salmon, R.drawable.poutine, R.drawable.sushi, R.drawable.tacos};

    String listSalad[] = {"Chicken", "Montreal", "Green"};
    int saladPicture[] = {R.drawable.chicken, R.drawable.montreal, R.drawable.green};

    ArrayAdapter<String> mealAdapter;
    ArrayAdapter<String> saladAdapter;

    DataCollection dataCollection = new DataCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        spinnerMeal = findViewById(R.id.spinnerMeal);
        spinnerMeal.setOnItemSelectedListener(this);

        ratingBarMeal = findViewById(R.id.ratingBar);
        imageViewMeal = findViewById(R.id.imageView);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnShowAll = findViewById(R.id.btnShowAll);
        btnShowAll.setOnClickListener(this);


        btnMeal = findViewById(R.id.btnMeal);
        btnMeal.setOnClickListener(this);

        btnSalad = findViewById(R.id.btnSalad);
        btnSalad.setOnClickListener(this);

        tvTitle = findViewById(R.id.tvTitle);

        String clientName = getIntent().getStringExtra("clientName");
        if (clientName == null) {
            tvTitle.setText("John Abott College");
        } else {
            tvTitle.setText("Thank You: " + clientName);
        }
    }


    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        // i is index of selected item in spinner, so we can assign the corresponding image reference from our image array to our imageView

//        View selectedView = spinnerMeal.getSelectedView();
//        TextView selectedTextView = (TextView) selectedView;
//        String selectedText = selectedTextView.getText().toString();

        String mealOrder = spinnerMeal.getSelectedItem().toString();

        switch (mealOrder) {
            case "Chicken":
            case "Montreal":
            case "Green": {
                int image = saladPicture[i];
                imageViewMeal.setImageResource(image);
                break;
            }
            case "Salmon":
            case "Poutine":
            case "Sushi":
            case "Tacos": {
                int image = mealPicture[i];
                imageViewMeal.setImageResource(image);
                break;
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                addMealRating();
                break;
            case R.id.btnShowAll:
                showAllMealRating();
                break;
            case R.id.btnSalad:
                openSaladRating();
                break;
            case R.id.btnMeal:
                openMealRating();
                break;
        }

    }

    private void addMealRating() {
        String meal = spinnerMeal.getSelectedItem().toString();

        // Read ratingBar
        int rating = (int) ratingBarMeal.getRating();

        // Create new object and add it to our model array
        MealRating mealRating = new MealRating(meal, rating);
        dataCollection.getMealArray().add(mealRating);

        // Reset rating bar for next time
        ratingBarMeal.setRating(0);

    }

    private void showAllMealRating() {

        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", dataCollection);
        Intent intent = new Intent(this, RatingResultActivity.class);
        intent.putExtra("intentExtra", bundle);
        startActivity(intent);

    }


    private void openSaladRating() {

        saladAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listSalad);
        spinnerMeal.setAdapter(saladAdapter);


    }

    private void openMealRating() {

        mealAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listMeal);
        spinnerMeal.setAdapter(mealAdapter);

    }


}
