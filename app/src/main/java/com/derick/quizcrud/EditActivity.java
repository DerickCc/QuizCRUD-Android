package com.derick.quizcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.derick.quizcrud.function.CRUDBuku;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    EditText etJudulE, etPengarangE, etPenerbitE, etTahunTerbitE;
    TextView etIdBukuE;
    Button btnSimpanE;

    Integer idBuku;
    String judul = "";
    String pengarang = "";
    String penerbit = "";
    Integer tahunTerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etIdBukuE = (TextView) findViewById(R.id.etIdBukuE);
        etJudulE = (EditText) findViewById(R.id.etJudulE);
        etPengarangE = (EditText) findViewById(R.id.etPengarangE);
        etPenerbitE = (EditText) findViewById(R.id.etPenerbitE);
        etTahunTerbitE = (EditText) findViewById(R.id.etTahunTerbitE);

        etIdBukuE.setText(getIntent().getStringExtra("idBuku"));
        etJudulE.setText(getIntent().getStringExtra("judul"));
        etPengarangE.setText(getIntent().getStringExtra("pengarang"));
        etPenerbitE.setText(getIntent().getStringExtra("penerbit"));
        etTahunTerbitE.setText(getIntent().getStringExtra("tahunTerbit"));

        btnSimpanE = (Button) findViewById(R.id.btnSimpanE);

        btnSimpanE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", idBuku + "-" + judul + "-" + pengarang + "-" + penerbit + "-" + tahunTerbit);
                idBuku = Integer.parseInt(etIdBukuE.getText().toString());
                judul = etJudulE.getText().toString();
                pengarang = etPengarangE.getText().toString();
                penerbit = etPenerbitE.getText().toString();
                tahunTerbit = Integer.parseInt(etTahunTerbitE.getText().toString());

                CRUDBuku crudBuku = new CRUDBuku();
                crudBuku.updateBuku(idBuku, judul, pengarang, penerbit, tahunTerbit);
            }
        });

    }
}