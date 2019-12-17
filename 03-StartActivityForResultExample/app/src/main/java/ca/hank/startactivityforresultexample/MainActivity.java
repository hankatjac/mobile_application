package ca.hank.startactivityforresultexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private EditText etNumber1;
    private EditText etNumber2;
    private Button btOpenActivity2;

    public static final String EXTRA_NUMBER1 = "number1";
    public static final String EXTRA_NUMBER2 = "number2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        tvResult = findViewById(R.id.tvResult);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);

        btOpenActivity2 = findViewById(R.id.btOpenActivity2);
        btOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNumber1.getText().toString().equals("") || etNumber2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_LONG).show();
                } else {
                    int number1 = Integer.parseInt(etNumber1.getText().toString());
                    int number2 = Integer.parseInt(etNumber2.getText().toString());

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra(EXTRA_NUMBER1, number1);
                    intent.putExtra(EXTRA_NUMBER2, number2);

                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                tvResult.setText(String.valueOf(result));
            }
            if (resultCode == RESULT_CANCELED) {
                tvResult.setText("Nothing Selected");
            }
        }
    }

}
