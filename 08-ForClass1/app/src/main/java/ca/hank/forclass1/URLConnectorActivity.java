package ca.hank.forclass1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class URLConnectorActivity extends AppCompatActivity implements View.OnClickListener, HttpURLConnectionPostProcessorInterface {
    TextView textViewData, textViewProgress;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlconnector);
        init();
    }


    private void init(){
        textViewData = findViewById(R.id.textViewData);
        textViewProgress = findViewById(R.id.textViewProgress);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }

    public void onClick(View v) {
        String muURLString = "https://www.w3schools.com/xml/simple.xml";

        AsynchronousHttpURLConnector asynchronousHttpURLConnector = new AsynchronousHttpURLConnector(muURLString, this, textViewProgress);

        asynchronousHttpURLConnector.execute();
    }

    public void successHandler(String dataInXml){
        System.out.println("-------------------- sucessHandler :" + dataInXml);
        textViewData.setText(dataInXml);
    }

    public void failureHandler(Exception exception){
        System.out.println("-------------------- failueHandler :" );

    }
}
