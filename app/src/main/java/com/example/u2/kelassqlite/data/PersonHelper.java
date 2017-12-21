package com.example.u2.kelassqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.u2.kelassqlite.data.PersonKontrak.PersonEntry;

/**
 * Created by U2 on 09/11/2017.
 */

public class PersonHelper extends SQLiteOpenHelper {

    private static final String NAMA_DB = "orang.db";
    private static final int VERSION_DB = 2;

    public PersonHelper(Context context) {
        super(context, NAMA_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_SYNTAX = "CREATE TABLE "+PersonEntry.NAMA_TABEL+" (\n" +
                PersonEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                PersonEntry.KOLOM_NAMA_DEPAN +" TEXT NOT NULL,\n" +
                PersonEntry.KOLOM_NAMA_BELAKANG +" TEXT NOT NULL,\n" +
                PersonEntry.KOLOM_UMUR+" INTEGER NOT NULL DEFAULT 0 \n" +
                ");";
        db.execSQL(CREATE_SYNTAX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = "DROP TABLE IF EXISTS "+PersonEntry.NAMA_TABEL+";";
        db.execSQL(drop);
        onCreate(db);
    }

}
