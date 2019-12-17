package ca.hank.personinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    RadioGroup radioGroupSex, radioGroupSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        editTextName = findViewById(R.id.editText);
        radioGroupSex = findViewById(R.id.radioGroupSex);
        radioGroupSport = findViewById(R.id.radioGroupSport);
    }

    public void showMe(View view) {
        int selected_sex_radio_btn = radioGroupSex.getCheckedRadioButtonId();
        int selected_sport_radio_btn = radioGroupSport.getCheckedRadioButtonId();

        String name = editTextName.getText().toString();
        String strSex;

        if (selected_sex_radio_btn == R.id.radioFemale)
            strSex = "Female";
        else
            strSex = "Male";

        String strSport = null;


        switch (selected_sport_radio_btn) {
            case R.id.radioHandball:
                strSport = "Handball";
                break;
            case R.id.radioHockey:
                strSport = "Hockey";
                break;
            case R.id.radioSoccer:
                strSport = "Soccker";
                break;
        }

        String strToToast = "My name is: " + name + "\n" + "I'm: " + strSex + "\n" + "My favorite sport is: " + strSport;

        Toast.makeText(this, strToToast, Toast.LENGTH_LONG).show();

    }

}
