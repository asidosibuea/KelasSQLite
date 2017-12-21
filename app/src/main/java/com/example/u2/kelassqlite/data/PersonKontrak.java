package com.example.u2.kelassqlite.data;

import android.provider.BaseColumns;

/**
 * Created by U2 on 09/11/2017.
 */

public class PersonKontrak {
    public class PersonEntry implements BaseColumns{
        public final static String NAMA_TABEL = "ORANG";
        public final static String KOLOM_NAMA_DEPAN = "namadepan";
        public final static String KOLOM_NAMA_BELAKANG = "namablkg";
        public final static String KOLOM_UMUR = "umur";
    }
}
