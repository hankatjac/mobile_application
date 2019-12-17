package ca.hank.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Iterator;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_CLIENTID = "clientId";

    EditText etAccountNumber, etOpenDate, etBalance, etName, etFamily, etPhone, etSin;
    Button btnAdd, btnFind, btnRemove, btnUpdate, btnClear, btnShowAll;
    Client client;

    DataCollection dataCollection = new DataCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initialize();

        Bundle bundle= getIntent().getExtras();
        if (bundle!= null)
       {
        getMyIntent();
        populateData(client);}

    }

    private void initialize() {
        etName = findViewById(R.id.etName);
        etFamily = findViewById(R.id.etFamily);
        etPhone = findViewById(R.id.etPhone);
        etSin = findViewById(R.id.etSin);
        etAccountNumber = findViewById(R.id.etAcoountNumber);
        etOpenDate = findViewById(R.id.etOpenDate);
        etBalance = findViewById(R.id.etBalance);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnFind = findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);

        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnShowAll = findViewById(R.id.btnShowAll);
        btnShowAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.btnAdd): {
                addClient();
                break;
            }

            case (R.id.btnFind): {
                findClient();
                break;

            }

            case (R.id.btnRemove): {
                removeClient();
                break;
            }


            case (R.id.btnUpdate): {
                updateClient();
                break;
            }


            case (R.id.btnClear): {
                etAccountNumber.setText(null);
                etOpenDate.setText(null);
                etBalance.setText(null);
                etName.setText(null);
                etFamily.setText(null);
                etPhone.setText(null);
                etSin.setText(null);
                break;
            }


            case (R.id.btnShowAll): {
                showAllClient();
                break;
            }


        }
    }

    private void getMyIntent() {
        // 1- Get the drink from the intent

        int clientId = (Integer) getIntent().getExtras().get(EXTRA_CLIENTID);
//        client = Client.clients[clientId];
        client = MainActivity.clientList.get(clientId);


    }

    private void populateData(Client client) {

        // 2- Populate the drink name
        etName.setText(client.getClientName());
        etFamily.setText(client.getClientFamily());
        etPhone.setText(client.getPhone());
        etSin.setText(client.getSin());
        etAccountNumber.setText(client.getAccount().getAccountNumber());
        etOpenDate.setText(client.getAccount().getOpenDate());
        etBalance.setText(String. valueOf(client.getAccount().getBalance()));

    }


    private void addClient() {
        String name = etName.getText().toString();
        String family = etFamily.getText().toString();
        String phone = etPhone.getText().toString();
        String sin = etSin.getText().toString();

        String accountNumber = etAccountNumber.getText().toString();
        String openDate = etOpenDate.getText().toString();
        float balance = Float.parseFloat(etBalance.getText().toString());

        Account account = new Account(accountNumber, openDate, balance);
        Client client = new Client(name, family, phone, sin, account);
//        Client.clientList.add(client);

        dataCollection.getClientArray().add(client);
    }


    private void findClient() {
        String sin = etSin.getText().toString();

        for (Client oneClient : MainActivity.clientList) {

            if (oneClient.getSin().equals(sin)) {
                etName.setText(oneClient.getClientName());
                etFamily.setText(oneClient.getClientFamily());
                etPhone.setText(oneClient.getPhone());

                etAccountNumber.setText((oneClient.getAccount().getAccountNumber()));
                etOpenDate.setText(oneClient.getAccount().getOpenDate());
                etBalance.setText(oneClient.getAccount().getBalance() +"");

            }

        }

    }


    private void removeClient() {
        String sin = etSin.getText().toString();

//        for (Client oneClient : MainActivity.clientList) {
//
//            if (oneClient.getSin().equals(sin)) {
//                MainActivity.clientList.remove(oneClient);
//
//            }
//
//        }

        Iterator<Client> iterator = MainActivity.clientList.iterator();
        while (iterator.hasNext()) {
            Client oneClient = iterator.next();

            if (oneClient.getSin().equals(sin)) {
               iterator.remove();
            }
        }

    }


    private void updateClient() {
        String sin = etSin.getText().toString();

        for (Client oneClient : MainActivity.clientList) {

            if (oneClient.getSin().equals(sin)) {

                oneClient.setClientFamily(etFamily.getText().toString());
                oneClient.setClientName(etName.getText().toString());
                oneClient.setPhone(etPhone.getText().toString());


                String accountNumber = etAccountNumber.getText().toString();
                String openDate = etOpenDate.getText().toString();
                float balance =Float.parseFloat( etBalance.getText().toString());

                Account account = new Account(accountNumber, openDate, balance);
                oneClient.setAccount(account);

            }

        }


    }

    private void showAllClient() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bundleContent", dataCollection);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("intentExtra", bundle);
        startActivity(intent);


    }


}
