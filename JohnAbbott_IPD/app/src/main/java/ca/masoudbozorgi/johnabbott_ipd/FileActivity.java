package ca.masoudbozorgi.johnabbott_ipd;

import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import ca.masoudbozorgi.johnabbott_ipd.file.FileManager;

public class FileActivity extends AppCompatActivity implements View.OnClickListener {

    // Permissions we need in AndroidManifest.xml
    // <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    // <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

    int REQUEST_CODE = 1;

    EditText editText;

    Button writeStringPrivateExternalStorageBtn,
           readStringPrivateExternalStorageBtn,

           writeStringPublicExternalStorageBtn,
           readStringPublicExternalStorageBtn,

           writeObjectPrivateExternalStorageBtn,
           readObjectPrivateExternalStorageBtn,
           clearBtn;

    File file_object_private_external_storage,
            file_string_private_external_storage,
            file_string_public_external_storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        initialize();
        storagePermissionRequest();

        /*
        *
        * Internal Storage
        *
        * It's always available. Files saved here are accessible by only your app.
        * When the user uninstalls your app, the system removes
        * all your app's files from internal storage.
        *
        * Internal storage is best when you want to be sure that
        * neither the user nor other apps can access your files.
        *
        *
        *
        * External Storage
        *
        * It's not always available, because the user can mount the external storage
        * as USB storage and in some cases remove it from the device.
        *
        * It's world-readable, so files saved here may be read outside of your control.
        *
        * When the user uninstalls your app, the system removes your app's files
        * from here only if you save them in the directory from getExternalFilesDir().
        *
        * External storage is the best place for files that don't require access restrictions and
        * for files that you want to share with other apps or allow the user to access with a computer.
        *
        * */

        createFileInExternalStoragePrivateDirectory();
        createFileInExternalStoragePublicDirectory();
    }

    private void initialize() {

        editText = findViewById(R.id.editText);

        writeStringPrivateExternalStorageBtn = findViewById(R.id.writeStringPrivateExternalStorageBtn);
        writeStringPrivateExternalStorageBtn.setOnClickListener(this);

        readStringPrivateExternalStorageBtn = findViewById(R.id.readStringPrivateExternalStorageBtn);
        readStringPrivateExternalStorageBtn.setOnClickListener(this);

        writeStringPublicExternalStorageBtn = findViewById(R.id.writeStringPublicExternalStorageBtn);
        writeStringPublicExternalStorageBtn.setOnClickListener(this);

        readStringPublicExternalStorageBtn = findViewById(R.id.readStringPublicExternalStorageBtn);
        readStringPublicExternalStorageBtn.setOnClickListener(this);

        writeObjectPrivateExternalStorageBtn = findViewById(R.id.writeObjectPrivateExternalStorageBtn);
        writeObjectPrivateExternalStorageBtn.setOnClickListener(this);

        readObjectPrivateExternalStorageBtn = findViewById(R.id.readObjectPrivateExternalStorageBtn);
        readObjectPrivateExternalStorageBtn.setOnClickListener(this);

        clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);
    }

    private void storagePermissionRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
                REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE){
            if (grantResults[0]== PackageManager.PERMISSION_DENIED){
                Toast.makeText(this,
                        "Permission Denied",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this,
                        "Permission Granted",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    // If you want to save files on external storage and want to make it private to your app and
    // not accessible by the other apps like MediaStore content provider,
    // you can have to use getExternalFilesDir()
    private void createFileInExternalStoragePrivateDirectory() {


        // On Android 6.0 (API level 23) and lower, other apps can read your internal files
        // if you set the file mode to be world readable.
        // However, the other app must know your app package name and file names.
        // Other apps cannot browse your internal directories and do not have read or write access
        // unless you explicitly set the files to be readable or writable.

        // Remember that getExternalFilesDir() creates a directory that will be
        // deleted when the user uninstalls your app because it is not public
        file_object_private_external_storage = FileManager.createFile(getExternalFilesDir("private_file"),
                "file_object_private_external_storage");
        file_string_private_external_storage = FileManager.createFile(getExternalFilesDir("private_file"),
                "file_string_private_external_storage");
    }

    private void createFileInExternalStoragePublicDirectory() {
        // ExternalStoragePublicDirectory can be DIRECTORY_PICTURES or DIRECTORY_MUSIC
        file_string_public_external_storage =
                FileManager.createFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "file_string_public_external_storage");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            // String ------------------------------------------------------------------------------
                // private .......................
            case R.id.writeStringPrivateExternalStorageBtn:
                FileManager.saveByte(file_string_private_external_storage,
                        editText.getText().toString());
                break;
            case R.id.readStringPrivateExternalStorageBtn:
                editText.setText("Read Private External Storage String: " +
                        FileManager.loadByte(file_string_private_external_storage));
                break;

                // public .......................
            case R.id.writeStringPublicExternalStorageBtn:
                FileManager.saveByte(file_string_public_external_storage,
                        editText.getText().toString());
                break;
            case R.id.readStringPublicExternalStorageBtn:
                editText.setText("Read Public External Storage String: " +
                        FileManager.loadByte(file_string_public_external_storage));
                break;
            // -------------------------------------------------------------------------------------



            // Object ------------------------------------------------------------------------------
            case R.id.writeObjectPrivateExternalStorageBtn:
                FileManager.saveObject(file_object_private_external_storage,
                        new StringBuilder(editText.getText().toString()));
                break;
            case R.id.readObjectPrivateExternalStorageBtn:
                editText.setText("Read Private External Storage Object: " +
                        FileManager.loadObject(file_object_private_external_storage).toString());
                break;
            // -------------------------------------------------------------------------------------


            case R.id.clearBtn:
                editText.setText(null);
                break;
        }
    }
}