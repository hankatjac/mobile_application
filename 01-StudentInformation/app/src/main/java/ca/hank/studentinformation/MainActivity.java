package ca.hank.studentinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextID, editTextName, editTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private  void initialize(){
        editTextID= findViewById(R.id.editTextID);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
    }

    public void display(View view){
        String id = editTextID.getText().toString();
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();

        Toast.makeText(this, "my id is: " + id + "\n" + "The name is: " + name + "\n" + "The age is: " + age, Toast.LENGTH_LONG).show();
    }
}
