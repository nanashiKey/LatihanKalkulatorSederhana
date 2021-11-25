package com.latihan.latihankalkulatorsederhana;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.ArrayList;

/**
 * created by Irfan Assidiq
 * email : assidiq.irfan@gmail.com
 **/
public class ListBinatang extends AppCompatActivity{
    ListView lvBinatang;
    ArrayList<String> databinatang = new ArrayList<String>();
    AppCompatButton btnTambah;
    AppCompatEditText etInputData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);
        lvBinatang = findViewById(R.id.listView);
        btnTambah = findViewById(R.id.btnTambah);
        etInputData = findViewById(R.id.etInputData);
        registerForContextMenu(lvBinatang);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaBinatang = etInputData.getText().toString();
                ArrayList<String> binatang = new ArrayList<String>();
                if(namaBinatang.isEmpty()){
                    Toast.makeText(ListBinatang.this, "silahkan isi nama binatang terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    etInputData.setText("");
                    databinatang.add(namaBinatang);
                    binatang.addAll(databinatang);
                    populateData(binatang);
                }
            }
        });

    }

    private void populateData(ArrayList<String> binatang){
        databinatang.clear();
        databinatang.addAll(binatang);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                ListBinatang.this, android.R.layout.simple_list_item_1, databinatang
        );
        lvBinatang.setAdapter(arrayAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ctxmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delMenu:{
                deleteData((int) info.id);
                return true;
            }
            case R.id.updMenu:{
                updateData((int) info.id);
                return true;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteData(int position){
        ArrayList<String> binatang = new ArrayList<String>();
        databinatang.remove(position);
        binatang.addAll(databinatang);
        populateData(binatang);
    }

    private void updateData(int position){
        Dialog updateDialog = new Dialog(this);
        updateDialog.setContentView(R.layout.pop_update);
        updateDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        AppCompatEditText etUpdate = updateDialog.findViewById(R.id.etUpdateData);
        AppCompatButton btnUpdate = updateDialog.findViewById(R.id.btnUpdate);
        etUpdate.setText(databinatang.get(position));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namabinatang = etUpdate.getText().toString();
                if(namabinatang.isEmpty()){
                    Toast.makeText(ListBinatang.this, "silahkan isi nama binatang terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> binatang = new ArrayList<String>();
                    databinatang.remove(position);
                    databinatang.add(position, namabinatang);
                    binatang.addAll(databinatang);
                    populateData(binatang);
                    updateDialog.dismiss();
                }
            }
        });
        updateDialog.show();
    }
}
