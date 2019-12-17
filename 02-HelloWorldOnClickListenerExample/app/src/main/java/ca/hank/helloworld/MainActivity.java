package ca.hank.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        // Approach 1 : Create and pass an object
//        View.OnClickListener myOncClickListenerObject = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Approach 1: Create and Pass an object", Toast.LENGTH_LONG).show();
//                getUserInput();
//            }
//        };
//        button.setOnClickListener(myOncClickListenerObject);

        // Approach 2 :Anonymous Inner Class
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Approach 2: Anonymous Inner Class", Toast.LENGTH_LONG).show();
//                getUserInput();
//            }
//        });

        // Approach 3 : Lambda expression
//        button.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Approach 3: Lambda Expresson", Toast.LENGTH_LONG).show());

        // Approach 4 implement view.onClickListener
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "The first one way to bind the button", Toast.LENGTH_LONG).show();
        getUserInput();
    }


    public void getUserInput() {
        String text = editText.getText().toString();
        textView.setText(text);
    }


}
