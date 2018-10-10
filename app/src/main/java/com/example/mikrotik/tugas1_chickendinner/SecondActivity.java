package com.example.mikrotik.tugas1_chickendinner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText ayambakar,ayamgeprek,ayammadu,ayamgolek,ayamgoreng,
             esdawet,esteh,jusmelon,soda;
    Button pesan, cekharga;
    int ayam_bakar = 20000,ayam_geprek=15000,ayam_madu=18000,ayam_golek=25000,ayam_goreng=12000,
        es_dawet=8000,es_teh=5000,jus_melon=7000,essoda=10000;
    int yambakar,yamgeprek,yammadu,yamgolek,yamgoreng,sdawet,steh,smelon,ssoda;
    TextView sum;
    CardView cv_ayambakar,cv_ayamgeprek,cv_ayammadu,cv_ayamgolek,cv_ayamgoreng,
            cv_esdawet,cv_esteh,cv_jusmelon,cv_soda;

    String googleMap = "com.google.android.apps.maps";
    String chicken_dinner="-6.9154479,107.6596951";
    Uri gmmIntentUri;
    Intent mapIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ayambakar = findViewById(R.id.txtayambakar);
        ayamgeprek = findViewById(R.id.txtayamgeprek);
        ayammadu = findViewById(R.id.txtayammadu);
        ayamgolek = findViewById(R.id.txtayamgolek);
        ayamgoreng = findViewById(R.id.txtayamgoreng);
        esdawet = findViewById(R.id.txtesdawet);
        esteh = findViewById(R.id.txtesteh);
        jusmelon = findViewById(R.id.txtjusmelon);
        soda = findViewById(R.id.txtsoda);
        cekharga = findViewById(R.id.btncekharga);
        pesan = findViewById(R.id.btnpesan);
        sum = findViewById(R.id.txttampilharga);

        cv_ayambakar = findViewById(R.id.cvayambakar);
        cv_ayamgeprek = findViewById(R.id.cvayamgeprek);
        cv_ayammadu = findViewById(R.id.cvayammadu);
        cv_ayamgolek = findViewById(R.id.cvayamgolek);
        cv_ayamgoreng = findViewById(R.id.cvayamgoreng);
        cv_esdawet = findViewById(R.id.cvesdawet);
        cv_esteh = findViewById(R.id.cvesteh);
        cv_jusmelon = findViewById(R.id.cvjusmelon);
        cv_soda = findViewById(R.id.cvsoda);

        registerForContextMenu(cv_ayambakar);
        registerForContextMenu(cv_ayamgeprek);
        registerForContextMenu(cv_ayammadu);
        registerForContextMenu(cv_ayamgolek);
        registerForContextMenu(cv_ayamgoreng);
        registerForContextMenu(cv_esdawet);
        registerForContextMenu(cv_esteh);
        registerForContextMenu(cv_jusmelon);
        registerForContextMenu(cv_soda);

        cekharga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yambakar = Integer.valueOf(ayambakar.getText().toString());
                yamgeprek = Integer.valueOf(ayamgeprek.getText().toString());
                yammadu = Integer.valueOf(ayammadu.getText().toString());
                yamgolek = Integer.valueOf(ayamgolek.getText().toString());
                yamgoreng = Integer.valueOf(ayamgoreng.getText().toString());
                sdawet = Integer.valueOf(esdawet.getText().toString());
                steh = Integer.valueOf(esteh.getText().toString());
                smelon = Integer.valueOf(jusmelon.getText().toString());
                ssoda = Integer.valueOf(soda.getText().toString());
                int jumlah = 0;
                jumlah = (yambakar*ayam_bakar) + (yamgeprek*ayam_geprek) + (yammadu*ayam_madu) + (yamgolek*ayam_golek) + (yamgoreng*ayam_goreng) + (sdawet*es_dawet) + (steh*es_teh) + (smelon*jus_melon)+(ssoda*essoda);
                sum.setText(String.valueOf(jumlah));
            }
        });

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"Terimakasih sudah memesan", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"1");
        menu.add(0,v.getId(),0,"2");
        menu.add(0,v.getId(),0,"3");
        menu.add(0,v.getId(),0,"4");
        menu.add(0,v.getId(),0,"5");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int angkaContexMenu = Integer.valueOf(item.getTitle().toString());
        if (item.getItemId() == R.id.cvayambakar) {
            ayambakar.setText(item.getTitle().toString());
        } else if ((item.getItemId() == R.id.cvayamgeprek)) {
            ayamgeprek.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvayammadu)) {
            ayammadu.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvayamgolek)) {
            ayamgolek.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvayamgoreng)) {
            ayamgoreng.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvesdawet)) {
            esdawet.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvesteh)) {
            esteh.setText(item.getTitle().toString());

        }
        else if ((item.getItemId() == R.id.cvjusmelon)) {
            jusmelon.setText(item.getTitle().toString());

        }else if ((item.getItemId() == R.id.cvsoda)) {
            soda.setText(item.getTitle().toString());

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);

      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.awal){
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.phone) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "085259322368"));
            startActivity(intent);
        } else if (item.getItemId() == R.id.lokasi) {
            gmmIntentUri = Uri.parse("google.navigation:q=" + chicken_dinner);
            mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage(googleMap);
            if (mapIntent.resolveActivity(getPackageManager()) !=null){
                startActivity(mapIntent);
            } else {
                Toast.makeText(SecondActivity.this, "Google maps is not installed", Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }
}
