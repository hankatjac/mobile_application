package ca.hank.sendarrayofstringbetweenactivitiesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btSend;
    TextView tvArray;
    public static final String EXTRA_ARRAY = "Array of String";
    ArrayList<String> classList = new ArrayList<>();
//    String arrayOfClasses[] ={"java","php","sql"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){

        tvArray = findViewById(R.id.tvArray);

        classList.add("java");
        classList.add("sql");
        classList.add("php");

//        tvArray.setText(arrayOfClasses[0] + "\n" + arrayOfClasses[1] + "\n" + arrayOfClasses[2]);
        tvArray.setText(classList.get(0) + "\n" + classList.get(1) + "\n" + classList.get(2));

        btSend =findViewById(R.id.btSend);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendArrayOfString();
            }
        });
    }

    public void  sendArrayOfString(){
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra(EXTRA_ARRAY, classList);
        startActivity(intent);
    }
}
