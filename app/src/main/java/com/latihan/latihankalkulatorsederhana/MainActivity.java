package com.latihan.latihankalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvNilai1, tvNilai2, tv0, tv1, tv2, tv3, tv4, tv5, tv6, tv7,
            tv8, tv9, tvTambah, tvKali, tvKurang, tvSamadengan, tvBagi, tvC;
    AppCompatEditText etNilai;
    String nilaiAwal = "";
    String nilaiKedua = "";
    int nilai1 = 0;
    int nilai2 = 0;
    String kode = "";
    int hasil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNilai1 = findViewById(R.id.tvNilai1);
        tvNilai2 = findViewById(R.id.tvNilai2);
        tv0 = findViewById(R.id.btn0);
        tv1 = findViewById(R.id.btn1);
        tv2 = findViewById(R.id.btn2);
        tv3 = findViewById(R.id.btn3);
        tv4 = findViewById(R.id.btn4);
        tv5 = findViewById(R.id.btn5);
        tv6 = findViewById(R.id.btn6);
        tv7 = findViewById(R.id.btn7);
        tv8 = findViewById(R.id.btn8);
        tv9 = findViewById(R.id.btn9);
        tvC = findViewById(R.id.btnC);
        tvTambah = findViewById(R.id.btnTambah);
        tvKali = findViewById(R.id.btnKali);
        tvKurang = findViewById(R.id.btnKurang);
        tvBagi = findViewById(R.id.btnBagi);
        tvSamadengan = findViewById(R.id.btnSamadengan);
        etNilai = findViewById(R.id.etNilai);
        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "0";
                etNilai.setText(nilaiAwal);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "1";
                etNilai.setText(nilaiAwal);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "2";
                etNilai.setText(nilaiAwal);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "3";
                etNilai.setText(nilaiAwal);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "4";
                etNilai.setText(nilaiAwal);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "5";
                etNilai.setText(nilaiAwal);
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "6";
                etNilai.setText(nilaiAwal);
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "7";
                etNilai.setText(nilaiAwal);
            }
        });

        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "8";
                etNilai.setText(nilaiAwal);
            }
        });

        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiAwal += "9";
                etNilai.setText(nilaiAwal);
            }
        });

        tvTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilaiAwal.equals("")){
                    Toast.makeText(MainActivity.this,
                            "silahkan masukkan angka awal terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    nilai1 = Integer.parseInt(nilaiAwal);
                    tvNilai1.setText(nilaiAwal);
                    nilaiAwal = "";
                    kode = "+";
                }
            }
        });
        tvKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilaiAwal.equals("")){
                    Toast.makeText(MainActivity.this, "silahkan masukkan angka awal terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    nilai1 = Integer.parseInt(nilaiAwal);
                    tvNilai1.setText(nilaiAwal);
                    nilaiAwal = "";
                    kode = "-";
                }
            }
        });
        tvBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilaiAwal.equals("")){
                    Toast.makeText(MainActivity.this, "silahkan masukkan angka awal terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    nilai1 = Integer.parseInt(nilaiAwal);
                    tvNilai1.setText(nilaiAwal);
                    nilaiAwal = "";
                    kode = "/";
                }
            }
        });
        tvKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilaiAwal.equals("")){
                    Toast.makeText(MainActivity.this, "silahkan masukkan angka awal terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    nilai1 = Integer.parseInt(nilaiAwal);
                    tvNilai1.setText(nilaiAwal);
                    nilaiAwal = "";
                    kode = "x";
                }
            }
        });
        tvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNilai.setText("");
                nilaiAwal = "";
                tvNilai1.setText("");
                tvNilai2.setText("");
            }
        });
        tvSamadengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nilaiAwal.equals("")){
                    Toast.makeText(MainActivity.this, "silahkan masukkan angka awal terlebih dahulu", Toast.LENGTH_SHORT).show();
                }else{
                    nilai2 = Integer.parseInt(nilaiAwal);
                    tvNilai2.setText(nilaiAwal);
                    if (kode.equals("+")) {
                        hasil = nilai1 + nilai2;
                        etNilai.setText(""+hasil);
                    } else if (kode.equals("-")) {
                        hasil = nilai1 - nilai2;
                        etNilai.setText(""+hasil);
                    } else if (kode.equals("x")) {
                        hasil = nilai1 * nilai2;
                        etNilai.setText(""+hasil);
                    }else if (kode.equals("/")) {
                        hasil = nilai1 / nilai2;
                        etNilai.setText(""+hasil);
                    }else {
                        Toast.makeText(MainActivity.this, "belum ada nilai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}