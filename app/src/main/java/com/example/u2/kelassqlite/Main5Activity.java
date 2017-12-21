package com.example.u2.kelassqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.u2.kelassqlite.data.PersonHelper;
import com.example.u2.kelassqlite.data.PersonKontrak.PersonEntry;


public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        tampilData();
    }

    public void tampilData(){
        // ambil data dari database --> cursor
        PersonHelper personHelper = new PersonHelper(this);
        SQLiteDatabase sqLiteDatabase = personHelper.getReadableDatabase();

        String[] namaKolom = {
                PersonEntry.KOLOM_NAMA_DEPAN,
                PersonEntry.KOLOM_UMUR
        };

        Cursor cursor = sqLiteDatabase.query(PersonEntry.NAMA_TABEL,
                namaKolom,
                null,
                null,
                null,
                null,
                PersonEntry.KOLOM_NAMA_DEPAN + " ASC"
        );

        //parsing data --> String builder
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()){
            int idx_kolom_nama = cursor.getColumnIndex(PersonEntry.KOLOM_NAMA_DEPAN);
            String nama = cursor.getString(idx_kolom_nama);

            int idx_kolom_umur = cursor.getColumnIndex(PersonEntry.KOLOM_UMUR);
            int umur = cursor.getInt(idx_kolom_umur);

            String hasil = nama +" "+umur +"\n";

            stringBuilder.append(hasil);
        }

        cursor.close();

        //tampilkan data di tempat yang disediakan --> TextView
        TextView tv = (TextView) findViewById(R.id.hasil);
        tv.setText(stringBuilder);
    }
}
