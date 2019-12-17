package ca.hank.startactivityforresultexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tvNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
    }

   public void init(){
       Intent intent = getIntent();
       final int number1 = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
       final int number2 = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
       tvNumbers = findViewById(R.id.tvNumbers);
       tvNumbers.setText("Numbers: " + number1 + ", " + number2);

       Button btAdd = findViewById(R.id.btAdd);
       btAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int result = number1 + number2;
               Intent resultIntent = new Intent();
               resultIntent.putExtra("result", result);
               setResult(RESULT_OK, resultIntent);
               finish();
           }
       });

       Button btSubtract = findViewById(R.id.btSubtract);
       btSubtract.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int result = number1 - number2;

               Intent resultIntent = new Intent();
               resultIntent.putExtra("result", result);
               setResult(RESULT_OK, resultIntent);
               finish();
           }
       });
   }
}
