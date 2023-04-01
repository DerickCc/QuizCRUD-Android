package com.derick.quizcrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.derick.quizcrud.EditActivity;
import com.derick.quizcrud.LihatHapusActivity;
import com.derick.quizcrud.MainActivity;
import com.derick.quizcrud.R;
import com.derick.quizcrud.TambahActivity;
import com.derick.quizcrud.function.CRUDBuku;
import com.derick.quizcrud.model.Buku;

import java.util.List;

public class BukuAdapter extends ArrayAdapter<Buku> {
    public BukuAdapter(Context context, List<Buku> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buku buku = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbuku, parent, false);
        }
        TextView tvIdBuku = (TextView) convertView.findViewById(R.id.tvIdBuku);
        TextView tvJudul = (TextView) convertView.findViewById(R.id.tvJudul);
        TextView tvPengarang = (TextView) convertView.findViewById(R.id.tvPengarang);
        TextView tvPenerbit = (TextView) convertView.findViewById(R.id.tvPenerbit);
        TextView tvTahunTerbit = (TextView) convertView.findViewById(R.id.tvTahunTerbit);

        tvIdBuku.setText(buku.getIdBuku().toString());
        tvJudul.setText(buku.getJudul());
        tvPengarang.setText(buku.getPengarang());
        tvPenerbit.setText(buku.getPenerbit());
        tvTahunTerbit.setText(buku.getTahunTerbit().toString());

        ImageButton btnEdit = (ImageButton)  convertView.findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditActivity.class);
                intent.putExtra("idBuku", String.valueOf(buku.getIdBuku()));
                intent.putExtra("judul", buku.getJudul());
                intent.putExtra("pengarang", buku.getPengarang());
                intent.putExtra("penerbit", buku.getPenerbit());
                intent.putExtra("tahunTerbit", String.valueOf(buku.getTahunTerbit()));
                getContext().startActivity(intent);
            }
        });

        ImageButton btnDelete = (ImageButton)  convertView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDBuku crudBuku = new CRUDBuku();
                crudBuku.deleteBuku(buku.getIdBuku());
            }
        });

        return convertView;
    }
}
