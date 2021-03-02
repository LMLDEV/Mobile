package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7;
    EditText duree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duree = findViewById(R.id.t1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b1:
                Toast.makeText(this,"Message à durée long",Toast.LENGTH_LONG).show();
                break;
            case R.id.b2:
                Toast.makeText(this,"Message à durée courte",Toast.LENGTH_SHORT).show();
                break;
            case R.id.b3:
                Toast msg = Toast.makeText(this,"Message à durée personnalisée",Toast.LENGTH_LONG);
                Handler hd = new Handler();
                msg.show();
                hd.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            msg.cancel();
                    }
                },Integer.parseInt(duree.getText().toString())*1000);

                break;
            case R.id.b4:
                sendNotification();
                break;
            case R.id.b5:
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setMessage("Message de l'alert à une seule option")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée OK",Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog alert = adb.create();
                alert.show();
                break;
            case R.id.b6:
                adb = new AlertDialog.Builder(this);
                adb.setMessage("Message de l'alert à deux options")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée OK",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée NON",Toast.LENGTH_SHORT).show();
                            }
                        });
                alert = adb.create();
                alert.show();
                break;
            case R.id.b7:
                adb = new AlertDialog.Builder(this);
                adb.setMessage("Message de l'alert à deux options")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée OK",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NON", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée NON",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"option clickée Annuler",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                alert = adb.create();
                alert.show();
                break;
        }
    }

    private void sendNotification() {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
        b.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.web)
                .setTicker("Formation Android")
                .setContentTitle("Notification")
                .setContentText("Bonjour TDI 202")
                .setContentInfo("INFO");
        NotificationManager nm = (NotificationManager)this.getSystemService(this.NOTIFICATION_SERVICE);
        nm.notify(1,b.build());
    }
}