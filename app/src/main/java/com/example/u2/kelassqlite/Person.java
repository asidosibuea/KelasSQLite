package com.example.u2.kelassqlite;

/**
 * Created by U2 on 16/11/2017.
 */

public class Person {
    private String namaDpn, namaBlk, umur;

    public Person(String namaDpn, String namaBlk, String umur) {
        this.namaDpn = namaDpn;
        this.namaBlk = namaBlk;
        this.umur = umur;
    }

    public String getNamaDpn() {
        return namaDpn;
    }

    public String getNamaBlk() {
        return namaBlk;
    }

    public String getUmur() {
        return umur;
    }
}
