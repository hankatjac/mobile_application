package ca.hank.senddatatootheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNumber;

    public static final String EXTRA_NAME = "Name";
    public static final String EXTRA_NUMBER = "Number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    public void init() {
        Button btSend = findViewById(R.id.btSend);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfo();
            }
        });
    }


    public void sendInfo() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        String text = etName.getText().toString();
        int number = Integer.parseInt(etNumber.getText().toString());

        intent.putExtra(EXTRA_NAME, text);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }

}
