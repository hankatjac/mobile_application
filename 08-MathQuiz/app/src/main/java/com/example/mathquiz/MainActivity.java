package com.example.mathquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btDot, btNegative, btGenerate, btValidate, btClear, btScore, btFinish;
    EditText etAnswer;
    TextView tvGenerate, tvTitle;
    float result;
    String message = "";
    String input = "";
    int[] ranArr = new int[3];


    DataCollection dataCollection = new DataCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        tvTitle = findViewById(R.id.tvTitle);

        bt0 = findViewById(R.id.bt0);
        bt0.setOnClickListener(this);

        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);

        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);

        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);

        bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(this);

        bt6 = findViewById(R.id.bt6);
        bt6.setOnClickListener(this);

        bt7 = findViewById(R.id.bt7);
        bt7.setOnClickListener(this);

        bt8 = findViewById(R.id.bt8);
        bt8.setOnClickListener(this);

        bt9 = findViewById(R.id.bt9);
        bt9.setOnClickListener(this);

        btDot = findViewById(R.id.btDot);
        btDot.setOnClickListener(this);

        btNegative = findViewById(R.id.btNegative);
        btNegative.setOnClickListener(this);

        btGenerate = findViewById(R.id.btGenerate);
        btGenerate.setOnClickListener(this);

        btValidate = findViewById(R.id.btValidate);
//        btValidate.setEnabled(false);
        btValidate.setOnClickListener(this);

        btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(this);

        btScore = findViewById(R.id.btScore);
        btScore.setOnClickListener(this);

        btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(this);

        etAnswer = findViewById(R.id.etAnswer);
        tvGenerate = findViewById(R.id.tvGenerate);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case (R.id.bt0): {
                input += bt0.getText().toString();
                etAnswer.setText(input);
                break;
            }
            case (R.id.bt1): {
                input += bt1.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt2): {
                input += bt2.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt3): {
                input += bt3.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt4): {
                input += bt4.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt5): {
                input += bt5.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt6): {
                input += bt6.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt7): {
                input += bt7.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt8): {
                input += bt8.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.bt9): {
                input += bt9.getText().toString();
                etAnswer.setText(input);
                break;
            }

            case (R.id.btNegative): {
                if (!input.startsWith("-")) {
                    input = btNegative.getText().toString() + input;
                    etAnswer.setText(input);
                }
                break;
            }

            case (R.id.btDot): {
                if (!input.contains(".")) {
                    input += btDot.getText().toString();
                    etAnswer.setText(input);
                }
                break;
            }


            case (R.id.btGenerate): {
//                btValidate.setEnabled(true);
                quizGenerate();
                break;
            }


            case (R.id.btClear): {
                etAnswer.setText(null);
                input = "";
                break;
            }

            case (R.id.btValidate): {
                if(tvGenerate.getText().toString().equals("")||etAnswer.getText().toString().equals("")){
                    break;
                }

                quizValidate(ranArr);
                addOperation();
                break;
            }


            case (R.id.btScore): {
                showResult();
                break;
            }

            case (R.id.btFinish): {
                finish();
                System.exit(0);

                break;
            }

        }

    }


    private void quizGenerate() {
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int index = random.nextInt(4);

        String symbol[] = {"+", "-", "*", "/"};

        while (symbol[index] == "/" && num2 == 0) {
            num2 = random.nextInt(10);
        }

        String show = num1 + " " + symbol[index] + " " + num2;

        tvGenerate.setText(show);
        etAnswer.setText(null);
        input = "";

//        ranArr[0] = {num1, num2, index};

        ranArr[0] = num1;
        ranArr[1] = num2;
        ranArr[2] = index;

    }


    private void quizValidate(int[] num) {
        String answer = etAnswer.getText().toString();
        double valueOfAnswer = Double.parseDouble(answer);


        switch (num[2]) {
            case 0: {
                result = num[0] + num[1];

                if (result == valueOfAnswer) {
                    Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                    message = "Right";

                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    message = "Wrong";
                }
                break;
            }

            case 1: {
                result = num[0] - num[1];
                if (result == valueOfAnswer) {
                    Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                    message = "Right";
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    message = "Wrong";
                }
                break;
            }

            case 2: {
                result = num[0] * num[1];
                if (result == valueOfAnswer) {
                    Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                    message = "Right";
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    message = "Wrong";
                }
                break;
            }

            case 3: {

                result = (float) num[0] / num[1];
                double round = Math.round(result * 100.0) / 100.0;
                System.out.println(round);
                System.out.println(valueOfAnswer);

                if (round == valueOfAnswer) {
                    Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
                    message = "Right";
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                    message = "Wrong";
                }

                break;
            }
        }

    }


    private void addOperation() {
        String question = tvGenerate.getText().toString();
        String answer = etAnswer.getText().toString();

        // Create new object and add it to our model array
        Quiz quiz = new Quiz(question, answer, message, result);
        dataCollection.getQuizArray().add(quiz);
    }

    private void showResult() {

        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", dataCollection);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("intentExtra", bundle);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String registerName = data.getStringExtra("registerName");
                String score = data.getStringExtra("score");
                tvTitle.setText("Hello " + registerName + ": your score is: " + score);
            }
            if (resultCode == RESULT_CANCELED) {
                tvTitle.setText("Math Quiz");
            }
        }
    }

}
