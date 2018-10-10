package com.example.mikrotik.tugas1_chickendinner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button menu, telepon, lokasi;
    String gooogleMap = "com.google.android.apps.maps"; // identitas package aplikasi google masps android
    Uri gmmIntentUri;
    Intent mapIntent;
    String chicken_dinner="-6.9154479,107.6596951";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.btnmenu);
        lokasi = findViewById(R.id.btnlokasi);
        telepon = findViewById(R.id.btntelepon);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmmIntentUri = Uri.parse("google.navigation:q=" + chicken_dinner);
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(gooogleMap);
                if (mapIntent.resolveActivity(getPackageManager()) !=null){
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Google maps is not installed", Toast.LENGTH_LONG).show();
                }
            }
        });

        telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "085259322368"));
                startActivity(intent);
            }
        });
    }
}
