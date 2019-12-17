package ca.hank.forclass1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDialog, btnToast, btnInternet, btnAsync, btnSpinner, btnListView, btnFile, btnDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(this);

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(this);

        btnInternet = findViewById(R.id.btnInternet);
        btnInternet.setOnClickListener(this);

        btnAsync = findViewById(R.id.btnAsync);
        btnAsync.setOnClickListener(this);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnSpinner.setOnClickListener(this);

        btnListView = findViewById(R.id.btnListView);
        btnListView.setOnClickListener(this);

        btnFile = findViewById(R.id.btnFile);
        btnFile.setOnClickListener(this);

        btnDB = findViewById(R.id.btnDB);
        btnDB.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnDialog): {
                Intent intent = new Intent(this, AlertDialogActivity.class);
                startActivity(intent);
                break;
            }

            case (R.id.btnInternet): {
                Intent intent = new Intent(this, InternetActivity.class);
                startActivity(intent);
                break;
            }

            case (R.id.btnListView): {
                Intent intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
                break;
            }

            case (R.id.btnAsync):{
                Intent intent = new Intent(this, URLConnectorActivity.class);
                startActivity(intent);
                break;
            }


        }


    }
}
