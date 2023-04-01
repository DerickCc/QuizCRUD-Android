package com.derick.quizcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //config realm
        Realm.init(this);
        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        .allowWritesOnUiThread(true)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(config);

        Button btnLihatBuku = (Button)  findViewById(R.id.btnLihatBuku);
        Button btnTambahBuku = (Button) findViewById(R.id.btnTambahBuku);

        btnLihatBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LihatHapusActivity.class);
                startActivity(intent);
            }
        });

        btnTambahBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });
    }
}