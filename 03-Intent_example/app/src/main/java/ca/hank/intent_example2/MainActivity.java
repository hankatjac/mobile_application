package ca.hank.intent_example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button buttonRed = findViewById(R.id.btRed);
        Button buttonBlue = findViewById(R.id.btBlue);
        Button buttonYellow = findViewById(R.id.btYellow);

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRedActivity();
            }

            private void openRedActivity() {
                Intent intent = new Intent(getApplicationContext(), RedActivity.class);
                startActivity(intent);

            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBlueActivity();
            }

            private void openBlueActivity() {
                Intent intent = new Intent(getApplicationContext(), BlueActivity.class);
                startActivity(intent);
            }
        });
        
        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYellowActivity();
            }

            private void openYellowActivity() {
                Intent intent = new Intent(getApplicationContext(), YellowActivity.class);
                startActivity(intent);
            }
        });
    }

}
