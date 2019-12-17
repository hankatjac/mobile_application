package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton rbAll, rbRight, rbWrong, rbAsc, rbDes;
    Button btnShow, btnBack;
    RadioGroup radioGroupSort;
    EditText etName;
    TextView tvScore;
    ListView lvDisplay;
    List<Quiz> quizList;
    ArrayList<Quiz> rightQuizList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        getMyIntent();
    }

    public void init() {
        lvDisplay = findViewById(R.id.lvDisplay);
        tvScore = findViewById(R.id.tvScore);
        radioGroupSort = findViewById(R.id.radioGroupSort);
        etName = findViewById(R.id.etName);


        rbAll = findViewById(R.id.rbAll);
        rbAll.setOnClickListener(this);

        rbRight = findViewById(R.id.rbRight);
        rbRight.setOnClickListener(this);

        rbWrong = findViewById(R.id.rbWrong);
        rbWrong.setOnClickListener(this);

        rbAsc = findViewById(R.id.rbAsc);
        rbAsc.setOnClickListener(this);

        rbDes = findViewById(R.id.rbDes);
        rbDes.setOnClickListener(this);

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);


    }

    private void getMyIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        DataCollection dataCollection = (DataCollection) bundleContent;

        quizList = dataCollection.getQuizArray();
        for (Quiz oneQuiz : quizList) {
            if (oneQuiz.getMessage().equals("Right")) {
                rightQuizList.add(oneQuiz);
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.rbAll): {
                showAllQuiz();
                break;
            }

            case (R.id.rbRight): {
                showRightQuiz();
                break;
            }

            case (R.id.rbWrong): {
                showWrongQuiz();
                break;
            }
            case (R.id.rbAsc): {
                sortQuizAsc();
                break;
            }
            case (R.id.rbDes): {
                sortQuizDes();
                break;
            }

            case (R.id.btnShow): {
                showScore();
                break;
            }

            case (R.id.btnBack): {
                backToFirstPage();
                break;
            }


        }
    }

    private void showAllQuiz() {
        ArrayAdapter<Quiz> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quizList);
        lvDisplay.setAdapter(stringArrayAdapter);

    }


    private void showRightQuiz() {
        ArrayAdapter<Quiz> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rightQuizList);
        lvDisplay.setAdapter(stringArrayAdapter);

    }

    private void showWrongQuiz() {
        ArrayList<Quiz> wrongQuizList = new ArrayList<>();

        for (Quiz oneQuiz : quizList) {
            if (oneQuiz.getMessage().equals("Wrong")) {
                wrongQuizList.add(oneQuiz);
            }
        }

        ArrayAdapter<Quiz> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wrongQuizList);
        lvDisplay.setAdapter(stringArrayAdapter);
    }


    private void sortQuizAsc() {
        Collections.sort(quizList);
        ArrayAdapter<Quiz> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quizList);
        lvDisplay.setAdapter(stringArrayAdapter);

    }

    private void sortQuizDes() {
        Collections.sort(quizList, Collections.<Quiz>reverseOrder());
        ArrayAdapter<Quiz> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quizList);
        lvDisplay.setAdapter(stringArrayAdapter);
    }


    private void showScore() {
        System.out.println("right quiz " + rightQuizList.size());
        System.out.println("Total quiz " + quizList.size());
        float percentage = (float) ((rightQuizList.size() * 100 / quizList.size()));
        tvScore.setText(percentage + "%");

    }


    private void backToFirstPage() {
        String registerName = etName.getText().toString();
        String score = tvScore.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("registerName", registerName);
        intent.putExtra("score", score);
        setResult(RESULT_OK, intent);
        finish();
    }

}



