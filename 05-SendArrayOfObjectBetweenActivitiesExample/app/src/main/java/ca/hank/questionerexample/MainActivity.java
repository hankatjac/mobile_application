package ca.hank.questionerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etClientNumber;
    EditText etClientEmail;
    RadioGroup radioGroupMovie;
    RadioButton rbAdventure;
    RadioButton rbAction;
    RadioButton rbComedy;
    Button btClear;
    Button btAdd;
    Button btRemove;
    Button btUpdate;
    Button btShowAll;
    DataCollection dataCollection = new DataCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        System.out.println("---------------------------onCreate  : When the activity object create for the first time");
    }

    // from stop to start
    @Override
    protected void onRestart(){
        super.onRestart();
        System.out.println("---------------------------onRestart : Run after Stop state and before start state");
    }

    @Override
    protected void onResume(){
        super.onResume();
        System.out.println("---------------------------onResume : ");
    }

    protected void onPause(){
        super.onPause();
        System.out.println("---------------------------onPause : ");
    }

    protected void onStart(){
        super.onStart();
        System.out.println("---------------------------onStart : When activity is becoming visible from stop state");
    }

    protected void onStop(){
        super.onStop();
        System.out.println("---------------------------onStop : When activity is no longer visible");

    }

    protected void onDestroy(){
        super.onDestroy();
        System.out.println("---------------------------onDestroy : When activity is about to be destroyed and completely remove from RAM");

    }

    public void init() {
        etClientNumber = findViewById(R.id.etClientNumber);
        etClientEmail = findViewById(R.id.etClientEmail);

        radioGroupMovie = findViewById(R.id.radioGroupMovie);

        rbAction = findViewById(R.id.rbAction);
        rbComedy = findViewById(R.id.rbComedy);
        rbAdventure = findViewById(R.id.rbAdventure);

        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);

        btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(this);

        btRemove = findViewById(R.id.btRemove);
        btRemove.setOnClickListener(this);

        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(this);

        btShowAll = findViewById(R.id.btShowAll);
        btShowAll.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btClear:
                clear();
                break;

            case R.id.btAdd:
                add();
                break;

            case R.id.btRemove:
                remove();
                break;

            case R.id.btUpdate:
                update();
                break;

            case R.id.btShowAll:
                show();
                break;
        }
    }

    private void clear() {
        etClientNumber.setText(null);
        etClientEmail.setText(null);
    }

    private void add() {
        int clientNumber = Integer.valueOf(etClientNumber.getText().toString());
        String clientEmail = etClientEmail.getText().toString();
        String selectedRadioGroup = "";

        if (rbAdventure.isChecked()) {
            selectedRadioGroup = rbAdventure.getTag().toString();

            System.out.println(rbAdventure.getTag().toString());
            System.out.println(selectedRadioGroup);

        } else if (rbAction.isChecked()) {
            selectedRadioGroup = rbAction.getTag().toString();
        } else if (rbComedy.isChecked()) {
            selectedRadioGroup = rbComedy.getTag().toString();

        }

        System.out.println("ClientNumber: " + clientNumber + " Client Email: " + clientEmail + " Select RadioGroup: " + selectedRadioGroup);

        Client client = new Client(clientNumber, clientEmail, selectedRadioGroup);
        System.out.println(client.toString());

        dataCollection.getClientArray().add(client);
        System.out.println(dataCollection.clientArray);

        Toast.makeText(this, client.getClientNumber() + " added successfully", Toast.LENGTH_LONG).show();

    }


    private void remove() {
        int id= findClient();
        if (id >=0){
            dataCollection.getClientArray().remove(id);
        }

        Toast.makeText(this, " remove successfully", Toast.LENGTH_LONG).show();
    }

    private void update() {
        String email = etClientEmail.getText().toString();
        int id = findClient();
        if(id>=0){
            dataCollection.getClientArray().get(id).setEmail(email);
        }
        Toast.makeText(this, "update successfully", Toast.LENGTH_LONG).show();
    }


    private void show() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", dataCollection);
        Intent intent = new Intent(this, ActivityShowClient.class);
        intent.putExtra("intentExtra", bundle);
        startActivity(intent);

    }


    private int findClient() {
        // detect client number in edit text field
        int clientNumber = Integer.valueOf(etClientNumber.getText().toString());
        boolean found = false;
        // iterate on client array
        for (Client oneClient : dataCollection.getClientArray()) {
            //check each client for client number
            if (oneClient.getClientNumber() == clientNumber) {
                found = true;
                System.out.println(dataCollection.clientArray);
                return dataCollection.getClientArray().indexOf(oneClient);
            }
        }

        if (!found) {
            Toast.makeText(this, "not found", Toast.LENGTH_LONG).show();
        }
        return -1;
    }

}

