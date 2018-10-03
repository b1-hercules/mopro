package com.example.mikrotik.tugas1_chickendinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
