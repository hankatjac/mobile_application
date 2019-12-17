package com.tools.application.projectspinnernd5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinnerDays;
    Button btnAssignColors, btnDisplayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        spinnerDays = (Spinner) findViewById(R.id.spinnerDays);
        spinnerDays.setOnItemSelectedListener(this);

        btnAssignColors = (Button) findViewById(R.id.btnAssignColors);
        btnAssignColors.setOnClickListener(this);

        btnDisplayTextView = (Button) findViewById(R.id.btnDisplayTextView);
        btnDisplayTextView.setOnClickListener(this);
    }


    // View.OnClickListener Interface
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnDisplayTextView:
                //-------------------------------------------- Extract text of selected spinner item to Toast it
                View selectedView = spinnerDays.getSelectedView();

                TextView selectedTextView = (TextView) selectedView;
                String selectedText = selectedTextView.getText().toString();

//                String selectedText = spinnerDays.getSelectedItem().toString();
                Toast.makeText(this, "You select : " + selectedText, Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnAssignColors:
                //-------------------------------------------- Assign new array to spinner by adapter
                ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.support_simple_spinner_dropdown_item);

                spinnerDays.setAdapter(adapter);
                break;
        }
    }


    // AdapterView.OnItemSelectedListener Interface ------------------------------------------------
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        TextView textView = (TextView) view;
        String selectTextView = textView.getText().toString();

        Toast.makeText(this, "The selected text is " + selectTextView +
                        "\n Position is " + i +
                        "\n Row id is " + l,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    //----------------------------------------------------------------------------------------------

}
