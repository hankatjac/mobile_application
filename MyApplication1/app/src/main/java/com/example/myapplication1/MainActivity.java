package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinnerDays;
    Button btnAssignColors, btnDisplayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        spinnerDays = findViewById(R.id.spinnerDays);
        spinnerDays.setOnItemSelectedListener(this);

        btnAssignColors = findViewById(R.id.btnAssignColors);
        btnAssignColors.setOnClickListener(this);

        btnDisplayTextView = findViewById(R.id.btnDisplayTextView);
        btnDisplayTextView.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = (TextView) view;
        String selectedTextView = textView.getText().toString();

        Toast.makeText(MainActivity.this, "The selected text is " + selectedTextView + "\n Position is " + i + "\n Row id is " + l, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.btnAssignColors): {
                ArrayAdapter colorAdapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.support_simple_spinner_dropdown_item);
                spinnerDays.setAdapter(colorAdapter);
                break;
            }

            case(R.id.btnDisplayTextView): {

                View selectedView = spinnerDays.getSelectedView();
                TextView textView =(TextView) selectedView;
                String selectedText = textView.getText().toString();

                Toast.makeText(this, "You select : " + selectedText, Toast.LENGTH_SHORT).show();


                break;
            }


        }


    }
}
