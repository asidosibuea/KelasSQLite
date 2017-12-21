package com.example.u2.kelassqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.u2.kelassqlite.data.PersonHelper;
import com.example.u2.kelassqlite.data.PersonKontrak.PersonEntry;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tampilData();
    }

    public void add(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void tampilData(){
        // ambil data dari database --> cursor
        PersonHelper personHelper = new PersonHelper(this);
        SQLiteDatabase sqLiteDatabase = personHelper.getReadableDatabase();

        String[] namaKolom = {
                PersonEntry.KOLOM_NAMA_DEPAN,
                PersonEntry.KOLOM_NAMA_BELAKANG,
                PersonEntry.KOLOM_UMUR
        };

        Cursor cursor = sqLiteDatabase.query(PersonEntry.NAMA_TABEL,
                namaKolom,
                null,
                null,
                null,
                null,
                PersonEntry.KOLOM_UMUR + " DESC"
        );

        //parsing data --> String arrayList<Person>
        ArrayList<Person> listPerson = new ArrayList<>();
        while (cursor.moveToNext()){
            int idx_kolom_nama1 = cursor.getColumnIndex(PersonEntry.KOLOM_NAMA_DEPAN);
            String namadepan = cursor.getString(idx_kolom_nama1);

            int idx_kolom_nama2 = cursor.getColumnIndex(PersonEntry.KOLOM_NAMA_BELAKANG);
            String namablk = cursor.getString(idx_kolom_nama2);


            int idx_kolom_umur = cursor.getColumnIndex(PersonEntry.KOLOM_UMUR);
            String umur = cursor.getString(idx_kolom_umur);


            // buat object person
            Person person = new Person(namadepan, namablk, umur);

            //masukkan ke dalam array list
            listPerson.add(person);
        }

        cursor.close();

        //tampilkan data di tempat yang disediakan --> Listview
        ListView listView = (ListView) findViewById(R.id.list_data);
        PersonAdapter adapter = new PersonAdapter(this, listPerson);
        listView.setAdapter(adapter);
    }
}
