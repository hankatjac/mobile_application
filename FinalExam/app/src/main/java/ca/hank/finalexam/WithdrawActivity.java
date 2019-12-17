package ca.hank.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WithdrawActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvBalance;
    EditText etAmountWithdraw;
    Button btnWithdraw;

    Client selectedClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        init();
    }


    private void init() {
        tvBalance = findViewById(R.id.tvBalance);
        etAmountWithdraw = findViewById(R.id.etAmountWithdraw);
        selectedClient = (Client) getIntent().getSerializableExtra("selectedClient");
        tvBalance.setText("$" + (selectedClient.getAccount().getBalance()));

        btnWithdraw = findViewById(R.id.btnWithdraw);
        btnWithdraw.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (etAmountWithdraw.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter an amount to withdraw", Toast.LENGTH_LONG).show();
        } else {
            float amount = Float.parseFloat(etAmountWithdraw.getText().toString());
            if (amount > selectedClient.getAccount().getBalance()) {
                Toast.makeText(this, "insufficient balance", Toast.LENGTH_LONG).show();
            } else {
                float result = selectedClient.getAccount().getBalance() - amount;
                selectedClient.getAccount().setBalance(result);
                tvBalance.setText("$" + result);
            }
        }


        for (Client oneClient : MainActivity.clientList) {
            if (oneClient.getSin().equals(selectedClient.getSin())) {
                oneClient.getAccount().setBalance(selectedClient.getAccount().getBalance());
            }
        }


    }


}
