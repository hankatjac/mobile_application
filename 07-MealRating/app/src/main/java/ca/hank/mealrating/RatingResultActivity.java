package ca.hank.mealrating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatingResultActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1star, btn2star, btn3star, btnAsc, btnDes, btnBack;
    RadioGroup radioGroupStar;
    EditText etName;
    TextView tvResult;
    List<MealRating> mealList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_result);
        init();
        getMyIntent();

    }

    public void init() {

        etName = findViewById(R.id.etName);
        tvResult = findViewById(R.id.tvResult);

        radioGroupStar = findViewById(R.id.radioGroupStar);


        btn1star = findViewById(R.id.btn1star);
        btn1star.setOnClickListener(this);

        btn2star = findViewById(R.id.btn2star);
        btn2star.setOnClickListener(this);

        btn3star = findViewById(R.id.btn3star);
        btn3star.setOnClickListener(this);

        btnAsc = findViewById(R.id.btnAsc);
        btnAsc.setOnClickListener(this);

        btnDes = findViewById(R.id.btnDes);
        btnDes.setOnClickListener(this);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

    }

    private void getMyIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        DataCollection dataCollection = (DataCollection) bundleContent;
        mealList = dataCollection.getMealArray();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1star:
                showOneStarResult();
                break;
            case R.id.btn2star:
                showTwoStarResult();
                break;
            case R.id.btn3star:
                showThreeStarResult();
                break;
            case R.id.btnAsc:
                showAscResult();
                break;
            case R.id.btnDes:
                showDesResult();
                break;
            case R.id.btnBack:
                backToMainActivity();
                break;

        }
    }


    private void showOneStarResult() {
        String str = "";

        ArrayList<MealRating> mealOneStarRatingList = new ArrayList<>();

        for (MealRating oneMealRating : mealList) {

            if (oneMealRating.getRating() == 1) {
                mealOneStarRatingList.add(oneMealRating);
            }
        }

        for (int i = 0; i < mealOneStarRatingList.size(); i++) {
            str += mealOneStarRatingList.get(i) + "\n";
        }

        tvResult.setText(str);


    }


    private void showTwoStarResult() {
        String str = "";


        ArrayList<MealRating> mealTwoStarRatingList = new ArrayList<>();

        for (MealRating oneMealRating : mealList) {

            if (oneMealRating.getRating() == 2) {
                mealTwoStarRatingList.add(oneMealRating);
            }

        }

        for (int i = 0; i < mealTwoStarRatingList.size(); i++) {
            str += mealTwoStarRatingList.get(i) + "\n";
        }

        tvResult.setText(str);
    }


    private void showThreeStarResult() {
        String str = "";

        ArrayList<MealRating> mealThreeStarRatingList = new ArrayList<>();

        for (MealRating oneMealRating : mealList) {

            if (oneMealRating.getRating() == 3) {
                mealThreeStarRatingList.add(oneMealRating);
            }
        }

        for (int i = 0; i < mealThreeStarRatingList.size(); i++) {
            str += mealThreeStarRatingList.get(i) + "\n";
        }

        tvResult.setText(str);
    }


    private void showAscResult() {
        String str = "";
        Collections.sort(mealList);

        for (int i = 0; i < mealList.size(); i++) {
            str += mealList.get(i) + "\n";
        }
        tvResult.setText(str);

    }

    private void showDesResult() {
        String str = "";
        Collections.sort(mealList, Collections.<MealRating>reverseOrder());

        for (int i = 0; i < mealList.size(); i++) {
            str += mealList.get(i) + "\n";
        }

        tvResult.setText(str);
    }


    private void backToMainActivity() {

        String clientName = etName.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("clientName", clientName);
        startActivity(intent);
    }

}
