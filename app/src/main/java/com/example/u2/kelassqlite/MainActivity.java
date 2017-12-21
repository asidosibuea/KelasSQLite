package com.example.u2.kelassqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.u2.kelassqlite.data.PersonHelper;
import com.example.u2.kelassqlite.data.PersonKontrak.PersonEntry;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpan(View view){

//        ambil data
        EditText edt_nama = (EditText) findViewById(R.id.et_nama);
        EditText edt_nama_blk = (EditText) findViewById(R.id.et_nama_blk);
        Spinner spin_thn = (Spinner) findViewById(R.id.drop_umur);

        String nama = edt_nama.getText().toString();
        String namaBlk = edt_nama_blk.getText().toString();
        int thn_lahir= Integer.parseInt(spin_thn.getSelectedItem().toString());
        int umur = (2017-thn_lahir);

//  bentuk objek content values -- menngirim data yang akan dimasukin ke tabel
        ContentValues cv = new ContentValues();
        cv.put(PersonEntry.KOLOM_NAMA_DEPAN, nama);
        cv.put(PersonEntry.KOLOM_NAMA_BELAKANG, namaBlk);
        cv.put(PersonEntry.KOLOM_UMUR, umur);

        PersonHelper ph = new PersonHelper(this);
        SQLiteDatabase db = ph.getWritableDatabase();
        long result = db.insert(PersonEntry.NAMA_TABEL,null,cv);
        if (result == -1){
            Toast.makeText(this, "Can't insert to database", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Inserted to database, with id : "+result, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
