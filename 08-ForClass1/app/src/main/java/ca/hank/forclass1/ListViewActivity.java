package ca.hank.forclass1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();
    }

    private void init(){
        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("item 1", "item 2", "item 3", "item 4"));

        initializeListView();

    }

    private void initializeListView(){
        // define an ArrayAdapter
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        // set ArrayAdapter for List
        listView.setAdapter(stringArrayAdapter);
    }
}
