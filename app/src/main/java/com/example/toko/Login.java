package com.example.toko;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button login;
    TextView un, pass;
    Preferences sharedPreferences;
    Context mContext;

    String nama, jabatan;
    boolean saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        un = findViewById(R.id.t_user);
        pass = findViewById(R.id.t_pass);
        nama = "Andi Setiawan Budi";
        jabatan = "Pengelola";
        login = findViewById(R.id.b_login);
        sharedPreferences = new Preferences(this);
        mContext=this;

        if(sharedPreferences.getLogged()){
            startActivity(new Intent(getApplicationContext(), Nav.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (un.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    saveData();
                    startActivity(new Intent(getApplicationContext(), Nav.class));
                    finish();
                }else{
                    Toast.makeText(mContext,"Username dan password salah !",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }

    public void saveData() {
        sharedPreferences.saveString(sharedPreferences.NAMA, nama);
        sharedPreferences.saveString(sharedPreferences.JABATAN, jabatan);
        sharedPreferences.saveBoolean(sharedPreferences.LOGGED, true);
    }

}


