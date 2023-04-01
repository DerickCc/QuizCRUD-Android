package com.derick.quizcrud.function;

import android.util.Log;

import com.derick.quizcrud.model.Buku;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class CRUDBuku {
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
                }
                catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "Primary Key sudah ada: " + e.getMessage().toString());
                }
            }
        });
    }

    public void updateBuku(Integer idBuku, String judul, String pengarang, String penerbit, Integer tahunTerbit){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", idBuku + "-" + judul + "-" + pengarang + "-" + penerbit + "-" + tahunTerbit);
                    Buku buku = realm.where(Buku.class).equalTo("idBuku", idBuku).findFirst();
                    buku.setJudul(judul);
                    buku.setPengarang(pengarang);
                    buku.setPenerbit(penerbit);
                    buku.setTahunTerbit(tahunTerbit);
                }
                catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "Primary Key sudah ada: " + e.getMessage().toString());
                }
            }
        });
    }

    public void deleteBuku(Integer idBuku){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Buku buku = realm.where(Buku.class).equalTo("idBuku", idBuku).findFirst();
                    buku.deleteFromRealm();
                }
                catch(Exception e){
                    Log.d("TAG", e.getMessage().toString());
                }
            }
        });
    }
}
