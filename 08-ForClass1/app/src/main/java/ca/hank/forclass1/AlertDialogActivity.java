package ca.hank.forclass1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    Button btnAlertDialog1, btnAlertDialog2, btnAlertDialog3, btnAlertDialog4,btnProgressDialog, btnCustomDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        init();
    }

    public void init(){
        btnAlertDialog1 = findViewById(R.id.btnAlertDialog1);
        btnAlertDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog1(view);
            }
        });
        btnAlertDialog2 = findViewById(R.id.btnAlertDialog2);
        btnAlertDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog2(view);
            }
        });
        btnAlertDialog3 = findViewById(R.id.btnAlertDialog3);
        btnAlertDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog3(view);
            }
        });
        btnAlertDialog4 = findViewById(R.id.btnAlertDialog4);
        btnAlertDialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog4(view);
            }
        });
        btnProgressDialog = findViewById(R.id.btnProgressDialog);
        btnProgressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressDialog(view);
            }
        });
        btnCustomDialog = findViewById(R.id.btnCustomeDialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog(view);
            }
        });

    }

    //AlertDialog.builder onclick
    public void showAlertDialog1(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("This is my title");

        //second argument in below methods is a reference to event listener
        alertDialogBuilder.setPositiveButton("Yes", this);
        alertDialogBuilder.setNegativeButton("No", this);
        alertDialogBuilder.setNeutralButton("Neutral", this);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(AlertDialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(AlertDialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;
            case DialogInterface.BUTTON_NEUTRAL:
                Toast.makeText(AlertDialogActivity.this, "id = " + which, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showAlertDialog2(View view) {

    }

    public void showAlertDialog3(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Question ?").setCancelable(false).setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "i =  " + 1, Toast.LENGTH_SHORT).show();
            }
        }).setPositiveButton("OK", null);
        builder.show();

    }


    public void showAlertDialog4(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("").setCancelable(false).setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"}, new boolean[]{false, true, false, true, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(AlertDialogActivity.this, "item" + i + ": " + b, Toast.LENGTH_SHORT).show();
            }
        }).setPositiveButton("OK", null);

        builder.show();

    }

    public void showProgressDialog(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("progress dialog example");
        progressDialog.setMessage("please wait ...");

//        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);

        progressDialog.show();


        progressDialog.setProgress(0);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog.getProgress() < progressDialog.getMax()) {
                    progressDialog.incrementProgressBy(1);
                } else {
                    progressDialog.dismiss();
                    this.cancel();
                }
            }
        }, 0, 200);


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()) {
                    progressDialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 140);

    }


    public void customDialog(View view){
         Dialog dialog = new Dialog(this);
         dialog.setContentView(R.layout. activity_alert_dialog);
         dialog.show();
    }







}
