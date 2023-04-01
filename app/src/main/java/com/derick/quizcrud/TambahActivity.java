package com.derick.quizcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.derick.quizcrud.model.Buku;

import java.util.Objects;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class TambahActivity extends AppCompatActivity {

    EditText etIdBuku, etJudul, etPengarang, etPenerbit, etTahunTerbit;
    Button btnSimpan;

    Integer idBuku;
    String judul = "";
    String pengarang = "";
    String penerbit = "";
    Integer tahunTerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etIdBuku = (EditText) findViewById(R.id.etIdBuku);
        etJudul = (EditText) findViewById(R.id.etJudul);
        etPengarang = (EditText) findViewById(R.id.etPengarang);
        etPenerbit = (EditText) findViewById(R.id.etPenerbit);
        etTahunTerbit = (EditText) findViewById(R.id.etTahunTerbit);

        btnSimpan = (Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", idBuku + "-" + judul + "-" + pengarang + "-" + penerbit + "-" + tahunTerbit);
                idBuku = Integer.parseInt(etIdBuku.getText().toString());
                judul = etJudul.getText().toString();
                pengarang = etPengarang.getText().toString();
                penerbit = etPenerbit.getText().toString();
                tahunTerbit = Integer.parseInt(etTahunTerbit.getText().toString());
                tambahBuku(idBuku, judul, pengarang, penerbit, tahunTerbit);
            }
        });
    }
    public void tambahBuku(Integer idBuku, String judul, String pengarang, String penerbit, Integer tahunTerbit){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", idBuku + "-" + judul + "-" + pengarang + "-" + penerbit + "-" + tahunTerbit);
                    Buku buku = realm.createObject(Buku.class, idBuku);
                    buku.setJudul(judul);
                    buku.setPengarang(pengarang);
                    buku.setPenerbit(penerbit);
                    buku.setTahunTerbit(tahunTerbit);
                    finish();
                }
                catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "Primary Key sudah ada: " + e.getMessage().toString());
                }
            }
        });

    }

}