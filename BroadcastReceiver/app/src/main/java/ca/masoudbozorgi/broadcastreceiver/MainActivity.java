package ca.masoudbozorgi.broadcastreceiver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERMS_REQ_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For Android 6 (Marshmallow, API 23)and above we have to check permission in runtime and
        // ony using AndroidManifest.xml is not enough
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
            checkPermissions();
        }
    }

    private void checkPermissions() {
        if (!hasPermissionForCallEvent()) {

            // Define an array to save the permissions we need for
            // phone state and outgoing calls event
            String[] perms = new String[]{
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.PROCESS_OUTGOING_CALLS};

            // Request permission with specific code
            ActivityCompat.requestPermissions(this, perms, PERMS_REQ_CODE);
        }
    }

    private boolean hasPermissionForCallEvent() {
        return ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED &&

                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.PROCESS_OUTGOING_CALLS)
                        == PackageManager.PERMISSION_GRANTED;
    }

    // On receiving response for permission request
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {

        // Check if the permission response is for our request code
        if(requestCode == PERMS_REQ_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED &&
               grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Permission granted.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}