package com.example.u2.kelassqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by U2 on 16/11/2017.
 */

public class PersonAdapter extends ArrayAdapter<Person> {


    public PersonAdapter(@NonNull Context context, @NonNull List<Person> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        Person p =getItem(position);
        TextView namaDpn = (TextView) convertView.findViewById(R.id.tv_nm_dpn);
        TextView namaBlk = (TextView) convertView.findViewById(R.id.tv_nm_blk);
        TextView umur = (TextView) convertView.findViewById(R.id.tv_umur);

        namaDpn.setText(p.getNamaDpn());
        namaBlk.setText(p.getNamaBlk());
        umur.setText(p.getUmur());

        return convertView;
    }
}
