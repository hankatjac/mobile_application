package masoud.ca.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import masoud.ca.demo.java8.MethodReferenceExample;
import masoud.ca.demo.java8.StreamOperationsExample;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    EditText editText;

    Button button;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);



        // Approach 1: Create an Object ------------------------------------------------------------
        View.OnClickListener myOnClickListenerObject = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Approach 1: Create and Pass an object",
                        Toast.LENGTH_LONG).show();

                getUserInput();
            }
        };
        button.setOnClickListener(myOnClickListenerObject);
        //------------------------------------------------------------------------------------------



        // Approach 2: Anonymous Inner Class -------------------------------------------------------
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Approach 2: Anonymous Inner class",
                        Toast.LENGTH_LONG).show();

                getUserInput();
            }
        });
        //------------------------------------------------------------------------------------------



        // Approach 3: Lambda Expression -----------------------------------------------------------
        button.setOnClickListener((View view) -> Toast.makeText(MainActivity.this,
                "Approach 3: Lambda Expression",Toast.LENGTH_LONG).show()
        );
        //------------------------------------------------------------------------------------------



        // Approach 4: More common -----------------------------------------------------------------
        button.setOnClickListener(this);
        //------------------------------------------------------------------------------------------
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,
                "Approach 4: More common way",
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void getUserInput() {
        String userInput =  editText.getText().toString();
        textView.setText(userInput);
    }

    // Extra ///////////////////////////////////////////////////////////////////////////////////////

    private void java8Test(){

        // Stream Operation need API 26, and Java 8  must be enabled manually
        new StreamOperationsExample();
        new MethodReferenceExample();
    }

    public void submit(View view) {

        String myName = editText.getText().toString();
        if (myName.equals("")|| myName.equals(null)){
            myName = "No name";
        }

        textView.setText(myName);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                            //
    //                                             Menu                                           //
    //                                                                                            //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Create a submenu: intentSubmenu ---------------------------------------------------------
        SubMenu intentSubmenu = menu.addSubMenu("intent options");

        intentSubmenu.add("Open Browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Define our ACTION_VIEW
                intent.setData(Uri.parse("http://www.google.com"));

                startActivity(intent);

                return false;
            }
        });

        intentSubmenu.add("open sms screen").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                // Define our ACTION_VIEW
                intent.setData(Uri.parse("sms:09123456789"));
                intent.putExtra("sms_body", "Hello from android application.");

                startActivity(intent);
                return false;
            }
        });

        intentSubmenu.add("open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("tel:5145121234"));

                startActivity(intent);
                return false;
            }
        });

        intentSubmenu.add("CameraActivity").setOnMenuItemClickListener((menuItem) -> {

            //<!-- Must Manually add to manifests.xml for using Camera ............................. -->
            //<uses-feature android:name="android.hardware.camera" android:required="true"/>
            //<!-- ................................................................................. -->
            Intent intent = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(intent);
            return false;
        });
        //------------------------------------------------------------------------------------------

        return super.onCreateOptionsMenu(menu);
    }
}







