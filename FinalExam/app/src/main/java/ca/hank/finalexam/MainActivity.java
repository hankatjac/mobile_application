package ca.hank.finalexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView ivBank;
    ListView lvClient;

    public static List<Client> clientList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMyIntent();
        init();
    }


    private void init() {
        ivBank = findViewById(R.id.ivAddClient);
        ivBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

        lvClient = findViewById(R.id.lvClient);

        if (clientList.size() == 0) {

            clientList.add(new Client("Tom", "Cat", "111-111-1111", "654321", new Account("000", "2019-01-01", 0)));
            clientList.add(new Client("Snoopy", "Dog", "222-222-222", "654322", new Account("002", "2019-01-01", 1000)));
            clientList.add(new Client("Jerry", "Mouse", "333-333-3333", "654323", new Account("003", "2019-01-01", 1200)));
        }
//        Arrays.sort(Client.clients);
        Collections.sort(clientList);

        // 2- Create an Adapter for ListView
        ArrayAdapter<Client> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clientList);
        // 3- Assign the Adapter to the list view
        lvClient.setAdapter(listAdapter);



        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {      // Row id of the underlying data

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CLIENTID, (int) id);
                startActivity(intent);
            }
        };

        // 3- Add the listener to the list view
        lvClient.setOnItemClickListener(itemClickListener);


        AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, WithdrawActivity.class);
                intent.putExtra(DetailActivity.EXTRA_CLIENTID, (int) id);
                for (Client client : clientList) {
                    if (lvClient.getItemAtPosition(position).toString().equals(client.toString())) {
                        intent.putExtra("selectedClient", client);
                    }
                }
                startActivityForResult(intent,1);
                return true;

            }
        };

        lvClient.setOnItemLongClickListener(onItemLongClickListener);

    }


    private void getMyIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("intentExtra");
        if (bundle != null) {

            Serializable bundleContent = bundle.getSerializable("bundleContent");
            DataCollection dataCollection = (DataCollection) bundleContent;

            clientList.addAll(dataCollection.getClientArray());
//            Client.clientList = new ArrayList<Client>(dataCollection.getClientArray());
//        System.out.println(Client.clientList);

        }


    }



}
