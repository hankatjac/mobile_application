package ca.hank.sendarrayofstringbetweenactivitiesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    Button btSubmit;
    EditText etAddNewClass;
    TextView tvArray2;
    //    String arrayOfString[] = new String[4];
    ArrayList<String> arrayListOfString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
    }

    public void init() {
//        Intent intent = getIntent();
        arrayListOfString = getIntent().getStringArrayListExtra(MainActivity.EXTRA_ARRAY);

        etAddNewClass = findViewById(R.id.etAddNewClass);
        tvArray2 = findViewById(R.id.tvArray2);

        btSubmit = findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListOfString.add(etAddNewClass.getText().toString());
//                arrayOfString[4] = etAddNewClass.getText().toString();
//                for (String str: arrayListOfString) {
//                    tvArray2.setText(str);
//                }
                String classes = "";
//                for(int i=0; i<arrayListOfString.size(); i++){
//                    classes += arrayListOfString.get(i) + "\n";
//                }
                for (String str : arrayListOfString) {
                    classes += str + "\n";
                }

                tvArray2.setText(classes);
//                tvArray2.setText(arrayListOfString.get(0) + "\n" + arrayListOfString.get(1) + "\n" +arrayListOfString.get(2) + "\n" +arrayListOfString.get(3));

            }
        });

    }
}
