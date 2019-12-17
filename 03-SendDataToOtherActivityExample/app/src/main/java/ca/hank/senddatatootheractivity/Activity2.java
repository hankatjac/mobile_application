package ca.hank.senddatatootheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
    }

    public void init(){
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

//        System.out.println(name);
//        System.out.println(number);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvNumber = findViewById(R.id.tvNumber);
        tvName.setText(name);
//        tvNumber.setText(number + "");
        tvNumber.setText(String.valueOf(number));

    }
}
