package com.derick.quizcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.derick.quizcrud.adapter.BukuAdapter;
import com.derick.quizcrud.model.Buku;

import java.util.ArrayList;
import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmResults;

public class LihatHapusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_hapus);
        Objects.requireNonNull(getSupportActionBar()).hide();

        //tarik data pengguna
        Realm realm = Realm.getDefaultInstance();
        //penarikan data
        RealmResults<Buku> daftarBuku = realm.where(Buku.class).findAll();

        ArrayList<Buku> arrayOfUser = new ArrayList<Buku>();
        arrayOfUser.addAll(realm.copyFromRealm(daftarBuku));

        realm.close();

        BukuAdapter bukuAdapter = new BukuAdapter(this,arrayOfUser);
        ListView listView = (ListView) findViewById(R.id.listViewBuku);
        listView.setAdapter(bukuAdapter);
    }
}