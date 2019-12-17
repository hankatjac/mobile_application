package ca.hank.questionerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class ActivityShowClient extends AppCompatActivity {
    Button btList;
    RadioButton rbAdventure;
    RadioButton rbAction;
    RadioButton rbComedy;
    RadioButton rbAll;
    TextView textViewClients;
    String str;
    List<Client> clientList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);
        init();
        getMyIntent();
    }

    public void init(){
        rbAdventure = findViewById(R.id.rbAdventure);
        rbAction = findViewById(R.id.rbAction);
        rbComedy = findViewById(R.id.rbComedy);
        rbAll = findViewById(R.id.rbAll);
        textViewClients= findViewById(R.id.tvShow);
        btList= findViewById(R.id.btList);
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showListOfClients(view);
            }
        });
    }

    private void getMyIntent(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        Serializable bundleContent = bundle.getSerializable("bundleContent");
        DataCollection dataCollection = (DataCollection) bundleContent;
        clientList = dataCollection.getClientArray();
    }

    public void showListOfClients(View view){
        if(rbAdventure.isChecked()){
            iterateByType("adv");
        }else if(rbAction.isChecked()) {
            iterateByType("action");
        }if(rbComedy.isChecked()) {
            iterateByType("comedy");
        }if(rbAll.isChecked()) {
            iterateByType("all");
        }
        textViewClients.setText(str);
    }



    void iterateByType(String myType){
        str="";

        for (Client oneClient: clientList){
            if (myType.equals("all")){
                str = str + oneClient + "\n";
            }else if(oneClient.getMovieType().equals(myType)){
                str = str + oneClient + "\n";
            }
        }

    }
}
